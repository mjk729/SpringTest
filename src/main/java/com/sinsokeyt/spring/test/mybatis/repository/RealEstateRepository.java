package com.sinsokeyt.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository {
	
	// 전달된 id와 일치하는 매물 행 정보 조회
	public RealEstate selectRealEstate(@Param("id")int id);
	
	// 전달된 월세보다 낮은 매물 행 정보 조회
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	
	public List<RealEstate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
}
