package com.example.demo.config.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.TavernTable;
import com.example.demo.service.TavernTableService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:tavertable-schema.sql",
"classpath:taverntable-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TavernTableControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TavernTableService service;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	//@Order(3)
	public void testDelete() throws Exception {
		this.mvc.perform(delete("/user/delete/1")).andExpect(status().isNoContent());
	}
	
	@Test
	//@Order(1)
	//@BeforeEach
	public void testCreate() throws Exception{
		TavernTable tav = new TavernTable("abc",1L,true);
		System.out.println("**************");
		System.out.println(this.mapper);
		System.out.println("**********");
		String tabAsJSON = this.mapper.writeValueAsString(tav);
		
		RequestBuilder request = post("/user/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(tabAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		TavernTable tabSaved = new TavernTable(2L,"abc",1L,true);
		String tabSavedAsJSON = this.mapper.writeValueAsString(tabSaved);
		ResultMatcher checkBody = content().json(tabSavedAsJSON);
		
		this.mvc.perform(request).andExpect( checkBody);
		
	}
	@Test
	
	public void testGetAll() throws Exception {
		TavernTable tav = new TavernTable(1L,"Fraserefsgs",3l,false);
		this.service.create(tav);
		String tablesJSON = this.mapper.writeValueAsString(List.of(tav));
		RequestBuilder request = get("/user/readAll");
		
		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody =  content().json(tablesJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	@Order(2)
	public void testUpdate() throws Exception {
		TavernTable me = new TavernTable("Fraserefsgs",3l,false);
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); // matcher that we will use to test the response

		TavernTable meSaved = new TavernTable(1L,"Fraserefsgs",3l,false);
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody =  content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);


}}
