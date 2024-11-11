package com.org.vex.t.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue()
    private Long userId;

    @Column(unique = true)
    private String email;
    private boolean isVerified;




}
