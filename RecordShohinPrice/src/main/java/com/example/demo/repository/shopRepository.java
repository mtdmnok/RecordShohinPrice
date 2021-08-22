package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
	
	@Query(value = "SELECT * FROM m_shop where shop_name LIKE :shop_name", nativeQuery = true)
	public List<ShopEntity> findShop(@Param("shop_name") String shop_name); 
}

