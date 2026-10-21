package com.Saas.service;

import com.Saas.domain.UserRole;
import com.Saas.modal.User;
import com.Saas.payload.dto.UserDto;

import java.util.List;

public interface EmployeeService {

    UserDto createStoreEmployee(UserDto employee, Long storeId) throws Exception;
    UserDto createBranchEmployee(UserDto employee, Long branchId) throws Exception;
    User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception;
    void deleteEmployee(Long employeeId) throws Exception;
    List<UserDto> findStoreEmployee(Long storeId, UserRole role) throws Exception;
    List<UserDto> findBranchEmployee(Long branchId, UserRole role) throws Exception;

}
