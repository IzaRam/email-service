package com.iza.it.repository;

import com.iza.it.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Email, Integer> {
}
