package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MasterDao;
import com.example.demo.dao.ShopDao;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.MasterResultEntity;
import com.example.demo.entity.RecordEntity;
import com.example.demo.entity.ShopEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ResisterItemRepository;
import com.example.demo.repository.ShopRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
			@RequestParam(name = "shop_name", required = false) String shopName,
			@RequestParam(name = "category_name", required = false) String categoryName,
			@RequestParam(name = "item_name", required = false) String itemName,
			@RequestParam(name = "user_name", required = false) String userName,
			@RequestParam(name = "selectItem", required = false) String item) {
		
		//返却用
		ArrayList<MasterResultEntity> resultList = new ArrayList();
		
		//model.addAttribute("resultList", targetRecordList);
		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());
		model.addAttribute("user", userRepository.findAll());
	return "master";
	}
	
	
	@GetMapping(value = "/resistMaster2")
	@ResponseBody
//	public Map<String, String> search(
	public ArrayList<String> search(
			@RequestParam("selectRadioItem") String selectRadioItem,
			@RequestParam("inputItem") String inputItem) {
			
			// ①マップを作ってみる
			Map<String, String> map = new HashMap<>();
			List<Map<String, String>> rsltList = new ArrayList<Map<String, String>>();
			// ②リストを作ってみる
			List<List> resultList = new ArrayList<List>();
			
			//店舗の場合
			if (selectRadioItem.equals("1")) {
				List<ShopEntity> targetRecordList = shopRepository.findShop("%" + inputItem + "%");
				if(targetRecordList == null || targetRecordList.size() == 0) {
					return null;
				}
				for(ShopEntity targetList : targetRecordList) {
					// エンコード
					//元のソース
//					targetList.setShop_id(encode(targetList.getShop_id()));
//					targetList.setShop_name(encode(targetList.getShop_name()));
					//①
					map.put("id", targetList.getShop_id().toString());
					map.put("name", targetList.getShop_name());
					rsltList.add(map);
					//②
//					List<String> recordList = new ArrayList<String>();
//					recordList.add(targetList.getShop_id());
//					recordList.add(targetList.getShop_name());
//					resultList.add(recordList);
				}
				
				return getJson(map);
			}
			

			
			
			
		// 一旦コメントアウト
//		//店舗の場合
//		if (selectRadioItem.equals("1")) {
//			List<ShopEntity> targetRecordList = shopRepository.findShop("%" + inputItem + "%");
//			if(targetRecordList == null || targetRecordList.size() == 0) {
//				return null;
//			}
//			for(ShopEntity targetList : targetRecordList) {
//				// エンコード
//				targetList.setShop_id(encode(targetList.getShop_id()));
//				targetList.setShop_name(encode(targetList.getShop_name()));
//			}
//			
//			return getJsonShop(targetRecordList);
//			
//		} else if (selectRadioItem.equals("2")) {
//			//品目の場合
//			List<CategoryEntity> targetRecordList = categoryRepository.findCategory("%" + inputItem + "%");
//			if(targetRecordList == null || targetRecordList.size() == 0) {
//				return null;
//			}
//			for(CategoryEntity targetList : targetRecordList) {
//				// エンコード
//				targetList.setCategory_id(encode(targetList.getCategory_id()));
//				targetList.setCategory(encode(targetList.getCategory()));
//			}
//			return getJsonCategory(targetRecordList);
//			
//		} else if (selectRadioItem.equals("3")) {
//			//商品名の場合
//			List<ItemEntity> targetRecordList = itemRepository.findItem("%" + inputItem + "%");
//			if(targetRecordList == null || targetRecordList.size() == 0) {
//				return null;
//			}
//			for(ItemEntity targetList : targetRecordList) {
//				// エンコード
//				targetList.setItem_id(encode(targetList.getItem_id()));
//				targetList.setItem(encode(targetList.getItem()));
//			}
//			return getJsonItem(targetRecordList);
//			
//		} else if (selectRadioItem.equals("4")) {
//			//ユーザー名の場合
//			List<LoginUser> targetRecordList = userRepository.findLikeUser("%" + inputItem + "%");
//			if(targetRecordList == null || targetRecordList.size() == 0) {
//				return null;
//			}
//			for(LoginUser targetList : targetRecordList) {
//				// エンコード
//				targetList.setUserName(encode(targetList.getUserName()));
//			}
//			return getJsonUser(targetRecordList);
//		}
//		
		

		
		//検索用
//		model.addAttribute("shop", shopRepository.findAll());
//		model.addAttribute("category", categoryRepository.findAll());
//		model.addAttribute("item", itemRepository.findAll());
//		model.addAttribute("user", userRepository.findAll());
//		model.addAttribute("selectRadioItem", radioItem);
		
		//List<RecordEntity> targetRecordList = masterDao.findRecord(shopId, categoryId, itemId);) {
		//return "master";
		return null;
	}
	
	// テスト①
	/**
	 * 引数のmapオブジェクトをJSON文字列に変換する
	 * @param ShopEntityのリスト
	 * @return 変換後のJSON文字列
	 */
	private ArrayList<String> getJson(Map<String, String> map) {
		String retVal = null;
		ArrayList<String> arrayRetVal = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for (Map.Entry<String, String> entry : map.entrySet()) {
//			for(ShopEntity targetList : targetRecordList) {
				retVal = objectMapper.writeValueAsString(entry);
				arrayRetVal.add(retVal);
			}
		} catch (JsonProcessingException e) {
		System.err.println(e);
		}
		return arrayRetVal;
	}
	
	//テスト②
	/**
	 * 引数のListオブジェクトをJSON文字列に変換する
	 * @param ShopEntityのリスト
	 * @return 変換後のJSON文字列
	 */
//	private ArrayList<String> getJson(List list) {
//		String retVal = null;
//		ArrayList<String> arrayRetVal = new ArrayList<String>();
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			//リストのリスト形式にしているため、ここをどう変更したらよいかわからない。
//			for(ShopEntity targetList : list) {
//				retVal = objectMapper.writeValueAsString(targetList);
//				arrayRetVal.add(retVal);
//			}
//		} catch (JsonProcessingException e) {
//		System.err.println(e);
//		}
//		return arrayRetVal;
//	}
	
	
	/**
	 * 引数の文字列をエンコードする
	 * @param data 任意の文字列
	 * @return エンコード後の文字列
	 */
	private String encode(String data){
		// 引数がnullまたは空文字列の場合は、その値を返す
		if(StringUtils.isEmpty(data)) {
			return data;
		}
		String retVal = null;
		try {
			retVal = URLEncoder.encode(data, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}		
		return retVal;
	}
	
	/**
	 * 引数のShopEntityオブジェクトをJSON文字列に変換する
	 * @param ShopEntityのリスト
	 * @return 変換後のJSON文字列
	 */
	private ArrayList<String> getJsonShop(List<ShopEntity> targetRecordList) {
		String retVal = null;
		ArrayList<String> arrayRetVal = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for(ShopEntity targetList : targetRecordList) {
				retVal = objectMapper.writeValueAsString(targetList);
				arrayRetVal.add(retVal);
			}
		} catch (JsonProcessingException e) {
		System.err.println(e);
		}
		return arrayRetVal;
	}
	
	/**
	 * 引数のCategoryEntityオブジェクトをJSON文字列に変換する
	 * @param CategoryEntityのリスト
	 * @return 変換後のJSON文字列
	 */
	private ArrayList<String> getJsonCategory(List<CategoryEntity> targetRecordList) {
		String retVal = null;
		ArrayList<String> arrayRetVal = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for(CategoryEntity targetList : targetRecordList) {
				retVal = objectMapper.writeValueAsString(targetList);
				arrayRetVal.add(retVal);
			}
		} catch (JsonProcessingException e) {
		System.err.println(e);
		}
		return arrayRetVal;
	}
	
	/**
	 * 引数のItemEntityオブジェクトをJSON文字列に変換する
	 * @param ItemEntityのリスト
	 * @return 変換後のJSON文字列
	 */
	private ArrayList<String> getJsonItem(List<ItemEntity> targetRecordList) {
		String retVal = null;
		ArrayList<String> arrayRetVal = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for(ItemEntity targetList : targetRecordList) {
				retVal = objectMapper.writeValueAsString(targetList);
				arrayRetVal.add(retVal);
			}
		} catch (JsonProcessingException e) {
		System.err.println(e);
		}
		return arrayRetVal;
	}
	
	/**
	 * 引数のLoginUserオブジェクトをJSON文字列に変換する
	 * @param LoginUserのリスト
	 * @return 変換後のJSON文字列
	 */
	private ArrayList<String> getJsonUser(List<LoginUser> targetRecordList) {
		String retVal = null;
		ArrayList<String> arrayRetVal = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for(LoginUser targetList : targetRecordList) {
				retVal = objectMapper.writeValueAsString(targetList);
				arrayRetVal.add(retVal);
			}
		} catch (JsonProcessingException e) {
		System.err.println(e);
		}
		return arrayRetVal;
	}
}
