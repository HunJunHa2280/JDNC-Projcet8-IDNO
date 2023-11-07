package com.example.jdncprojcet8.controller;


import com.example.jdncprojcet8.dto.CancelRequestDto;
import com.example.jdncprojcet8.dto.RequestDto;
import com.example.jdncprojcet8.dto.ResponseDto;
import com.example.jdncprojcet8.entity.Room;
import com.example.jdncprojcet8.entity.RoomUseTime;
import com.example.jdncprojcet8.security.UserDetailsImpl;
import com.example.jdncprojcet8.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://127.0.0.1:3000,http://localhost:3000/") // 프론트엔드의 주소값을 입력해야함 127.0.0.1은 Cros가 아니니까

@CrossOrigin(origins = {"https://front-omega-vert.vercel.app", "http://localhost:3000"}, exposedHeaders = "Authorization") // vercel서버쪽은 나중에 프론트 서버를 입력
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

    @PostMapping("/room/books")
    public ResponseDto requestDto(@RequestBody RequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return roomService.createBook(requestDto, userDetails.getUsername()); // AuthenticationPrincipal, UserDetailsImpl
    }

    @PutMapping("/room-time/{id}")
    public ResponseDto updateRoomTime(@PathVariable Long id, @RequestBody CancelRequestDto cancelRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return roomService.updateRoomTime(id, cancelRequestDto, userDetails.getUsername());
    }
}
