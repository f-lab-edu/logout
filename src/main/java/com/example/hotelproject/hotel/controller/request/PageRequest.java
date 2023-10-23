package com.example.hotelproject.hotel.controller.request;

import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public class PageRequest {

    //가져오길 원하는 페이지 번호
    private int page = 0;
    //한페이지에 존재시킬 데이터 개수 size
    private int size = 10;
    //정렬시킬 기준
    private Sort.Direction direction = Sort.Direction.DESC;

    public void setSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page, size, direction,
                "createdAt");
    }
}
