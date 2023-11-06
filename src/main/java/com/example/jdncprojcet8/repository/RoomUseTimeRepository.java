package com.example.jdncprojcet8.repository;

import com.example.jdncprojcet8.entity.Room;
import com.example.jdncprojcet8.entity.RoomUseTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomUseTimeRepository extends JpaRepository<RoomUseTime, Long> {

    List<RoomUseTime> findAllByRoom(Room room);

    RoomUseTime findByRoomAndTime(Room room, String time);
}
