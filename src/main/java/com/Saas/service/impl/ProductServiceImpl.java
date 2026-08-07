package com.Saas.service.impl;

import com.Saas.mapper.ProductMapper;
import com.Saas.modal.Product;
import com.Saas.modal.Store;
import com.Saas.modal.User;
import com.Saas.payload.dto.ProductDTO;
import com.Saas.repository.ProductRepository;
import com.Saas.repository.StoreRepository;
import com.Saas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {
        Store store = storeRepository.findById(
                productDTO.getStoreId()
        ).orElseThrow(
                () -> new Exception("Store not found")
        );

        Product product = ProductMapper.toEntity(productDTO, store);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long Id, ProductDTO productDTO, User user) throws Exception {
        Product product = productRepository.findById(Id).orElseThrow(
                () -> new Exception("product not found")
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setMrp(productDTO.getMrp());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setBrand(productDTO.getBrand());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long Id, User user) throws Exception {

        Product product = productRepository.findById(Id).orElseThrow(
                () -> new Exception ("product not found")
        );

        productRepository.delete(product);

    }

    @Override
    public List<ProductDTO> getProductsByStoreId(Long StoreId) {
        List<Product> products = productRepository.findByStoreId(StoreId);

        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
        List<Product> products = productRepository.searchByKeyword(storeId, keyword);

        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
