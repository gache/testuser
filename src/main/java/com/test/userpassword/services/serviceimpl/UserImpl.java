package com.test.userpassword.services.serviceimpl;

import com.test.userpassword.models.Compliance;
import com.test.userpassword.models.ResultValidation;
import com.test.userpassword.models.User;
import com.test.userpassword.repositories.UserRepository;
import com.test.userpassword.services.serviceinter.IComplianceService;
import com.test.userpassword.services.serviceinter.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements IUserService {

    private final UserRepository userRepository;
    private final IComplianceService iComplianceService;
    private final PasswordEncoder passwordEncoder;

    public UserImpl(UserRepository userRepository, IComplianceService iComplianceService) {
        this.userRepository = userRepository;
        this.iComplianceService = iComplianceService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResultValidation createUser(User user) {
        Compliance passwordValidation = iComplianceService.validatePassword(user.getPassword());
        String encoderPassword = passwordEncoder.encode(user.getPassword());

        if (!passwordValidation.isValid()) {
            return new ResultValidation(400, "password is not Compliant");
        }
        if (userRepository.existsByName(user.getName())) {
            return new ResultValidation(409, "user already exists");
        } else {
            user.setPassword(encoderPassword);
            userRepository.save(user);
            return new ResultValidation(201, "user is create");
        }

    }

}