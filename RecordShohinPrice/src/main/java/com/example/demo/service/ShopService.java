package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopDao;
import com.example.demo.entity.ShopEntity;

@Service
public class ShopService {

	@Autowired
	ShopDao shopDao;

	public List<ShopEntity> findAll() {
		return shopDao.findAll();
	}

}
