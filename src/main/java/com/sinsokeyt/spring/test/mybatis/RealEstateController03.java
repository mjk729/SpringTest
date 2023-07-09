package com.sinsokeyt.spring.test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.service.RealEstateService03;

@Controller
public class RealEstateController03 {

	@Autowired
	private RealEstateService03 realEstateService;
	
	@ResponseBody
	@RequestMapping("/mybatis/realEstate03")
	public List<RealEstate> realEstate(@Param("area") int area, @Param("price") int price) {
		List<RealEstate> realEstate = realEstateService.getRealEstate(area, price);
		return realEstate;
	}
}
