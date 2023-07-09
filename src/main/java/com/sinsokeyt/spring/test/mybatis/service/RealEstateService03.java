package com.sinsokeyt.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.repository.RealEstateRepository03;

@Service
public class RealEstateService03 {
	
	@Autowired
	private RealEstateRepository03 realEstateRepository;
	
	public List<RealEstate> getRealEstate(int area, int price) {
		List<RealEstate> realEstate = realEstateRepository.selectRealEstate03(area, price);
		return realEstate;
	}
}
