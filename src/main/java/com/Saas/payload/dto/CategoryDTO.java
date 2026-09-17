package com.Saas.payload.dto;

import com.Saas.modal.Store;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {

    private Long id;

    private String name;

//    private Store store;

    private Long storeId;

}
