package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.RecordEntity;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
	
	@Query(value = "SELECT * FROM m_record where shop_id = :shop_id and category_id = :category_id and item_id = :item_id")
	public List<RecordEntity> findRecord(@Param("shop_id") String shop_id, @Param("category_id") String category_id, @Param("item_id") String item_id);
}
