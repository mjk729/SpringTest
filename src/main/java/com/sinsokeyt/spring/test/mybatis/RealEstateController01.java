package com.sinsokeyt.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.service.RealEstateService01;

@Controller
public class RealEstateController01 {
	
	
	@Autowired
	private RealEstateService01 realEstateService;
	
	@RequestMapping("/mybatis/realEstate01")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realestate = realEstateService.getRealEstate(id);
		return realestate;
	}
}
