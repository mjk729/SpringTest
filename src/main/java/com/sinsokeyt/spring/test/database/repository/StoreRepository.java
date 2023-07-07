package com.sinsokeyt.spring.test.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinsokeyt.spring.test.database.domain.Store;


@Repository
public interface StoreRepository {
	
	public List<Store> selectStoreList();
	
}
