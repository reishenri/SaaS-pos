package com.Saas.service.impl;

import com.Saas.mapper.InventoryMapper;
import com.Saas.modal.Branch;
import com.Saas.modal.Inventory;
import com.Saas.modal.Product;
import com.Saas.payload.dto.InventoryDTO;
import com.Saas.repository.BranchRepository;
import com.Saas.repository.InventoryRepository;
import com.Saas.repository.ProductRepository;
import com.Saas.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception {

        Branch branch=branchRepository.findById(inventoryDTO.getBranchId())
                .orElseThrow(
                () -> new Exception("branch not exist")
                );
        Product product=productRepository.findById(inventoryDTO.getProductId())
                .orElseThrow(
                        () -> new Exception("product not exist")
                );

        Inventory inventory= InventoryMapper.toEntity(inventoryDTO, branch,product);
        Inventory savedInventory=inventoryRepository.save(inventory);
        return InventoryMapper.toDTO(savedInventory);
    }

    @Override
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception {
        Inventory inventory= inventoryRepository.findById(id).orElseThrow(
                ()-> new Exception("Inventory not found")
        );

        inventory.setQuantity(inventoryDTO.getQuantity());
        Inventory updateInventory=inventoryRepository.save(inventory);
        return InventoryMapper.toDTO(updateInventory);
    }

    @Override
    public void deleteInventory(Long id) throws Exception {
        Inventory inventory= inventoryRepository.findById(id).orElseThrow(
                ()-> new Exception("Inventory not found")
        );
        inventoryRepository.delete(inventory);
    }

    @Override
    public InventoryDTO getInventoryById(Long id) throws Exception {
        Inventory inventory= inventoryRepository.findById(id).orElseThrow(
                ()-> new Exception("Inventory not found")
        );
        return InventoryMapper.toDTO(inventory);
    }

    @Override
    public InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId) {
        Inventory inventory=inventoryRepository.findByProductIdAndBranchId(productId, branchId);

        return InventoryMapper.toDTO(inventory);
    }

    @Override
    public List<InventoryDTO> getAllInventoryByBranchId(Long branchId) {
        List<Inventory> inventories=inventoryRepository.findByBranchId(branchId);

        return inventories.stream().map(
                InventoryMapper::toDTO
        ).collect(Collectors.toList());
    }
}
