package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "m_record")
public class RecordEntity extends BaseEntity implements Serializable{
	
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="purchace_date")
	private Date purchace_date;
	@Column(name="shop_id")
	private Integer shop_id;
	@Column(name="category_id")
	private Integer category_id;
	@Column(name="item_id")
	private Integer item_id;
	@Column(name="price")
	private Integer price;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Date getPurchace_date() {
		return purchace_date;
	}
	public void setPurchace_date(Date purchace_date) {
		this.purchace_date = purchace_date;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
