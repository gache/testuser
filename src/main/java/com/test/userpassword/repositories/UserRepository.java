package com.test.userpassword.repositories;

import com.test.userpassword.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select case when count(u) > 0 then true else false end from User u where u.name = :name")
    public boolean existsByName(String name);
}
