package com.salci_study.restful_web_services.jpa;

import com.salci_study.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
