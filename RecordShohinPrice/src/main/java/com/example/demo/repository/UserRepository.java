package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.LoginUser;


/*
 * Spring Frameworkのデータ検索を行うための仕組み。
 * DIに登録しておくことでデータ検索が可能になる。引数には＜エンティティクラス,　IDタイプとなる＞
 */
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

	@Query(value = "SELECT * FROM m_shop where user_id = :user_id", nativeQuery = true)
	public LoginUser findUser(@Param("user_id") String user_id);
}
