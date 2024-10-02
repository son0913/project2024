package com.moon.mProject.login.oauth.kakao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/login/oauth/kakao")
public class LoginOauthKaKaoController {
	
	private final String REST_API_KEY = "e2f96f0e3c7ba86cd6538a3f46f7b919";
	private final String REDIRECT_URI = "http://localhost/login/oauth/kakao/token/callback";
	

	@GetMapping("/authorize/callback")
	public void KakaoAuthorizeCallback(@RequestParam String authorize_code) {
		System.out.println("code = " + authorize_code);
		//1. 토큰 요청을 위한 url
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		
		//2. 토큰 요청 파라미터 설정
		Map<String, String> tokenRequestSet = new HashMap<>();
		tokenRequestSet.put("Content-Type", "application/x-www-form-urlencoded");
		tokenRequestSet.put("grant_type", "authorization_code");
		tokenRequestSet.put("client_id", REST_API_KEY);
		tokenRequestSet.put("redirect_uri", REDIRECT_URI);
		tokenRequestSet.put("code", authorize_code);
		
		// 3. RestTemplate를 사용하여 POST 요청으로 카카오에 토큰 요청
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, tokenRequestSet, Map.class);
		
		// 4. 응답에서 액세스 토큰 추출
		String accessToken = (String) response.getBody().get("access_token");
		
		// 5. 토큰으로 사용자 정보 요청 --> 여기서 부터하면됨
		String userInfoUrl = "";
	}
	
	@GetMapping("/token/callback")
	public void KakaoTokenCallback(@RequestParam String code) {
	}
	
}
