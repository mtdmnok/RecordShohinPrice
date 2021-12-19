package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.LoginUser;


/*
 * Spring Frameworkのデータ検索を行うための仕組み。
 * DIに登録しておくことでデータ検索が可能になる。引数には＜エンティティクラス,　IDタイプとなる＞
 */
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

	@Query(value = "SELECT * FROM m_shop where user_id = :user_id", nativeQuery = true)
	public LoginUser findUser(@Param("user_id") String user_id);
	
	@Query(value = "SELECT * FROM m_shop where user_name LIKE :user_name", nativeQuery = true)
	public List<LoginUser> findLikeUser(@Param("user_name") String user_name);
	
	@Query(value = "SELECT * FROM m_user where user_name LIKE BINARY :user_name", nativeQuery = true)
	public List<LoginUser> findUserName(@Param("user_name") String user_name);
}
