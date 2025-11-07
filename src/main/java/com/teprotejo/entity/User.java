package com.teprotejo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String last_name;

    @Column(unique=true, nullable = false, length = 20)
    private String tel;


    @Column(unique = true,nullable = false, length = 100)
    private String email;


    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String direction;

    @Column(nullable= false, length = 100)
    private String city;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contact ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Emergency>  emergencies;

    public User(String city, String direction, String password, String email, String tel, String last_name, String name) {
        this.city = city;
        this.direction = direction;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.last_name = last_name;
        this.name = name;
    }

    public User(Long id) {
        this.id = id;
    }
}

