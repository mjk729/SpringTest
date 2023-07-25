package com.sinsokeyt.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.ajax.domain.Favorite;
import com.sinsokeyt.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		model.addAttribute("favoriteList", favoriteList);
		return "ajax/favorite/list";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> createFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			){
	Map<String, String> favoriteMap = new HashMap<>();
	int count = favoriteService.addFavorite(name, url);
	
	if(count == 1) {
		favoriteMap.put("result", "success");
	} else {		
		favoriteMap.put("result", "fail");
	}
	return favoriteMap;
	
	}
	
	@GetMapping("/input")
	public String inputFavorite() {
		return "ajax/favorite/input";
	}
	
	// 중복 검사 API
	@PostMapping("/url_confirm")
	@ResponseBody
	public Map<String, Boolean> isDucatedUrl(@RequestParam("url") String url){
		Map<String, Boolean> resultUrl = new HashMap<>();
		
//		if(favoriteService.isDuplicateUrl(url)) {
//			resultUrl.put("isDuplicate", true);
//		}else {
//			resultUrl.put("isDuplicate", false);
//		}
		resultUrl.put("isDuplicate", favoriteService.isDuplicateUrl(url));
		return resultUrl;
	}
	
	// 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id){
		int count = favoriteService.deleteFavorite(id);
		
		// 성공: {"result":"success"}
		// 실패: {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		}else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	
}
