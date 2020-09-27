package com.example.demo.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.DemoUserDetails;
import com.example.demo.dto.LoginDto;

public class DemoAuthUtil {

	public static LoginDto getDemoUserInfo() {

        // 基本的にWebアクセスの場合、getContext()はnullにならないが、
        // それ以外（コマンドライン等、想定外の使い方）のアクセス等を考慮して念のためチェックを入れる
        if (SecurityContextHolder.getContext() == null) {
            throw new AuthenticatedUserNotFoundException();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new AuthenticatedUserNotFoundException();
        }
        // 未認証状態の場合、getPrincipal()は「anonymousUser」文字列（String型）が返る
        // そのため、認証済であるか判定するには、これがユーザ情報クラスのインスタンスかどうかを調べれば良い
        if (!(auth.getPrincipal() instanceof DemoUserDetails)) {
            throw new AuthenticatedUserNotFoundException();
        }
        return ((DemoUserDetails) auth.getPrincipal()).getDemoUser();
    }

    private static class AuthenticatedUserNotFoundException extends RuntimeException {
    }
}
