package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	//CategoryRepository repository;
	
	public List<CategoryEntity> findAll() {
		//return repository.findAll();
		return categoryDao.findAll();
	}
}
