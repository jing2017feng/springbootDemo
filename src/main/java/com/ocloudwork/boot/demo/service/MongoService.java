package com.ocloudwork.boot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ocloudwork.boot.demo.dao.PersonRepository;
import com.ocloudwork.boot.demo.domain.User;

@Service
public class MongoService {
	@Autowired
    private MongoTemplate mongoTemplate;
	@Autowired
	private PersonRepository personRepository;

    /**
     * 创建对象
     * @param user
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    public User findUserByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query , User.class);
    }

    /**
     * 更新对象
     * @param user
     */
    public void updateUser(User user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("userName", user.getName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,User.class);
        //更新查询返回结果集的所有
        mongoTemplate.updateMulti(query,update,User.class);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }
}
