package com.Saas.payload.dto;

import com.Saas.modal.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class BranchDTO {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private List<String> workingDays;

    private LocalTime openTime;

    private LocalTime closeTime;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private StoreDTO store;

    private Long storeId;

    private UserDto manager;

}
