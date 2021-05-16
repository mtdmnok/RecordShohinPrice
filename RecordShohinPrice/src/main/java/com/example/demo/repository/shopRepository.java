package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

}
