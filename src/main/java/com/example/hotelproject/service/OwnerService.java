package com.example.hotelproject.service;
import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.domain.Owner;
import com.example.hotelproject.mapper.OwnerMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OwnerService {
    private final OwnerMapper ownerMapper;
    public OwnerService(OwnerMapper ownerMapper){
        this.ownerMapper = ownerMapper;
    }


    //오너 신규 추가
    public void createOwner(OwnerCreateRequest request){
//        OwnerResponse response = new OwnerResponse(){};
//        response = ownerMapper.findOwnerById(request.getUserId());
        //Optional<Owner> res = Optional.ofNullable(ownerMapper.findOwnerById(request.getUserId()));
        boolean chkId = ownerMapper.checkExistId(request.getUserId());
        if(ObjectUtils.isEmpty(chkId)){
            ownerMapper.createOwner(request);
        }else{
            throw new IllegalArgumentException("같은 아이디의 유저가 있습니다.(" + request.getUserId()+ ")");
        }
    }

    //오너 검색
    public OwnerResponse findOwnerById(String id){
       //ownerMapper.findOwnerById(id).orElseThrow(()-> new IllegalArgumentException("해당 아이디의 유저가 없습니다." );
        return ownerMapper.findOwnerById(id)
                .map(OwnerResponse::of) //메서드 레퍼런스
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디의 유저가 없습니다."));
    }

    public List<OwnerResponse> findAll(){
        return ownerMapper.findAll().stream()
                .map(OwnerResponse::of)
                .collect(Collectors.toList());
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
