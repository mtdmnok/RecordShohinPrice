package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.ItemEntity;
import com.example.demo.repository.ItemRepository;

public class ItemService {
	
	@Autowired
	ItemRepository repository;
	
	public List<ItemEntity> findAll() {
		return repository.findAll();
	}
}
