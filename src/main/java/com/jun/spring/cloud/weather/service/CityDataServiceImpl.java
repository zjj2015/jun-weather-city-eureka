package com.jun.spring.cloud.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.management.StringValueExp;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.jun.spring.cloud.weather.util.XmlBuilder;
import com.jun.spring.cloud.weather.vo.City;
import com.jun.spring.cloud.weather.vo.CityList;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		//读取xml文件
		Resource resource = new ClassPathResource("citylist.xml");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		StringBuffer buffer=new StringBuffer();
		String line="";
		while((line=br.readLine())!=null) {
			buffer.append(line);
		}
		br.close();
		
		//XML转为java对象
		CityList cityList=(CityList)XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
		return cityList.getCityList();
	}

}
