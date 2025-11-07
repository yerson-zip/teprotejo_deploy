package com.teprotejo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name="emergency")
@Data
public class Emergency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private StateEmergency state = StateEmergency.EN_ESPERA;

    @Column(nullable = false)
    private double  latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false, name = "date_time")
    private LocalDateTime dateTime;

    @Column(nullable = false, length = 100)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",
            nullable = true,
            foreignKey = @ForeignKey(name="fk_emergency_user"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cai", nullable=true, foreignKey = @ForeignKey(name = "fk_emergency_cai"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JsonIgnore
    private CAI cai;
}

