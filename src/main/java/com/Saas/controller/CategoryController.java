package com.Saas.controller;

import com.Saas.payload.dto.CategoryDTO;
import com.Saas.payload.response.ApiResponse;
import com.Saas.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
            @RequestBody CategoryDTO categoryDTO) throws Exception {
        return ResponseEntity.ok(
                categoryService.createCategory(categoryDTO)
        );
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDTO>> getCategoryById(
            @PathVariable Long storeId) throws Exception {
        return ResponseEntity.ok(
                categoryService.getAllCategoriesByStory(storeId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @RequestBody CategoryDTO categoryDTO,
            @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(
                categoryService.updateCategory(id, categoryDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(
            @RequestBody CategoryDTO categoryDTO,
            @PathVariable Long id) throws Exception {

        categoryService.updateCategory(id, categoryDTO);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Category deleted");

        return ResponseEntity.ok(
            apiResponse
        );
    }
}
