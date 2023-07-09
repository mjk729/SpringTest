package com.sinsokeyt.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository01 {
	
	public RealEstate selectRealEstate01(@Param("id")int id);
}
