package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MasterDao;
import com.example.demo.dao.ShopDao;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.MasterResultEntity;
import com.example.demo.entity.RecordEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ResisterItemRepository;
import com.example.demo.repository.ShopRepository;
import com.example.demo.repository.UserRepository;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

@Controller
public class MasterController {
	
	@Autowired
	ResisterItemRepository repository;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UserRepository userRepository;

	/**
	 * マスタ画面
	 */
	@GetMapping("/master")
	public String master(Model model) {
		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());
		model.addAttribute("user", userRepository.findAll());
		return "master";
	}
	
	/**
	 * マスタ情報検索
	 */
	@Autowired
	MasterDao masterDao;
	@Autowired
	ShopDao shopDao;
	
	@RequestMapping(value = "/resistMaster", method = RequestMethod.POST)
	public String result(Model model, 
			@RequestParam("shop_id") String shopId,
			@RequestParam("category_id") String categoryId,
			@RequestParam("item_id") String itemId,
			@RequestParam("user_id") String userId,
			@RequestParam("selectItem") String item) {
		//レコードリスト
		//List<RecordEntity> targetRecordList = masterDao.findRecord(shopId, categoryId, itemId);
		List<String> targetRecordList = (List<String>) shopDao.findShop(shopId);
		
		//返却用
		ArrayList<MasterResultEntity> resultList = new ArrayList();
		

//		for(RecordEntity record : targetRecordList) {
//			MasterResultEntity t = new MasterResultEntity();
//			//ユーザーID
//			t.setUser_id(record.getUser_id());
//			//購入日
//			t.setPurchace_date(record.getPurchace_date());
//			//店舗ID
//			//t.setShop_id(record.getShop_id());
//			//店舗名
//			t.setShop_id(shopRepository.findShop(record.getShop_id()).getShop_name());
//			//カテゴリーID
//			//t.setCategory_id(record.getCategory_id());
//			//カテゴリー
//			t.setCategory_id(categoryRepository.findCategory(record.getCategory_id()).getCategory());
//			//品物ID
//			t.setItem_id(record.getItem_id());
//			t.setItem_id(itemRepository.findItem(record.getItem_id()).getItem());
//			//価格
//			t.setPrice(record.getPrice());
//			resultList.add(t);
//		}
		model.addAttribute("resultList", targetRecordList);
		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());
		model.addAttribute("user", userRepository.findAll());

		return "master";
//	return new ModelAndView("");
	}
			
}
