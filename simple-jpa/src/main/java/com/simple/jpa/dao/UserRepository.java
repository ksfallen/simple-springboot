package com.simple.jpa.dao;

import com.simple.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: Jfeng
 * Date: 2017/6/2
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
