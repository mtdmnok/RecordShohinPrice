package com.example.demo.entity;

import java.util.Date;

public class MasterResultEntity {
	

	//ユーザーID
	private String user_id;
	//購入日
	private Date purchace_date;
	//店舗ID
	private String shop_id;
	//カテゴリーID
	private String category_id;
	//品物ID
	private String item_id;
	//価格
	private Integer price;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getPurchace_date() {
		return purchace_date;
	}
	public void setPurchace_date(Date purchace_date) {
		this.purchace_date = purchace_date;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
