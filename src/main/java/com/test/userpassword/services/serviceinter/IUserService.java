package com.test.userpassword.services.serviceinter;


import com.test.userpassword.models.ResultValidation;
import com.test.userpassword.models.User;


public interface IUserService {

    User save(User user);
    boolean existsByName(String name);
    ResultValidation createuser(User user);

}
