package com.sinsokeyt.spring.test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.mybatis.domain.RealEstate;
import com.sinsokeyt.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	// id를 전달 받고, 해당 매물 정보를 json으로 response에 담는다.
	@ResponseBody
	@RequestMapping("/test01/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	// 월세를 전달 받고, 해당 월세보다 낮은 월세 매물 json으로 response에 담는다.
	@RequestMapping("/test01/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice){
		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	// 면적과 가격을 전달 받고, 면적이 더 넓으면서 싼 매물 json response에 담는다.
	@ResponseBody
	@RequestMapping("/test01/3")
	public List<RealEstate> realEstateByAreaPrice(@Param("area") int area, @Param("price") int price) {
		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaPrice(area, price);
		return realEstateList;
	}
	
	// 매물 정보를 객체로 저장
	@RequestMapping("/test02/1")
	@ResponseBody
	public String createRealEstateByObject() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		int count = realEstateService.addRealEstateByObject(realEstate);
		return "입력 성공 : " + count;
	}
	
	
	// field 로 insert 하기
	@ResponseBody
	@RequestMapping("/test02/2")
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
	}
	
	// id가 22인 행의 type을 전세로 바꾸고 price를 70000로 변경
	@ResponseBody
	@RequestMapping("/test03/1")
	public String updateRealEstate() {
		int count = realEstateService.updateRealEstate(22, "전세", 70000);
		return "수정 성공 : " + count;
	}
	
	// 전달받은 id의 매물 정보 삭제
	@ResponseBody
	@RequestMapping("/test04/1")
	public String deleteRealEstate(@Param("id") int id) {
		int count = realEstateService.deleteRealEstate(id);
		return "삭제 성공 : " + count;
	}
	
}
