package com.example.demo.config.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.domain.Orders;
import com.example.demo.domain.TavernTable;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

	
	@InjectMocks
	private OrderService service;
	
	@Mock
	private OrderRepo repo;
	
	@Mock
	public TavernTable tavTab = new TavernTable("asd", 2l, true);
	
	@Test
	public void createTest() {
		Orders order = new Orders(1l,1l,1l,1l,tavTab);
		Orders output = new Orders(1l,1l,1l,1l,tavTab);
		System.out.println(this.repo);
		Mockito.when(this.repo.saveAndFlush(order)).thenReturn(output);

		assertEquals(output, this.service.create(order));

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(Mockito.any());

	}
	@Test
	public void readAllTest() {
		Orders input = new Orders(1l,1l,1l,tavTab);
		List<Orders> readAll = new ArrayList<>();
		Orders output = new Orders(1L, 1l,1l,1l,tavTab);
		readAll.add(output);

		Mockito.when(this.repo.findAll()).thenReturn(readAll);

		assertEquals(readAll, this.service.readAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	@Test
	public void updateTest() {
		Long id = 1l;
		Optional<Orders> exists = Optional.of(new Orders(1l,1l,1l,1l,tavTab));
		Orders input = new Orders(1L,1L,1L,tavTab);
		Orders output = new Orders(1L, 1L,1L,1L,tavTab);
		
		Mockito.when(this.repo.findById(id)).thenReturn(exists);
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);

		System.out.println(this.service.update(id, input));
		
		assertEquals(output, this.service.update(id, input));
		
		Mockito.verify(this.repo,Mockito.times(2)).findById(id);
			
	}
	@Test
	public void deleteTest() {
		Long id =1L;
		Boolean answer = false;
		assertEquals(answer, this.service.delete(id));
		
		Mockito.verify(this.repo,Mockito.times(1)).existsById(id);
	}
	@Test
	public void getByPartyNameTest() {
		String name = "bobby";
		Optional<Orders> tav = Optional.of(new Orders(1L, 1l,1l,1l,tavTab));
		Mockito.when(this.repo.findByPartyName(name)).thenReturn(tav);
		
		assertEquals(tav.get(),this.service.getByPartyName("bobby"));
	}
}
