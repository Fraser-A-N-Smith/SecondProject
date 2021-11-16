package com.example.demo.config.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TavernTable;

@RestController
@RequestMapping("/user")
public class TavernTableController {
	
	private List<TavernTable> tavTables = new ArrayList<>();
	
	@Autowired
	private TavernService service; // injecting dependencies
	
	public TavenTableController(TavernService service) {
		this.service = service;
	}

}
