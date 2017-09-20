package com.ziniu.controller;

import com.ziniu.domain.PersonDemo;
import com.ziniu.repository.PersonRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataControllerForRedis {
	
	@Autowired
	PersonRedisDao personRedisDao;
	
	@RequestMapping("/set") //1
	public void set(){
		PersonDemo person = new PersonDemo("2","dingjiagong", 27);
		personRedisDao.save(person);
		personRedisDao.stringRedisTemplateDemo();
	}
	
	@RequestMapping("/getStr") //2
	public String getStr(){
		return personRedisDao.getString();
	}
	
	@RequestMapping("/getPerson") //3
	public PersonDemo getPerson(){
		return personRedisDao.getPerson();
	}
}
