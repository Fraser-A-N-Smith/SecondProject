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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinkId == null) ? 0 : drinkId.hashCode());
		result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
		result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
		result = prime * result + ((tavTab == null) ? 0 : tavTab.hashCode());
		return result;
	}



//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Orders other = (Orders) obj;
//		if (drinkId == null) {
//			if (other.drinkId != null)
//				return false;
//		} else if (!drinkId.equals(other.drinkId))
//			return false;
//		if (foodId == null) {
//			if (other.foodId != null)
//				return false;
//		} else if (!foodId.equals(other.foodId))
//			return false;
//		if (orderId == null) {
//			if (other.orderId != null)
//				return false;
//		} else if (!orderId.equals(other.orderId))
//			return false;
//		if (tableId == null) {
//			if (other.tableId != null)
//				return false;
//		} else if (!tableId.equals(other.tableId))
//			return false;
//		if (tavTab == null) {
//			if (other.tavTab != null)
//				return false;
//		} else if (!tavTab.equals(other.tavTab))
//			return false;
//		return true;
//	}

	

	public Orders() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (drinkId == null) {
			if (other.drinkId != null)
				return false;
		} else if (!drinkId.equals(other.drinkId))
			return false;
		if (foodId == null) {
			if (other.foodId != null)
				return false;
		} else if (!foodId.equals(other.foodId))
			return false;
		if (tableId == null) {
			if (other.tableId != null)
				return false;
		} else if (!tableId.equals(other.tableId))
			return false;
		if (tavTab == null) {
			if (other.tavTab != null)
				return false;
		} else if (!tavTab.equals(other.tavTab))
			return false;
		return true;
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
