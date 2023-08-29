package com.example.hotelproject.repository;

import com.example.hotelproject.domain.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    List<Owner> findAll();

    Optional<Owner> findByUserId(@Param("userId") String id);

    boolean existsByUserId(@Param("userId") String id);

    void deleteByUserId(String id);
}
