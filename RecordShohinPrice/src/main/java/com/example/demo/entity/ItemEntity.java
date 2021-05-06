package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * m_item
 */
@Data
@Entity
@Table(name = "m_item")
public class ItemEntity extends BaseEntity implements Serializable {

	@Id
	@Column(name="item_id")
	private Integer item_id;

	@Column(name="item")
	private String item;

	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
