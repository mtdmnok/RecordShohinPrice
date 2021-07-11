package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	@Query(value = "SELECT * FROM m_category where category_id = :category_id", nativeQuery = true)
	public CategoryEntity findCategory(@Param("category_id") String category_id);
}
