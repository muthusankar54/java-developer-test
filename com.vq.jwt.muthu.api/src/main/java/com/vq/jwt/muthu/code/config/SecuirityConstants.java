package com.vq.jwt.muthu.code.config;

public class SecuirityConstants {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String API_V1_AUTH = "/api/v1/auth";
}
