package com.sinsokeyt.spring.test.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsokeyt.spring.test.jpa.domain.Company;
import com.sinsokeyt.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		Company company = companyService.addCompany(name, business, scale, headcount);
		
		String name2 = "버블팡";
		String business2 = "여신 금융업";
		String scale2 = "대기업";
		int headcount2 = 6834;
		
		Company company2 = companyService.addCompany(name2, business2, scale2, headcount2);
		
		companyList.add(company);
		companyList.add(company2);
		
		
		return companyList;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		companyService.deleteCompany(8);
		return "삭제 완료";
	}
	
}
