package com.test.userpassword.repositories;
import com.test.userpassword.models.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceRepository extends JpaRepository<Compliance, Long> {
}
