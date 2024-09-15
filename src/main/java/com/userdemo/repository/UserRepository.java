package com.userdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userdemo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
