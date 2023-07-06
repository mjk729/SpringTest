package com.sinsokeyt.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lifecycle/test01")
@Controller
public class Test01Controller {
	
	@RequestMapping("/1")
	@ResponseBody
	public String wellCome() {
		return "<h2>테스트 프로젝트</h2> <h4>해당 프로젝트를 통해서 문제를 풀어봅시다</h4>";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> scoreResponse(){
	Map<String, Integer> score = new HashMap<>();
	
	score.put("국어",80);
	score.put("수학",90);
	score.put("영어",70);
	
	return score;
	}
}
