package com.example.demo.config.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.domain.TavernTable;
import com.example.demo.repo.TavernTableRepo;
import com.example.demo.service.TavernTableService;

@RunWith(MockitoJUnitRunner.class)
public class TavernTableTest {
	
	@InjectMocks
	private TavernTableService service;
	
	@Mock TavernTableRepo repo;
	
	@Test
	public void createTest() {
		TavernTable tab = new TavernTable("asd",2l,true);
		TavernTable output = new TavernTable(1L, "asd", 2l, true);
		
		Mockito.when(this.repo.saveAndFlush(tab)).thenReturn(output);
		
		assertEquals(output, this.service.create(tab));
	
		Mockito.verify(this.repo,Mockito.times(1)).saveAndFlush(Mockito.any());
	
	}
	
	@Test
	public void readAllTest() {
		TavernTable input = new TavernTable("asd",2l,true);
		List<TavernTable> readAll = new ArrayList<>();
		TavernTable output = new TavernTable(1L, "asd",2l,true);
		readAll.add(output);
		
		Mockito.when(this.repo.findAll()).thenReturn(readAll);
		
		assertEquals(readAll, this.service.readAll());
		
		Mockito.verify(this.repo,Mockito.times(1)).findAll();
	}

}
