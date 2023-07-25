package com.sinsokeyt.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.ajax.domain.Booking;
import com.sinsokeyt.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		List<Booking> bookingList = bookingService.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "ajax/booking/list";
	}
	
	// 이름, 예약날짜, 숙박일수, 숙박인원, 전화번호
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> createBooking(
			@RequestParam("name") String name,
			@DateTimeFormat(pattern="yyyy년 MM월 dd일") @RequestParam("date") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			){
	Map<String, String> resultMap = new HashMap<>();
	int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
	
	// 성공 {"result":"success"}
	// 실패 {"result":"fail"}
	
	if(count == 1) {
		// 성공
		resultMap.put("result", "success");
	} else {
		// 실패
		resultMap.put("result", "fail");
	}
	return resultMap;
	
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/search")
	public String searchBooking() {
		return "ajax/booking/search";
	}
	
	// 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id){
		
		int count = bookingService.deleteBooking(id);
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// 이름과 전화번호를 전달 받고, 일치하는 예약 정보를 json으로 response에 담는다.
		@GetMapping("/search")
		@ResponseBody
		public Map<String, Object> searchBooking(@RequestParam("name") String name,@RequestParam("phoneNumber") String phoneNumber){
			Booking booking = bookingService.getBookingInfo(name, phoneNumber);
			// 성공, 실패 여부
			// 성공 {"result":"info" : {"name":"홍길동", "headcount":4, .......}
			// 실패 {"result":"fail"}
			Map<String, Object> resultMap = new HashMap<>();
			if(booking==null) {
				// 조회 실패
				resultMap.put("result", "fail");
			}else {
				// 조회 성공
				resultMap.put("result", "success");
				resultMap.put("info", booking);
				
			}
			return resultMap;
		}
	
}
