package com.example.jdncprojcet8.controller;


import com.example.jdncprojcet8.dto.RequestDto;
import com.example.jdncprojcet8.dto.ResponseDto;
import com.example.jdncprojcet8.entity.Room;
import com.example.jdncprojcet8.entity.RoomUseTime;
import com.example.jdncprojcet8.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
// 파이널 필드를 사용하기 위해서 사용
@RequestMapping("/api")

public class RoomController {

    private final RoomService roomService;

    @GetMapping("/room/{floors}")
    public List<Room> getAllRoom(@PathVariable String  floors) {
        return roomService.getRoom(floors);
    }

    @GetMapping("/room-time/{id}")
    public List<RoomUseTime> getAllRoomTime(@PathVariable Long id) {
        return roomService.getRoomTime(id);
    }

    @PostMapping("/api/room/book")
    public ResponseDto requestDto(@RequestBody RequestDto requestDto) {
        return roomService.createBook(requestDto);
    }

}
