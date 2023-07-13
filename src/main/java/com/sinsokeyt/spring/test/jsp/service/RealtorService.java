package com.sinsokeyt.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.jsp.domain.Realtor;
import com.sinsokeyt.spring.test.jsp.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorpository;
	
	public int addRealtor(Realtor realtor) {
		int count = realtorpository.insertRealtor(realtor);
		return count;
	}
}
