package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.shopEntity;
import com.example.demo.repository.shopRepository;

@Service
public class shopService {
	
	@Autowired
	shopRepository repository;
	
	public List<shopEntity> findAll() {
		return repository.findAll();
	}
	
}
