package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * m_record
 */
@Data
@Entity
@Table(name ="m_record")
public class RegisterItemEntity extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sequence")
	private Integer sequence;

	@Column(name="user_id")
	private String user_id;

	@Column(name="purchace_date")
	private Date purchace_date;

	@Column(name="shop_id")
	private String shop_id;

	@Column(name="category_id")
	private String category_id;

	@Column(name="item_id")
	private String item_id;

	@Column(name="price")
	private Integer price;

	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getPurchase_date() {
		return purchace_date;
	}
	public void setPurchase_date(Date purchace_date) {
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
