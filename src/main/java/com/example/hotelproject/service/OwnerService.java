package com.example.hotelproject.service;
import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.domain.Owner;
import com.example.hotelproject.mapper.OwnerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OwnerService {
    private final OwnerMapper ownerMapper;
    public OwnerService(OwnerMapper ownerMapper){
        this.ownerMapper = ownerMapper;
    }


    //오너 신규 추가
    public void createOwner(OwnerCreateRequest request){
        //ownerMapper.findOwnerById(request.getUserId());
        ownerMapper.createOwner(request);
    }

    //오너 검색
    public OwnerResponse findOwnerById(String id){
        return ownerMapper.findOwnerById(id);
    }

    //오너 삭제
    public void deleteOwner(String id){
        ownerMapper.deleteOwner(id);
    }

    //오너 신규 추가
    public void updateOwnerInfo(OwnerCreateRequest request){
        ownerMapper.updateOwnerInfo(request);
    }
}
