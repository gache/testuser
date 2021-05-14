package com.test.userpassword.services.serviceimpl;

import com.test.userpassword.models.Compliance;
import com.test.userpassword.models.ResultValidation;
import com.test.userpassword.models.User;
import com.test.userpassword.repositories.UserRepository;
import com.test.userpassword.services.serviceinter.IComplianceService;
import com.test.userpassword.services.serviceinter.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements IUserService {

    private final UserRepository userRepository;
    private final IComplianceService iComplianceService;

    public UserImpl(UserRepository userRepository, IComplianceService iComplianceService) {
        this.userRepository = userRepository;
        this.iComplianceService = iComplianceService;
    }

    @Override
    public ResultValidation createuser(User user) {
        Compliance passwordValidation = iComplianceService.validatePassword(user.getPassword());

        if (!passwordValidation.isValid()) {
            return new ResultValidation(400, "password is not Compliant", passwordValidation);
        }

        if (userRepository.existsByName(user.getName())) {

            return new ResultValidation(409, "user already exists", passwordValidation);

        } else {
            userRepository.save(user);
            return new ResultValidation(201, "user is create", passwordValidation);
        }

    }

}