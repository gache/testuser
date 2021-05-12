package com.test.userpassword.repositories;

import com.test.userpassword.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
