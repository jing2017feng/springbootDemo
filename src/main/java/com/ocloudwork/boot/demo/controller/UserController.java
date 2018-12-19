package com.ocloudwork.boot.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.boot.demo.annotation.RuntimeLog;
import com.ocloudwork.boot.demo.domain.User;
import com.ocloudwork.boot.demo.dto.UserDto;
import com.ocloudwork.boot.demo.service.RandomService;
import com.ocloudwork.boot.demo.service.UserService;

@RequestMapping(path = "/user")
@RestController
@CrossOrigin(origins = "http://www.ocloudwork.com", maxAge = 3600)//允许跨域访问接口，类或方法皆可
public class UserController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;
	@Autowired
	private RandomService randomService;

	@Value("${my.info}")
	private String info;

	@RuntimeLog
	@RequestMapping(path = "saveUser", method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(User user) {
		User result = userService.saveUser(user);
		HttpStatus status = result != null ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED;
		return new ResponseEntity<>(result, status);
	}

	@RuntimeLog
	@RequestMapping(path = "showAllUser", method = RequestMethod.GET)
	public List<UserDto> showAllUser() {
		return userService.showAllUser();
	}

	@RuntimeLog
	@RequestMapping(path = "findByName", method = RequestMethod.GET)
	public List<User> findByName(String name) {
		return userService.findByName(name);
	}

	@RuntimeLog
	@RequestMapping(path = "queryUserById", method = RequestMethod.GET)
	@Cacheable(value = "user") // 缓存
	public List<User> queryUserById(String id) {
		return userService.queryUserById(id);
	}

	@RuntimeLog
	@RequestMapping(path = "myInfo", method = RequestMethod.GET)
	public String myInfo(String name) {
		userService.printUser();
		logger.info(randomService.getValue());
		return info;
	}

	@RequestMapping(path = "findUsers", method = RequestMethod.GET)
	public List<User> findUsers() throws InterruptedException, ExecutionException {
		// Kick of multiple, asynchronous lookups
		CompletableFuture<List<User>> users = userService.findUsers();
		CompletableFuture<String> print = userService.printUser();
		// Wait until they are all done
		CompletableFuture.allOf(users, print).join();
		return users.get();
	}

}
