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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasMagic ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + ((partyTab == null) ? 0 : partyTab.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TavernTable other = (TavernTable) obj;
		if (hasMagic != other.hasMagic)
			return false;
		if (id != other.id)
			return false;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		if (partyTab == null) {
			if (other.partyTab != null)
				return false;
		} else if (!partyTab.equals(other.partyTab))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "TavernTable [id=" + id + ", partyName=" + partyName + ", partyTab=" + partyTab + ", hasMagic="
				+ hasMagic + "]";
	}
	
	
	

}
