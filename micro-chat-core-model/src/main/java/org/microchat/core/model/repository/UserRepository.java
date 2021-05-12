package org.microchat.core.model.repository;

import org.microchat.core.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
    Set<User> findByCode(String code);
}
