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
	
	
	// 객체로 데이터를 전달 받고 insert
	public int insertRealEstateByObject(RealEstate realEstate);
	
	
	// 데이터를 전달 받고 insert
	public int insertRealEstate(@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	// 데이터 전달 받고 update
	public int updateRealEstate();
	
	// 데이터 전달 받고 delete
	public int deleteRealEstate(@Param("id") int id);
}
