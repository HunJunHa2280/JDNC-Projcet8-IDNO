package com.example.jdncprojcet8.service;

import com.example.jdncprojcet8.dto.RequestDto;
import com.example.jdncprojcet8.dto.ResponseDto;
import com.example.jdncprojcet8.entity.Room;
import com.example.jdncprojcet8.entity.RoomUseTime;
import com.example.jdncprojcet8.repository.RoomRepository;
import com.example.jdncprojcet8.repository.RoomUseTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomUseTimeRepository useTimeRepository;

    public ResponseDto createBook(RequestDto requestDto) {
        RoomUseTime useTime = useTimeRepository.findById(requestDto.getId()).orElseThrow(()->
                new NullPointerException("잘못된 접근입니다."));
        useTime.set(!requestDto.isCheck());
        useTimeRepository.save(useTime);
        ResponseDto responseDto = new ResponseDto("유저 정보가 없습니다.");
        return responseDto;
        //최종 예약하기
    }

    public List<Room> getRoom(String floors) {
        List<Room> roomList = roomRepository.findAllByFloors(floors);
        return roomList;
    }

    public List<RoomUseTime> getRoomTime(Long id) {
        Room room = roomRepository.findById(id).orElseThrow( ()
        -> new NullPointerException("해당 접근은 잘못된 접근입니다."));
        List<RoomUseTime> roomUseTimeList = useTimeRepository.findAllByRoom(room);
        return roomUseTimeList;
        // 개별 조회
    }

}
