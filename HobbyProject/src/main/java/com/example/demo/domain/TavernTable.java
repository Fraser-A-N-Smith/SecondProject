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
	
	@Column( unique = true)
	private String partyName;
	
	@Column()
	private Long partyTab;
	
	@Column()
	private boolean hasMagic;

	public TavernTable(String partyName, Long partyTab, boolean hasMagic) {
		super();
		this.partyName = partyName;
		this.partyTab = partyTab;
		this.hasMagic = hasMagic;
	}
	


	public TavernTable(long id, String partyName, Long partyTab, boolean hasMagic) {
		super();
		this.id = id;
		this.partyName = partyName;
		this.partyTab = partyTab;
		this.hasMagic = hasMagic;
	}



	public TavernTable() {
		super();
		// TODO Auto-generated constructor stub
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



	@Override
	public String toString() {
		return "TavernTable [id=" + id + ", partyName=" + partyName + ", partyTab=" + partyTab + ", hasMagic="
				+ hasMagic + "]";
	}
	
	
	

}
