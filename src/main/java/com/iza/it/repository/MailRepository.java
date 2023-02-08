package com.iza.it.repository;

import com.iza.it.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MailRepository extends JpaRepository<Email, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM email WHERE tmst >= ?1 AND tmst <= ?2")
    Iterable<Email> findEmailByTmstInterval(Long tmstBegin, Long tmstEnd);
}
