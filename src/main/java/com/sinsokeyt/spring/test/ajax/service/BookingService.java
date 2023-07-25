package com.sinsokeyt.spring.test.ajax.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sinsokeyt.spring.test.ajax.domain.Booking;
import com.sinsokeyt.spring.test.ajax.repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBookingList() {
		List<Booking> bookingList = bookingRepository.selectBooking();
		return bookingList;
	}
	
	public int addBooking(String name,
			Date date,
			int day,
			int headcount,
			String phoneNumber) {
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber);
		return count;
	}
	
	//url 전달받고 리턴하는 함수
		public boolean isDuplicateInfo(String name, String phoneNumber) {
			int count = bookingRepository.selectCountInfo(name, phoneNumber);
			
			return count != 0;
			
		}
	
}
