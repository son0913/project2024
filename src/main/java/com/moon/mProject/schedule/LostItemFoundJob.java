package com.moon.mProject.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.mProject.api.serviceImpl.LostFoundItemServiceImpl;

import java.lang.reflect.Type;



@Component
public class LostItemFoundJob implements Job{

	private static final Logger logger = LoggerFactory.getLogger(LostItemFoundJob.class);
	
	@Autowired
	private LostFoundItemServiceImpl apiService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//실행함수
		logger.info("스케줄러가 매일 오전 1시에 실행됩니다.");
		
		//데이터 가져오는 로직(API 호출 & 저장)
		fetchData();
	}
	
	public void fetchData() {
		logger.info("데이터를 가져오는 중 입니다....");
		int totalCount = 0;
		int size = 0;
		int inc = 0;
		
		//서울시 대중교통 분실물 습득물 정보 테이블 데이터 삭제
		apiService.deleteLostFoundItem(); 
		
		//데이터 TotalCount 조회
		List<Map<String, Object>> total_map = callAPI(inc, totalCount);
		
		Map<String, Object> list_total_count = (Map<String, Object>) total_map.get(0).get("lostArticleInfo");
		totalCount = (int) list_total_count.get("list_total_count");
		
		if(totalCount > 0) {
			size = (int) Math.ceil(totalCount * 0.01);
		}
		
		logger.info("데이터를 저장 중 입니다....");
		
		for(int i = 1; i<size+1; i++) {
			List<Map<String, Object>> map = callAPI(inc, i);
			if(map.size() > 0 && !map.isEmpty()) {
				Map<String, Object> lostArticleInfo = (Map<String, Object>) map.get(0).get("lostArticleInfo");
				List<Map<String, Object>> row = (List<Map<String, Object>>)lostArticleInfo.get("row");

				for(int j = 0; j<row.size(); j++) {
					apiService.insertLostFoundItem(row.get(j)); 
				}
			}else {
				System.out.println("Map is Empty. ");
			}
			
			inc++;
		}
	
		logger.info("데이터를 저장이 완료됐습니다....");
	}

	private List<Map<String, Object>> callAPI(int inc, int totalCount) {
		List<Map<String, Object>> apiData = null;
		
		HttpURLConnection conn = null; //프로토콜이 http일 때 사용 
		BufferedReader reader = null;;
		try {
			String apiUrl = "";
			if(totalCount < 1) {
				apiUrl = "http://openapi.seoul.go.kr:8088/4746554f6263686735324d66516e6a/json/lostArticleInfo/1/1/";
			} else {
				int before = (inc < 1)? 1 : (inc * 1000) + 1;
				int after = totalCount * 1000;
				apiUrl = "http://openapi.seoul.go.kr:8088/4746554f6263686735324d66516e6a/json/lostArticleInfo/"+before+"/"+after+"/";
			}
			String jsonString = "";
			
			//URL 객체 생성
			URL url = new URL(apiUrl);
			
			//HttpUrlConnection 객체 생성
			conn =  (HttpURLConnection) url.openConnection();
			
			//Method 방식 설정(요구하는 방식 설정
			conn.setRequestMethod("GET");
			
			// 연결 타임아웃 5초
			conn.setConnectTimeout(5000);  
			
			//요청에 대한 응답 코드 확인
			int resoponseCode = conn.getResponseCode();
			
			//응답이 성공적일 경우 (HTTP 200 OK)
			if(resoponseCode == HttpsURLConnection.HTTP_OK) {
				logger.info("데이터 통신이 성공했습니다.");
				
				//Buffer와 Stream을 이용하여 응답 데이터 가져오기  //응답 가져올 때 charset은 UTF-8 설정 (한글 깨짐 방지)
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String inputLine;
				StringBuffer res = new StringBuffer();
				
				while((inputLine = reader.readLine()) != null) {
					res.append(inputLine);
				}
				
				jsonString = res.toString();
				ObjectMapper objectMapper = new ObjectMapper();
				apiData = Arrays.asList(objectMapper.readValue(jsonString, HashMap.class));
				
				/**
				 * Exception: jackson.databind.cfg.DatatypeFeature ... 
				 * version upgrade 진행 후 에러 제거 (2.12.2 -> 2.14.0) 
				 * 14Version 에서 생겨난 기능
				 * */
				
				reader.close();
				conn.disconnect();
			}else {
				logger.info("데이터 통신이 실패 했습니다.");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try { reader.close(); } catch (IOException e) {	e.printStackTrace();}
			}
			
			if(conn != null) {
				conn.disconnect();
			}
		}
		return apiData;
	}

}
