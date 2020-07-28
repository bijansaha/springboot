package com.example.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
class DemoApplicationTests extends TestCase{

	private String uri; 
	   protected MockMvc mvc;
	   @Autowired
	   WebApplicationContext webAC;

	   @Override
	   @Before
	   protected void setUp() throws Exception {
		   super.setUp();	      
	   }
	   
	   protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper om = new ObjectMapper();
	      return om.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper om = new ObjectMapper();
	      return om.readValue(json, clazz);
	   }
	   
	@Test
	void contextLoads() {
	}

	@Test
	   public void getEmployeeList() throws java.lang.Exception  {
	      String uri = "/employeelist";
	      mvc = MockMvcBuilders.webAppContextSetup(webAC).build();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      Assert.assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Employee[] empList = mapFromJson(content, Employee[].class);
	      System.out.println(empList);
	      Assert.assertTrue(empList.length > 0);
	   }
	
}
