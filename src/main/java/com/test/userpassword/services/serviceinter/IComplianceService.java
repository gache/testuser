package com.test.userpassword.services.serviceinter;

import com.test.userpassword.models.Compliance;


public interface IComplianceService {

    Compliance validatePassword(String password);
}
