package com.test.userpassword.services;


import com.test.userpassword.models.User;


public interface IUserService {

    User save(User user);

    public User findById(Long id);


}
