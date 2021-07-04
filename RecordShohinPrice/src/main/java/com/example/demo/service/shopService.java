package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopDao;
import com.example.demo.entity.ShopEntity;
import com.example.demo.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	//ShopRepository repository;
	ShopDao shopDao;
	
	public List<ShopEntity> findAll() {
		//return repository.findAll();
		return shopDao.findAll();
	}
	
}
