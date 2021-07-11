package com.example.demo.form;

import lombok.Getter;
import lombok.Setter;

public class MenuForm {
	
	/** ログイン名  **/
	@Getter
	@Setter
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
