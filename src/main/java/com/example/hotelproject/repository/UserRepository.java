package com.example.hotelproject.repository;

import com.example.hotelproject.domain.User;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User save(
//            UserCreateRequest userCreateRequest
//    );

    List<User> findAll();

    Optional<User> findUserByUserId(@Param("userId") String userId);

    Optional<User> findUserByUserNo(@Param("userNo") Long userNo);
    //List<Object> findAll();

    void deleteByUserId(@Param("userId") String userId);

    boolean existsByUserId(String userId);
}
