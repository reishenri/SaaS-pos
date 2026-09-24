package com.Saas.controller;

import com.Saas.exception.UserException;
import com.Saas.modal.Branch;
import com.Saas.payload.dto.BranchDTO;
import com.Saas.payload.response.ApiResponse;
import com.Saas.service.BranchService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches")
public class BranchController {
    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) throws UserException {
        BranchDTO createdBranch=branchService.createBranch(branchDTO);

        return ResponseEntity.ok().body(createdBranch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(
            @PathVariable Long id
    ) throws Exception {
        BranchDTO createdBranch=branchService.getBranchById(id);

        return ResponseEntity.ok().body(createdBranch);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<BranchDTO>> getAllBranchesStoreId(
            @PathVariable Long storeId
    ) throws Exception {

        List<BranchDTO> createdBranch=branchService.getAllBranchesByStoreId(storeId);
        return ResponseEntity.ok().body(createdBranch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(
            @PathVariable Long id,
            @RequestBody BranchDTO branchDTO
    ) throws Exception {

        BranchDTO createdBranch=branchService.updateBranch(id, branchDTO);
        return ResponseEntity.ok().body(createdBranch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBranchById(
            @PathVariable Long id
    ) throws Exception {

        branchService.deleteBranch(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("branch deleted successfully");
        return ResponseEntity.ok().body(apiResponse);
    }

}
