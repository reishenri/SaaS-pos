package com.Saas.mapper;

import com.Saas.modal.Category;
import com.Saas.payload.dto.CategoryDTO;

public class CategoryMapper {
    public static Category toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .storeId(category.getStore()!=null?category.getStore().getId():null)
                .build();
    }
}
