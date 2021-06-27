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
@Table(name = "m_item")
public class ItemEntity extends BaseEntity implements Serializable{
	
	//コンストラクタ
//	public itemEntity() {
//		super();
//	}

	@Id
	@Column(name="item_id")
	private String item_id;
	@Column(name="item")
	private String item;
//	@Column(name="created_at")
//	private Date created_at;
//	@Column(name="updated_at")
//	private Date updated_at;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
