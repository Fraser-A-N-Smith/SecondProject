package com.example.demo.config.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Orders;
import com.example.demo.domain.TavernTable;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = { "classpath:order-schema.sql",
		"classpath:order-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class OrderControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private OrderService service;

	
	public TavernTable tavTab = new TavernTable("asd", 2l, true);

	@Test
	public void testDelete() throws Exception {
		this.mvc.perform(delete("/order/delete/0")).andExpect(status().isNoContent());
	}

	@Test
	public void testCreate() throws Exception {
		Orders tav = new Orders(1l, 1l, 1l, tavTab);
		System.out.println("**************");
		System.out.println(this.mapper);
		System.out.println("**********");
		String tabAsJSON = this.mapper.writeValueAsString(tav);

		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(tabAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		Orders tabSaved = new Orders(1L, 1l, 1l, 1l, tavTab);
		String tabSavedAsJSON = this.mapper.writeValueAsString(tabSaved);
		ResultMatcher checkBody = content().json(tabSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus);//.andExpect(checkBody).andExpect(checkStatus);

	}

	@Test
	public void testGetAll() throws Exception {
		Orders tav = new Orders(1L, 1l, 1l, 1l, tavTab);
		String tablesJSON = this.mapper.writeValueAsString(List.of(tav));
		RequestBuilder request = get("/order/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(tablesJSON);
		System.out.println("****************");
		System.out.println(checkBody);
		System.out.println("00000000000000000");
		this.mvc.perform(request).andExpect(checkStatus);//andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	public void testUpdate() throws Exception {
		Orders me = new Orders(1l, 1l, 1l, tavTab);
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); // matcher that we will use to test the response

		Orders meSaved = new Orders(1L, 1l, 1l, 1l, tavTab);
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
}
