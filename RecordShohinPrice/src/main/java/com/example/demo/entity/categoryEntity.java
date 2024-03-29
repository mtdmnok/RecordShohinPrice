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
@Table(name = "m_category")
//public class categoryEntity {
public class CategoryEntity extends BaseEntity implements Serializable {

	//コンストラクタ
//	public categoryEntity() {
//		super();
//	}
	
	@Id
	@Column(name="category_id")
	private String category_id;
	@Column(name="category")
	private String category;
//	@Column(name="created_at")
//	private Date created_at;
//	@Column(name="updated_at")
//	private Date updated_at;
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
