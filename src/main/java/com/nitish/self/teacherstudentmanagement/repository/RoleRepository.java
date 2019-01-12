package com.nitish.self.teacherstudentmanagement.repository;

import com.nitish.self.teacherstudentmanagement.model.Role;
import com.nitish.self.teacherstudentmanagement.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByName(RoleName roleName);
}
