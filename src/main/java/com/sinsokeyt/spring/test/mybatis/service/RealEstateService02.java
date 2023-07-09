package com.sinsokeyt.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.repository.RealEstateRepository02;

@Service
public class RealEstateService02 {
	
	@Autowired
	private RealEstateRepository02 realEstateRepository;
	
	public List<RealEstate> getRealEstate(int rentPrice) {
		List<RealEstate> realEstate = realEstateRepository.selectRealEstate02(rentPrice);
		return realEstate;
	}
}
