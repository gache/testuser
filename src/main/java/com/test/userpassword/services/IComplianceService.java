package com.test.userpassword.services;

import com.test.userpassword.models.Compliance;

public interface IComplianceService {

    Compliance validatePassword(String password);
}
