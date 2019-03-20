package com.ocloudwork.boot.demo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringbootDemoApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
    StringEncryptor stringEncryptor;
	
	/**
	 * 接口可访问性测试
	 * @throws Exception
	 */
	@Test
	public void testFindUserById() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/queryUserById?id=40288abb699a559c01699a55e7710000"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	/**
	 * 接口返回数据测试
	 * @throws Exception
	 */
	@Test
	public void queryUserById() throws Exception {
		String url = "/user/queryUserById?id=40288abb699a559c01699a55e7710000";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		//访问返回状态
		int status = mvcResult.getResponse().getStatus();
		//接口返回结果
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		Assert.assertTrue("错误", status == 200);
	}
	
}
