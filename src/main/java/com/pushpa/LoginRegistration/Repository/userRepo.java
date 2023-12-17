package com.pushpa.LoginRegistration.Repository;

import com.pushpa.LoginRegistration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@EnableJpaRepositories
@Repository
@EnableJpaRepositories
public interface userRepo extends JpaRepository<User,Integer> {


     Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
