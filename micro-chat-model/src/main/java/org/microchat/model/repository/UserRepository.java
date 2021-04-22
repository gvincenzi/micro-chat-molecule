package org.microchat.model.repository;

import org.microchat.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
    Set<User> findByCode(String code);
}
