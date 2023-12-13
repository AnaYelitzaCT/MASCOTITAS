package org.mascotitas.mascotitas.model;

public class Token {
	private final String accessToken;

	public Token(String accessToken) {
		this.accessToken = accessToken;
	}//constructor

	public String getAccessToken() {
		return accessToken;
	}//GetAccessToken
}//class token 
