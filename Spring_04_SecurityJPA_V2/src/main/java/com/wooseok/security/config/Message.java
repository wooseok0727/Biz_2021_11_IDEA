package com.wooseok.security.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.CredentialExpiredException;

public class Message {

    public static class ERROR {

        // 대표 exception
        public final static String BadCredentials = "ERROR";

        public final static String Disabled = "비활성화";

        public final static String CredentialExpired = "비밀번호 유효기간 만료";

        public final static String Locked = "계정 잠김";

        public final static String AccountExpired = "계정 사용기한 만료";

        public final static String SessionAuthentication = "인증 세션 오류";
    }
}
