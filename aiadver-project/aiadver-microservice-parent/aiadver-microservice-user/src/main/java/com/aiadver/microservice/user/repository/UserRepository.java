package com.aiadver.microservice.user.repository;

import com.aiadver.boot.data.jpa.base.BaseRepository;
import com.aiadver.microservice.user.entity.User;

/**
 * @author george
 */
public interface UserRepository extends BaseRepository<User, Long> {
}
