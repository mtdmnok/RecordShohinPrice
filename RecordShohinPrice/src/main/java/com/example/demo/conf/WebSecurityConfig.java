package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.DemoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DemoUserDetailsService userDetailsService;

	/**
	 * フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
	 */
    @Bean
    public BCryptPasswordEncoder passwordEncorder() {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * アクセス可否を設定
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/","home", "/css/*").permitAll() // "/" と /home は全ユーザーがアクセス可能
			.anyRequest()
			.authenticated();

		http.formLogin()
			.loginProcessingUrl("/login") //認証処理のパス
			.loginPage("/") //ログインフォームのパス
			.defaultSuccessUrl("/menu") //認証成功時の遷移先
			.usernameParameter("username").passwordParameter("password")
			.and();

		http
			.csrf().disable();
	}

	/**
	 * 認証用にデータソースを定義
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncorder());
	}
}