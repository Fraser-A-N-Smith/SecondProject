package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class  TavernTable{
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name", unique = true, nullable = false)
	private String partyName;
	
	@Column(name = "Tab")
	private Long partyTab;
	
	@Column(name = "Mage")
	private boolean hasMagic;

	public TavernTable(String partyName, Long partyTab, boolean hasMagic) {
		super();
		this.partyName = partyName;
		this.partyTab = partyTab;
		this.hasMagic = hasMagic;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Long getPartyTab() {
		return partyTab;
	}

	public void setPartyTab(Long partyTab) {
		this.partyTab = partyTab;
	}

	public boolean isHasMagic() {
		return hasMagic;
	}

	public void setHasMagic(boolean hasMagic) {
		this.hasMagic = hasMagic;
	}
	
	
	

}
