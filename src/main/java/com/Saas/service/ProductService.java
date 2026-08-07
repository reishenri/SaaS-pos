package com.Saas.service;

import com.Saas.modal.User;
import com.Saas.payload.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;
    ProductDTO updateProduct(Long Id, ProductDTO productDTO, User user) throws Exception;
    void deleteProduct(Long Id, User user) throws Exception;
    List<ProductDTO> getProductsByStoreId(Long StoreId);
    List<ProductDTO> searchByKeyword(Long storeId, String keyword);

}
