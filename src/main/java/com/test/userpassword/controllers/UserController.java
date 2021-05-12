package com.test.userpassword.controllers;


import com.test.userpassword.models.User;

import com.test.userpassword.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final IUserService iUserService;


    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        User newUser = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> " " + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
        }
        try {
            newUser = iUserService.save(user);
        } catch (DataAccessException e) {
            response.put("message", "Error au moment de la création d'un user dans la BDD");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
        }
        response.put("message", "User a été créé avec satisfaction");
        response.put("user", newUser);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
