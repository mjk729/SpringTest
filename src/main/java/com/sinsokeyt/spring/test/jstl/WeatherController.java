package com.sinsokeyt.spring.test.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinsokeyt.spring.test.jstl.domain.Weather;
import com.sinsokeyt.spring.test.jstl.service.WeatherService;

@RequestMapping("/jstl/weather/")
@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/list")
	public String createWeather(Model model) {
		List<Weather> weather = weatherService.getWeather();
		model.addAttribute("weather", weather);
		return "jstl/weather";
	}

	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather_input";
	}

	@GetMapping("/add")
	public String createWeather(
//			@RequestParam("date") @DateTimeFormat(pattern="yyyy년 MM월 dd일") Date date, @RequestParam("weather") String weather,
//			@RequestParam("temperatures") double temperatures, @RequestParam("precipitation") double precipitation,
//			@RequestParam("microDust") String microDust, @RequestParam("windSpeed") double windSpeed
			@ModelAttribute Weather weather2) {

//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust,
//				windSpeed);
		
		int count = weatherService.addWeatherByObject(weather2);
		
		return "redirect:/jstl/weather/list";
	}

}
