package com.test.userpassword.services.serviceinter;


import com.test.userpassword.models.ResultValidation;
import com.test.userpassword.models.User;


public interface IUserService {

    ResultValidation createUser(User user);

}
