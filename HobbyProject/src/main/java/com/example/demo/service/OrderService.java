package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Orders;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderService {

	private OrderRepo repo;

	public OrderService(OrderRepo repo) {
		super();
		this.repo = repo;
	}

	public Orders create(Orders order) {
		return this.repo.saveAndFlush(order);
	}

	public List<Orders> readAll() {
		return this.repo.findAll();
	}
	
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	public Orders getByPartyName(String partyName) {
		return this.repo.findByPartyName(partyName).get();
	}
	public Orders update(Long id, Orders order) {
		Orders exists = this.repo.findById(id).get();
		exists.setDrinkId(order.getDrinkId());
		exists.setFoodId(order.getFoodId());
		exists.setTableId(order.getTableId());
		exists.setTavTab(order.getTavTab());
		return this.repo.saveAndFlush(exists);
	}
}
