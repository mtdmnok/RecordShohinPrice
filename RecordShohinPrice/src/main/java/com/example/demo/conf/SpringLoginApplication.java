package com.example.demo.conf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //Spring Bootアプリケーションであることを示す
@ComponentScan("com.example.demo") //BeanとしてDIに登録する。パッケージとして指定することができる。
@EntityScan("com.example.demo.entity") //上記同様BeanとしてDIに登録。
//JpaRepositoryをONにするためのもの。指定されたパッケージ内を検索し、@Repositoryを付けたクラスをBeanとして登録。
@EnableJpaRepositories("com.example.demo.repository") 
public class SpringLoginApplication {

}
