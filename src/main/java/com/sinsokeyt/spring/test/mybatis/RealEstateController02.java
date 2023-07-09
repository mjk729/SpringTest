package com.sinsokeyt.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.service.RealEstateService02;

@Controller
public class RealEstateController02 {
	
	@Autowired
	private RealEstateService02 realEstateService;
	
	@ResponseBody
	@RequestMapping("/mybatis/realEstate02")
	public List<RealEstate> realEstate(@RequestParam("rentPrice") int rentPrice) {
		List<RealEstate> realEstate = (List<RealEstate>) realEstateService.getRealEstate(rentPrice);
		return realEstate;
	}
}
