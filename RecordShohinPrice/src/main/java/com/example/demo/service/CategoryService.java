package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.CategoryEntity;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public List<CategoryEntity> findAll() {
		return categoryDao.findAll();
	}
}
