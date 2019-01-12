package com.nitish.self.teacherstudentmanagement.repository;

import com.nitish.self.teacherstudentmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    @Query(value = "select * from users u inner join user_roles ur on ur.user_id = u.id where ur.role_id = :roleId", nativeQuery = true)
    List<User> findAllByRoles(@PathVariable("role")Long roleId);

    Optional<User> findByUsernameAndId(String username, Long id);

    Optional<User> findByEmailAndId(String email, Long id);

}
