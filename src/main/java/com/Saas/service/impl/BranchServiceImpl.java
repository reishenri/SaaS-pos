package com.Saas.service.impl;

import com.Saas.exception.UserException;
import com.Saas.mapper.BranchMapper;
import com.Saas.modal.Branch;
import com.Saas.modal.Store;
import com.Saas.modal.User;
import com.Saas.payload.dto.BranchDTO;
import com.Saas.repository.BranchRepository;
import com.Saas.repository.StoreRepository;
import com.Saas.repository.UserRepository;
import com.Saas.service.BranchService;
import com.Saas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) throws UserException {
        User CurrentUser = userService.getCurrentUser();
        Store store = storeRepository.findByStoreAdminId(CurrentUser.getId());

        Branch branch = BranchMapper.toEntity(branchDTO, store);
        Branch savedBranch = branchRepository.save(branch);

        return BranchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) throws Exception {

        Branch existing=branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist")
        );

        existing.setName(branchDTO.getName());
        existing.setWorkingDays(branchDTO.getWorkingDays());
        existing.setEmail(branchDTO.getEmail());
        existing.setPhone(branchDTO.getPhone());
        existing.setAddress(branchDTO.getAddress());
        existing.setOpenTime(branchDTO.getOpenTime());
        existing.setCloseTime(branchDTO.getCloseTime());
        existing.setUpdatedAt(branchDTO.getUpdatedAt());

        Branch upatedBranch=branchRepository.save(existing);

        return BranchMapper.toDTO(upatedBranch);
    }

    @Override
    public void deleteBranch(Long id) throws Exception {

        Branch existing=branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist")
        );
        branchRepository.delete(existing);
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        List<Branch> branches=branchRepository.findByStoreId(storeId);
        return branches.stream().map(BranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(Long id) throws Exception {
        Branch existing=branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist")
        );
        return BranchMapper.toDTO(existing);
    }
}
