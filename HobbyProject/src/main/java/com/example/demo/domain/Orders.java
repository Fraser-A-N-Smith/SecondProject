package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column()
	private Long drinkId;
	
	@Column()
	private Long foodId;
	
	@Column( unique = true)
	private Long tableId;
	
	@ManyToOne
	TavernTable tavTab;

	
	
	public Orders(Long orderId, Long drinkId, Long foodId, Long tableId, TavernTable tavTab) {
		super();
		this.orderId = orderId;
		this.drinkId = drinkId;
		this.foodId = foodId;
		this.tableId = tableId;
		this.tavTab = tavTab;
	}

	

	public Orders(Long drinkId, Long foodId, Long tableId, TavernTable tavTab) {
		super();
		this.drinkId = drinkId;
		this.foodId = foodId;
		this.tableId = tableId;
		this.tavTab = tavTab;
	}


	public Orders() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(Long drinkId) {
		this.drinkId = drinkId;
	}

	public TavernTable getTavTab() {
		return tavTab;
	}



	public void setTavTab(TavernTable tavTab) {
		this.tavTab = tavTab;
	}



	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", drinkId=" + drinkId + ", foodId=" + foodId + ", tableId=" + tableId
				+ ", tavTab=" + tavTab + "]";
	}
	
	
	
}
