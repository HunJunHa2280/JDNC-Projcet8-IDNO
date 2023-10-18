package com.example.jdncprojcet8.repository;


import com.example.jdncprojcet8.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByFloors(String floors);
}