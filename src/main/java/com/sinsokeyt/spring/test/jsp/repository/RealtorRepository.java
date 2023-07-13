package com.sinsokeyt.spring.test.jsp.repository;

import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.jsp.domain.Realtor;

@Repository
public interface RealtorRepository {
	
	public int insertRealtor(Realtor realtor);
}
