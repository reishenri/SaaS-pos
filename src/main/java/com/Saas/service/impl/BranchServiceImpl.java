package com.Saas.service.impl;

import com.Saas.modal.Store;
import com.Saas.modal.User;
import com.Saas.payload.dto.BranchDTO;
import com.Saas.repository.BranchRepository;
import com.Saas.repository.StoreRepository;
import com.Saas.repository.UserRepository;
import com.Saas.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO, User user) {
        Store store = storeRepository.findByStoreAdminId(user.getId())
        return null;
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) {
        return null;
    }

    @Override
    public BranchDTO deleteBranch(Long id) {
        return null;
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public BranchDTO getBranchById(Long id) {
        return null;
    }
}
