package com.example.hotelproject.owner.repository;

import com.example.hotelproject.owner.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    List<Owner> findAll();

    Optional<Owner> findByOwnerId(@Param("ownerId") String id);

    boolean existsByOwnerId(@Param("ownerId") String id);

    void deleteByOwnerId(String id);
}
