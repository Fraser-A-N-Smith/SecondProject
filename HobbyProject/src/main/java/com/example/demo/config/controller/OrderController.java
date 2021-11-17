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

import com.example.demo.domain.Orders;
import com.example.demo.domain.TavernTable;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private List<Orders> orders = new ArrayList<>();
	public TavernTable testTab = new TavernTable("aghsdug", 2l, false);
	public Orders order = new Orders(1L,1L,1L,testTab);
	
	@Autowired
	private OrderService service;

	public OrderController(OrderService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Orders> create(@RequestBody Orders order){
		System.out.println(order);
		this.orders.add(order);
		return new ResponseEntity<Orders>(this.service.create(order),HttpStatus.CREATED);
	}
	
	@GetMapping("readAll")
	public ResponseEntity<List<Orders>> readAll(){
		return new ResponseEntity<List<Orders>>(this.service.readAll(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> update(@PathVariable Long id, @RequestBody Orders order) {

		return new ResponseEntity<Orders>( this.service.update(id,order),HttpStatus.ACCEPTED);}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Orders> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<Orders>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Orders>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/getByPartyName/{partyname}")
	public ResponseEntity<Orders> getUserByUsername(@PathVariable String partyname){
		return new ResponseEntity<Orders>(this.service.getByPartyName(partyname), HttpStatus.OK);
	}

}
