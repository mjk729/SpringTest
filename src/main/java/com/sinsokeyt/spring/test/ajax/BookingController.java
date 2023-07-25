package com.sinsokeyt.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> createBooking(
			@RequestParam("name") String name,
			@RequestParam("date") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			){
	Map<String, String> bookingMap = new HashMap<>();
	int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
	
	if(count == 1) {
		bookingMap.put("result", "success");
	} else {		
		bookingMap.put("result", "fail");
	}
	return bookingMap;
	
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/search")
	public String searchBooking() {
		return "ajax/booking/search";
	}
	
	// 중복 검사 API
		@PostMapping("/url_confirm")
		@ResponseBody
		public Map<String, Boolean> isDucatedInfo(@RequestParam("name") String name,@RequestParam("phoneNumber") String phoneNumber){
			Map<String, Boolean> resultInfo = new HashMap<>();
			resultInfo.put("isDuplicate", bookingService.isDuplicateInfo(name, phoneNumber));
			return resultInfo;
		}
	
}
