package com.teprotejo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="cai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CAI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String station_name;

    @Column(length = 20, nullable = false)
    private String telephone;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(length = 100, nullable = false)
    private String city;

    @OneToMany(mappedBy = "cai", cascade = {CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Emergency> emergencies;


    public CAI(Long id) {
        this.id = id;
    }
}
