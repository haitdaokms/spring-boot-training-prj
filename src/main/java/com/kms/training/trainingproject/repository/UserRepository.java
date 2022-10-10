package com.kms.training.trainingproject.repository;

import com.kms.training.trainingproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getUserEntityByUserName(String userName);
}
