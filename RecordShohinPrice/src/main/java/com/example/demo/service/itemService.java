package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.itemEntity;
import com.example.demo.repository.itemRepository;

public class itemService {
	
	@Autowired
	itemRepository repository;
	
	public List<itemEntity> findAll() {
		return repository.findAll();
	}
}
