package com.sinsokeyt.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	// 전달된 id와 일치하는 매물 정보 얻기, 서비스는 순수한 자바 클래스임으로 자바 문법만 사용
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	
	// 전달된 월세보다 낮은 매물 정보 얻기
		public List<RealEstate> getRealEstateByRentPrice(int rentPrice){
			List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByRentPrice(rentPrice);
			return realEstateList;
		}
	
	// 면적과 가격 전달 받고, 해당하는 매물 정보 얻기
		public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {
			List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByAreaPrice(area, price);
			return realEstateList;
		}
}
