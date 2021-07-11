package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	@Query(value = "SELECT * FROM m_item where item_id = :item_id", nativeQuery = true)
	public ItemEntity findItem(@Param("item_id") String item_id);
}