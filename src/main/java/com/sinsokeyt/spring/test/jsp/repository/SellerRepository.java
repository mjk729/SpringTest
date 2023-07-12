package com.sinsokeyt.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.jsp.domain.Seller;

@Repository
public interface SellerRepository {

	public int insertSeller(@Param("nickname") String nickname
			,@Param("profileImageUrl") String profileImageUrl
			,@Param("temperature") double temperature);
	
	public Seller selectLastSeller();
	
	public Seller selectSellerById(@Param("id") int id);
}
