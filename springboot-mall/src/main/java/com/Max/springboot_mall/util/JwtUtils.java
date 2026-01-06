package com.Max.springboot_mall.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 指定 Base64 編碼的密鑰
    private static final String SECRET_KEY_BASE64 ="U3ByaW5nQm9vdC1NYWxsLUp3dFRva2VuLU1heC1LdWk=";

    // 過期時間：12 小時（毫秒）
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    // 將 Base64 密鑰轉成 SecretKey
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY_BASE64));

    //生成jwt令牌
    public static String generateJwtToken(Map<String, Object> claims){

        return Jwts.builder()
                //設定payload資訊
                .addClaims(claims)
                //現在的毫秒數加上設定的時間
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                //用密鑰簽名，保證 token 不被篡改
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                //生成最後的 JWT 字串
                .compact();
    }

    //解析jwt令牌
    public static Claims parseJwtToken(String jwtToken){


        return Jwts.parserBuilder() //建立解析建構器
                .setSigningKey(SECRET_KEY) //設定簽名密鑰
                .build() //把解析器建好
                .parseClaimsJws(jwtToken) //解析 JWT
                .getBody(); //取出payload

    }
}
