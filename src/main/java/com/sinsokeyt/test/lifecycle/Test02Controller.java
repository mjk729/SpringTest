package com.sinsokeyt.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		// @controller + @responseBody
@RequestMapping("/lifecycle/test02")
public class Test02Controller {

	@RequestMapping("/1")
	public List<Map<String, Object>> movieResponse() {
		List<Map<String, Object>> movieList = new ArrayList<>();

		Map<String, Object> movie = new HashMap<>();

		movie.put("rate", 15);
		movie.put("direct", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		movieList.add(movie);

		movie = new HashMap<>();
		movie.put("rate", 0);
		movie.put("direct", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 12);
		movie.put("direct", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("direct", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("direct", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movieList.add(movie);
		
		return movieList;
	}
	
	@RequestMapping("/2")
	public List<Post> postList() {
		
		// 요렇게도 가능
//		List<Post> postList = new ArrayList<>();
//		Post post = new Post("안녕하세요, 가입인사 드립니다.","hangulu","안녕하세요, 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
//		postList.add(post);
//		
//		post = new Post("헐, 대박","bada","오늘 목요일이 었어.....금요일인줄");
//		postList.add(post);
//		
//		post = new Post("오늘 데이트 한 이야기 해드릴게요", "dulumary","......");
//		postList.add(post);
//		
//		return postList;
		
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post("안녕하세요, 가입인사 드립니다.","hangulu","안녕하세요, 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		postList.add(post1);
		
		Post post2 = new Post("헐, 대박","bada","오늘 목요일이 었어.....금요일인줄");
		postList.add(post2);
		
		Post post3 = new Post("오늘 데이트 한 이야기 해드릴게요", "dulumary","......");
		postList.add(post3);
		
		return postList;
	}
		
	
	
	@RequestMapping("/3")
	public ResponseEntity<Map<String, String>> entityresponse(){
		
		Map<String, String> entity = new HashMap<>();
		entity.put("title","안녕하세요, 가입인사 드립니다.");
		entity.put("user", "hangulu");
		entity.put("content", "안녕하세요, 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		ResponseEntity<Map<String, String>> entityResult = new ResponseEntity(entity,HttpStatus.INTERNAL_SERVER_ERROR);
		return entityResult;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Post> postError(){
		Post post = new Post("안녕하세요, 가입인사 드립니다.","hangulu","안녕하세요, 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		ResponseEntity<Post> entity = new ResponseEntity<>(post,HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
