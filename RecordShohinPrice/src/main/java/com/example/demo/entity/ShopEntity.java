package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * m_shop
 */
@Data
@Entity
@Table(name = "m_shop")
public class ShopEntity extends BaseEntity implements Serializable {

	@Id
	@Column(name="shop_id")
	private Integer shop_id;

	@Column(name="shop_name")
	private String shop_name;

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

}
