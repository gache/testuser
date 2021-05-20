package com.test.userpassword.controllers;


import com.test.userpassword.models.Compliance;
import com.test.userpassword.models.ResultValidation;
import com.test.userpassword.models.User;

import com.test.userpassword.models.ValidationResponse;
import com.test.userpassword.services.serviceinter.IComplianceService;
import com.test.userpassword.services.serviceinter.IUserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class UserController {

    private final IUserService iUserService;
    private final IComplianceService iComplianceService;


    public UserController(IUserService iUserService, IComplianceService iComplianceService) {
        this.iUserService = iUserService;
        this.iComplianceService = iComplianceService;
    }

    @GetMapping(path = "/compliance/password/{password}")
    public ResponseEntity<Compliance> getPassword(@PathVariable("password") String password) {
        Compliance compliance = iComplianceService.validatePassword(password);
        return ResponseEntity.status(HttpStatus.OK)
                .body(compliance);
    }

    @PostMapping("/user")
    public ResponseEntity<ValidationResponse> create(@Valid @RequestBody User user) {
        ResultValidation validation = iUserService.createuser(user);
        ValidationResponse validationResponse = new ValidationResponse(validation);

        return ResponseEntity.status(validation.getStatusCode())
                .body(validationResponse);
    }

}
