package com.web2h.betmates.restapp.rest.app.security;

public interface SecurityConstants {

	String SECRET = "SecretKeyToGenJwts";
	long EXPIRATION_TIME = 86400000;
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
	String SIGN_UP_URL = "/user/sign-up";
	String CLAIMS_KEY_AUTHORITIES = "authorities";
}