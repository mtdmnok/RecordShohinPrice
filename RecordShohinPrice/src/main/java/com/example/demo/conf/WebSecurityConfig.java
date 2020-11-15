package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.service.DemoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//UserDetailsServiceImplのメソッドを使えるようにインスタンス化
	@Autowired
	private DemoUserDetailsService userDetailsService;
	
	//フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
    @Bean
    public BCryptPasswordEncoder passwordEncorder() {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/","home").permitAll() // "/" と /home は全ユーザーがアクセス可能
			.anyRequest()
			.authenticated();
		
		http.formLogin()
			.loginProcessingUrl("/login") //認証処理のパス
			.loginPage("/") //ログインフォームのパス
			.defaultSuccessUrl("/menu") //認証成功時の遷移先
			.usernameParameter("username").passwordParameter("password")
			.and();
	}
	
//	  /**
//     * ここはユーザー名：user、パスワード：password という会員を作っている
//     */
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		UserDetails user = User.withUsername("user")
//				.passwordEncoder(encoder::encode)
//				.password("password")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
	
	/**
	 * 認証時に利用するデータソースを定義するメソッド
	 * DBから取得したユーザ情報をuserDetailsServiceへセットすることで認証時の比較情報としている
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncorder());
	}
}