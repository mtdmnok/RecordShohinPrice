package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data	
@Entity
@Table(name = "m_shop")
public class ShopEntity extends BaseEntity implements Serializable {

	//コンストラクタ
//	public shopEntity() {
//		super();
//	}
	
	@Id
	@Column(name="shop_id")
	private Integer shop_id;
	@Column(name="shop_name")
	private String shop_name;
//	@Column(name="created_at")
//	private Date created_at;
//	@Column(name="updated_at")
//	private Date updated_at;
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
//	public Date getCreated_at() {
//		return created_at;
//	}
//	public void setCreated_at(Date created_at) {
//		this.created_at = created_at;
//	}
//	public Date getUpdated_at() {
//		return updated_at;
//	}
//	public void setUpdated_at(Date updated_at) {
//		this.updated_at = updated_at;
//	}
	
	}
