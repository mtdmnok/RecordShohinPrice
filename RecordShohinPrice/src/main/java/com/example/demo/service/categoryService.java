package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.categoryEntity;
import com.example.demo.repository.categoryRepository;

@Service
public class categoryService {

	@Autowired
	categoryRepository repository;
	
	public List<categoryEntity> findAll() {
		return repository.findAll();
	}
}
