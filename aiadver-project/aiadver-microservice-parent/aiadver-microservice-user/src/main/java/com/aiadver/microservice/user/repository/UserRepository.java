package com.aiadver.microservice.user.repository;

import com.aiadver.microservice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author george
 */
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {
}
