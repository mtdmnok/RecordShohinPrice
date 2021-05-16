package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * DB共通Entity
 */

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionID = 1L;
	
	//　登録日
	@Temporal(TemporalType.TIMESTAMP)      //フィールドが何を表すか指定
	@Column(name = "created_at")
	private Date createdAt;
	
	//　更新日
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	
	
	/**
	 * 登録前処理
	 */
	@PrePersist
	public void prePersist() {
		//登録日、更新日を設定
		Date date = new Date();
		createdAt = date;
		updatedAt = date;
		}
	
	/**
	 * 更新前処理
	 */
	@PreUpdate
	public void preupdate() {
		//更新日を設定
		updatedAt = new Date();
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
		
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
		
	public Date getUpdatedAt() {
		return updatedAt;
	}
		
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
