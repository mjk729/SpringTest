package com.sinsokeyt.spring.test.jstl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsokeyt.spring.test.jstl.domain.Weather;
import com.sinsokeyt.spring.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	// 모든 날씨 정보를 조회 한다
	public List<Weather> getWeather() {
		List<Weather> weather = weatherRepository.selectWeather();
		return weather;
	}

	public int addWeather(Date date, String weather, double temperatures, double precipitation, String microDust,
			double windSpeed) {
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust,
				windSpeed);
		return count;
	}
	
	public int addWeatherByObject(Weather weather2) {
		int count = weatherRepository.insertWeatherByObject(weather2);
		return count;
	}
}
