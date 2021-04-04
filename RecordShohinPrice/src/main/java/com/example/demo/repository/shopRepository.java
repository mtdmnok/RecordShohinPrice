package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.shopEntity;

public interface shopRepository extends JpaRepository<shopEntity, Long> {

}
