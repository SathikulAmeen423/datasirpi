package com.office.datasirpi.data.dao;

import com.office.datasirpi.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
