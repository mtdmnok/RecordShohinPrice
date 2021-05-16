package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ログインユーザのユーザ名、パスワードを格納するためのEntity
 * @author aoi
 *
 */
@Entity
@Table(name = "m_user") 
public class LoginUser extends BaseEntity implements Serializable{
	
	@Column(name = "user_id")
	@Id
	private Long userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_name")
	private String userName;
	
	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
