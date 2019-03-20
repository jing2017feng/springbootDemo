package com.ocloudwork.boot.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocloudwork.boot.demo.annotation.RuntimeLog;
import com.ocloudwork.boot.demo.dao.UserRepository;
import com.ocloudwork.boot.demo.domain.User;
import com.ocloudwork.boot.demo.dto.UserDto;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ModelMapper modelMapper;

	@RuntimeLog
	public List<UserDto> showAllUser() {
		List<User> users = userRepository.findAll();
		modelMapper.addMappings(new PropertyMap<User, UserDto>() {
			protected void configure() {
				//属性名不一样，自己设置对应关系
				//source生成目标类，destination数据来源类，这两个单词可以理解成两个指针，代指类
				map().setUserName(source.getName());
				//不映射某些属性
				//属性是对象的可以如下
				skip().setCreateBy(null);
				//属性非对象的
				skip(destination.getStatus());//可以对source中属性设置，也可以对destination的属性设置
			}
		});
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@RuntimeLog
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	@RuntimeLog
	public List<User> queryUserById(String id) {
		return userRepository.queryUserById(id);
	}

	@RuntimeLog
	@Async
	public CompletableFuture<String> printUser() {
		logger.info("123456789");
		return CompletableFuture.completedFuture("123");
	}

	@RuntimeLog
	@Transactional
	public User saveUser(User user) {
		user.setCreateBy("jingfeng");
		mongoTemplate.save(user);
		user= userRepository.save(user);
		return user;
	}
	
	@Async
    public CompletableFuture<List<User>> findUsers(){
		List<User> users = userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }
}
