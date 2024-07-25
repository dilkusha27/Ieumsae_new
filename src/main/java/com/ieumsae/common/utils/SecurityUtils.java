package com.ieumsae.common.utils;

import com.ieumsae.user.domain.CustomOAuth2User;
import com.ieumsae.user.domain.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomOAuth2User) {
            return ((CustomOAuth2User) principal).getUserIdx();
        } else if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUserIdx();
        }
        throw new RuntimeException("알 수 없는 유저 타입입니다. " + principal.getClass().getName());
    }
}