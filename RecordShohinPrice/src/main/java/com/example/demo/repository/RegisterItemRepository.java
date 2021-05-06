package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RegisterItemEntity;

@Repository
public interface RegisterItemRepository extends JpaRepository<RegisterItemEntity, Integer>{

}
