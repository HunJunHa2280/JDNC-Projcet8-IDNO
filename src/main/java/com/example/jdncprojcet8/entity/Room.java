package com.example.jdncprojcet8.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String roomName;
    // 중간에 언더바를 사용하면 쿼리문이라 인식을 못함
    @Column
    private boolean roomAvailable;
    @Column
    private String floors;

}
// "name"
// "canUse"
// "floors"