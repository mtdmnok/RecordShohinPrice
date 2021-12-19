package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	@Query(value = "SELECT * FROM m_category where category LIKE BINARY :category", nativeQuery = true)
	public List<CategoryEntity> findCategory(@Param("category") String category);
}
