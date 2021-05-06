package com.example.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;
/**
 * m_user
 */
@Repository
public class LoginUserDao {

	@Autowired
    EntityManager em;

    /**
     * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
     * @param userName
     * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
     */
	public LoginUser findUser(String userName) {
		// user_name でユーザの存在をチェック
        String query = "SELECT * FROM record_shohin_price.m_user WHERE user_name = :userName";
        return (LoginUser)em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName).getSingleResult();
    }

}
