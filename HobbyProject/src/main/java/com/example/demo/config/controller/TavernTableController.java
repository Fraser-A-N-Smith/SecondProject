package com.example.demo.config.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TavernTable;
import com.example.demo.service.TavernTableService;

@RestController
@RequestMapping("/user")
public class TavernTableController {

	private List<TavernTable> tavernTables = new ArrayList<>();

	@Autowired
	private TavernTableService service; // injecting dependencies

	public TavernTableController(TavernTableService service) {
		super();
		this.service = service;
	}

	

}
