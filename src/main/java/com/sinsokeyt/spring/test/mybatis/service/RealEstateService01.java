package com.sinsokeyt.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.repository.RealEstateRepository01;

@Service
public class RealEstateService01 {
	
	@Autowired
	private RealEstateRepository01 realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate01(id);
		return realEstate;
	}
	
	
	
}
