package com.Max.springboot_mall.Interceptor;

import com.Max.springboot_mall.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //獲取請求中的token
        String token = request.getHeader("token");

        //判斷token是否存在，如果不存在，說明沒有用戶登入，返回錯誤訊息401
        if(token == null || token.isEmpty()){
            log.info("令牌為空, 返回401狀態碼");
            response.setStatus(401);
        }

        //如果token存在,校驗令牌,如果校驗失敗,返回錯誤訊息401
        try{
            JwtUtils.parseJwtToken(token);
        }catch (Exception e){
            log.info("令牌校驗失敗, 返回401狀態碼");
            response.setStatus(401);
            return false;
        }

        //如果token存在,校驗令牌,如果校驗成功,通過
        log.info("令牌校驗成功, 通過");
        return true;
    }
}
