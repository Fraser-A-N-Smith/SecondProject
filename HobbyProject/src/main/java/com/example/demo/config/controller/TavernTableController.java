package com.example.demo.config.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TavernTable;
import com.example.demo.service.TavernTableService;

@RestController
@RequestMapping("/user")
public class TavernTableController {

	private List<TavernTable> tavernTables = new ArrayList<>();

	public TavernTable testTab = new TavernTable("aghsdug", 2l, false);
	
	@Autowired
	private TavernTableService service; // injecting dependencies

	public TavernTableController(TavernTableService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<TavernTable> create(@RequestBody TavernTable tavtable){
		System.out.println(tavtable);
		this.tavernTables.add(tavtable);
		return new ResponseEntity<TavernTable>(this.service.create(tavtable),HttpStatus.CREATED);
	}
	
	@GetMapping("readAll")
	public ResponseEntity<List<TavernTable>> readAll(){
		return new ResponseEntity<List<TavernTable>>(this.service.readAll(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TavernTable> update(@PathVariable Long id, @RequestBody TavernTable tavTable) {

		return new ResponseEntity<TavernTable>( this.service.update(id,tavTable),HttpStatus.ACCEPTED);}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TavernTable> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<TavernTable>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<TavernTable>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/getByPartyName/{partyname}")
	public ResponseEntity<TavernTable> getUserByUsername(@PathVariable String partyname){
		return new ResponseEntity<TavernTable>(this.service.getBypartyName(partyname), HttpStatus.OK);
	}
	}

