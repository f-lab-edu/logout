package com.example.hotelproject.service;
import com.example.hotelproject.controller.request.OwnerCreateRequest;
import com.example.hotelproject.controller.request.OwnerUpdateRequest;
import com.example.hotelproject.controller.response.OwnerResponse;
import com.example.hotelproject.domain.Owner;
import com.example.hotelproject.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    //오너 신규 추가
    @Transactional
    public OwnerResponse create(OwnerCreateRequest request){
        Owner owner = request.toEntity();
        boolean isExistOwner = ownerRepository.existsByUserId(owner.getUserId());
        if (isExistOwner) {
            throw new IllegalArgumentException("이미 가입된 회원입니다. : " + owner.getUserId());
        }else{
            ownerRepository.save(owner);
        }
        return new OwnerResponse(owner.getUserId());
    }

    //오너 검색
    @Transactional(readOnly = true)
    public OwnerResponse findOwnerById(String id){
      return ownerRepository.findByUserId(id)
                .map(OwnerResponse::of) //메서드 레퍼런스
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디의 유저가 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<OwnerResponse> findAll(){
        return ownerRepository.findAll().stream()
                .map(OwnerResponse::of)
                .collect(Collectors.toList());
    }

    //오너 삭제
    @Transactional
    public void deleteOwner(String id){
        ownerRepository.deleteByUserId(id);
    }

    @Transactional
    public void updateOwnerInfo(OwnerUpdateRequest request){
        Owner owner = request.toOwner();
        ownerRepository.save(owner);
    }
}
