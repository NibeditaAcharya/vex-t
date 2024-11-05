package com.org.vex.t.Repository;

import com.org.vex.t.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findByEmail(String email);

}
