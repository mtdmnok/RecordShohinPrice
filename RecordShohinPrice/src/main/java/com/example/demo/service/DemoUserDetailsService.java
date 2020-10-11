package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginDto;

@Service
class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginDao userBhv; 

    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // 入力値が空の場合もあるため、予めチェックしておく。
        if (userId == null || userId.isEmpty()) {
            // UsernameNotFoundExceptionにメッセージを渡しても画面に反映されないので、
            // ここでは適当に空文字を入れておく
            throw new UsernameNotFoundException("");
        }

        try {
            // 渡されたIDをキーにユーザ情報取得　　
        	LoginDto user = userBhv.findUser(userId);
        	
        	//            return userBhv.selectEntity(cb -> {
//                cb.acceptPK(userId);
//            }).map(user -> {
//                // ユーザが見つかった場合、認証情報を詰め替えておく
//                DemoAuthorizedUserImpl demoUseInfo = new DemoAuthorizedUserImpl();
//                demoUseInfo.setUserId(user.getUserId());
//                demoUseInfo.setUserName(user.getUserName());
//                // さらに、Spring Security用の認証情報も生成
                return (UserDetails) user;
//            })
//            // ユーザが見つからなかった場合、規定の例外を投げる。
//            // なお、UsernameNotFoundExceptionにメッセージを渡しても画面に反映されない（上記と同じ）
//            .orElseThrow(() -> new UsernameNotFoundException(""));
        } catch (Exception e) {
            // DBアクセス等でエラー（接続エラー等）が起きた場合に備えて、
            // 例外を捕まえ、適正なメッセージを持った別の例外に変えて投げ直す。
            // こうしておかないと、発生した元のExceptionの持つエラーメッセージがログイン画面に表示されてしまう
            throw new DbAccessException(
                    messageSource.getMessage("demo.unexpectedError", null, LocaleContextHolder.getLocale()), e);
        }
    }

    private static class DbAccessException extends RuntimeException {

        DbAccessException(String msg, Exception cause) {
            super(msg, cause);
        }
    }

//    private static class DemoAuthorizedUserImpl implements DemoAuthorizedUser {　//？ここが、何をしているところか分からないので、何をimplementsするのかわかりません。
//
//        private String userId;
//        private String userName;
//        // getter, setter
//    }
}
