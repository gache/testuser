package com.test.userpassword.services.serviceimpl;

import com.test.userpassword.models.Compliance;
import com.test.userpassword.services.serviceinter.IComplianceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplianceServiceImpl implements IComplianceService {

    @Override
    public Compliance validatePassword(String password) {
        boolean isPasswordValid = true;
        final String MUST_CONTAIN_ONE_UPPERCASE_LETTER = "^.*[A-Z]+.*$";
        final String MUST_CONTAIN_ONE_DIGIT = "^.*[0-9]+.*$";
        final String MUST_CONTAIN_ONE_SPECIAL_CHARACTER = "^.*[!&$%@]+.*$";

        List<String> reasonsForInvalidPassword = new ArrayList<>();

        if (password.length() < 8) {
            reasonsForInvalidPassword.add("Password must be at least 8 character long");
            isPasswordValid = false;
        }

        if (!password.matches(MUST_CONTAIN_ONE_UPPERCASE_LETTER)) {
            reasonsForInvalidPassword.add("Password must be at least one upper case letter");
            isPasswordValid = false;
        }

        if (!password.matches(MUST_CONTAIN_ONE_DIGIT)) {
            reasonsForInvalidPassword.add("Password must be at least one digit");
            isPasswordValid = false;
        }

        if (!password.matches(MUST_CONTAIN_ONE_SPECIAL_CHARACTER)) {
            reasonsForInvalidPassword.add("Password must be at least one special character");
            isPasswordValid = false;
        }

        String reason = reasonsForInvalidPassword.stream().collect(Collectors.joining(", "));

        return new Compliance(isPasswordValid, reason);
    }
}
