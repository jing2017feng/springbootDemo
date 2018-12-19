package com.ocloudwork.boot.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ocloudwork.boot.demo.domain.User;

@Mapper
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByName(String name);

	@Select("select name,age from user where id=#{id}")
	public List<User> queryUserById(@Param("id") String id);
}
