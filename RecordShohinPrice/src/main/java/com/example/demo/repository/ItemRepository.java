package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	@Query(value = "SELECT * FROM m_item where item_id LIKE :item_name", nativeQuery = true)
	public List<ItemEntity> findItem(@Param("item_name") String item_name);
}