package com.example.jdncprojcet8.service;

import com.example.jdncprojcet8.dto.CancelRequestDto;
import com.example.jdncprojcet8.dto.RequestDto;
import com.example.jdncprojcet8.dto.ResponseDto;
import com.example.jdncprojcet8.entity.Room;
import com.example.jdncprojcet8.entity.RoomReservationList;
import com.example.jdncprojcet8.entity.RoomUseTime;
import com.example.jdncprojcet8.entity.User;
import com.example.jdncprojcet8.repository.RoomRepository;
import com.example.jdncprojcet8.repository.RoomReservationListRepository;
import com.example.jdncprojcet8.repository.RoomUseTimeRepository;
import com.example.jdncprojcet8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomUseTimeRepository useTimeRepository;
    private final RoomReservationListRepository roomReservationListRepository;
    private final UserRepository userRepository;

    public ResponseDto createBook(RequestDto requestDto) {
        RoomUseTime useTime = useTimeRepository.findById(requestDto.getId()).orElseThrow(()->
                new NullPointerException("잘못된 접근입니다."));
        useTime.set(!requestDto.isCheck());
        useTimeRepository.save(useTime);
        RoomReservationList roomReservationList = new RoomReservationList();
        User user = userRepository.findById(1L).orElseThrow(()
        -> new NullPointerException("해당 인원은 없습니다."));
        String name = user.getName();
        // String name = "하헌준"
        roomReservationList.gain(name, useTime.getRoom().getRoomName(), useTime);
        ResponseDto responseDto = new ResponseDto("예약이 완료되었습니다.");
        roomReservationListRepository.save(roomReservationList);
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

    public ResponseDto updateRoomTime(Long id, CancelRequestDto cancelRequestDto) {
        // 찾아 오기
        RoomUseTime roomUseTime = useTimeRepository.findById(id).orElseThrow(()->
           new NullPointerException("해당 접근은 잘못된 접근입니다."));
            // 수정 하기
            roomUseTime.update(cancelRequestDto);
            // 수정된 정보를 DB에 저장 하기
            useTimeRepository.save(roomUseTime);

        RoomReservationList roomReservationList = new RoomReservationList();
        User user = userRepository.findById(1L).orElseThrow(()
                -> new NullPointerException("해당 인원은 없습니다."));

        String name = user.getName();
            roomReservationList.abc(roomUseTime, name,roomUseTime.getRoom().getRoomName());
            roomReservationListRepository.save(roomReservationList);
            return new ResponseDto("수정을 완료되었습니다.");


    }

}
