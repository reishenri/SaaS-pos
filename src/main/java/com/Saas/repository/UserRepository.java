package com.Saas.repository;

import com.Saas.domain.UserRole;
import com.Saas.modal.Store;
import com.Saas.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByStore(Store store);
    List<User> findByBranchId(Long branchId);
}
