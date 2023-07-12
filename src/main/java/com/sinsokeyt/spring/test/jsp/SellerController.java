package com.sinsokeyt.spring.test.jsp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.jsp.domain.Seller;
import com.sinsokeyt.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String createSeller(@RequestParam("nickname") String nickname
			,@RequestParam("url") String profileImageUrl
			,@RequestParam("temperature") double temperature) {
		
		int count = sellerService.addUser(nickname, profileImageUrl, temperature);
		return "입력 성공 : " + count;
	}
	
	
	@GetMapping("/input")
	public String sellerAdd() {
		return "jsp/sellerAdd";
	}
	
	@GetMapping("/lastseller")
	public String lastSeller(Model model) {
		Seller seller = sellerService.getLastSeller();
		model.addAttribute("result", seller);
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/lastseller")
	public String lastSellerById(Model model, @RequestParam("id") int id) {
		Seller seller = sellerService.getSellerById(id);
		model.addAttribute("result", seller);
		return "jsp/sellerInfo";
		
	}
}
