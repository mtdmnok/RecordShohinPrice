package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.RegisterItemEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.RegisterItemRepository;
import com.example.demo.repository.ShopRepository;

/**
 * 購入商品登録系コントローラー
 */
@Controller
public class RegisterItemController {

	@Autowired
	RegisterItemRepository repository;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	/**
	 * 購入品登録画面
	 */
	@GetMapping("/regist")
	public String resisterItem(Model model) {

		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());

		return "registerItem";
	}

	/**
	 * 購入商品登録
	 */
	@RequestMapping(value = "/registerItem", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(
			@RequestParam("purchace_date") String dateString,
			@RequestParam("shop_id") String shopId,
			@RequestParam("category_id") String categoryId,
			@RequestParam("item_id") String itemId,
			@RequestParam("price") Integer price,
			ModelAndView mav) throws ParseException {

		// m_record のエンティティクラスインスタンス
		RegisterItemEntity entity = new RegisterItemEntity();

		//ユーザーid
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entity.setUser_id(user.getUsername());
		//日付
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		entity.setPurchase_date(sdFormat.parse(dateString));
		//店舗
		entity.setShop_id(shopId);
		//品目
		entity.setCategory_id(categoryId);
		//商品名
		entity.setItem_id(itemId);
		//価格
		entity.setPrice(price);

		Calendar calendar = Calendar.getInstance();
        //作成日
		entity.setCreatedAt(calendar.getTime());
		//更新日
		entity.setUpdatedAt(calendar.getTime());

		repository.saveAndFlush(entity);

		// TODO 成功時：完了画面に遷移
		return new ModelAndView("redirect:/menu");
	}

}
