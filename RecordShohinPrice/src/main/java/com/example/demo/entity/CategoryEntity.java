package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * m_category
 */
@Data
@Entity
@Table(name = "m_category")
public class CategoryEntity extends BaseEntity implements Serializable {

	@Id
	@Column(name="category_id")
	private Integer category_id;

	@Column(name="category")
	private String category;

	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
