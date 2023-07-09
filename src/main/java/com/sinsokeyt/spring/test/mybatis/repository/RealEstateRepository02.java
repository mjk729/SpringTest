package com.sinsokeyt.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository02 {
	
	public List<RealEstate> selectRealEstate02(@Param("rentPrice") int rentPrice);
}
