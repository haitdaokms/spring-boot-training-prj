package com.kms.training.trainingproject.repository;

import com.kms.training.trainingproject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity getRoleEntityByRoleName(String roleName);
}
