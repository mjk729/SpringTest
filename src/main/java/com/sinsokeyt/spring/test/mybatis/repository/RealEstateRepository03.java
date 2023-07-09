package com.sinsokeyt.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository03 {

	public List<RealEstate> selectRealEstate03(@Param("area") int area, @Param("price") int price);
}
