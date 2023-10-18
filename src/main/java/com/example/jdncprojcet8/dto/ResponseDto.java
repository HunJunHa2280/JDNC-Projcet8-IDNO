package com.example.jdncprojcet8.dto;

import com.example.jdncprojcet8.entity.Room;
import lombok.Getter;

@Getter
public class ResponseDto {
    private String msg;

    public ResponseDto(String s) {
        this.msg = s;
    }
}