package com.org.vex.t.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue()
    private Long userId;
    private String email;
    private boolean isVerified;




}
