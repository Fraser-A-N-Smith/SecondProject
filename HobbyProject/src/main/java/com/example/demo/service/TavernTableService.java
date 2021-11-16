package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.TavernTable;
import com.example.demo.repo.TavernTableRepo;

@Service
public class TavernTableService {

	private TavernTableRepo repo;

	public TavernTableService(TavernTableRepo repo) {
		super();
		this.repo = repo;
	}

	//private List<TavernTable> tavernTables = new ArrayList<>();
	
	public TavernTable create(TavernTable tavtable) {
		
		return this.repo.saveAndFlush(tavtable);
	}
	
	public List<TavernTable> readAll(){
		return this.repo.findAll();
	}
	
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	public TavernTable getBypartyName(String partyName) {
		return this.repo.findByPartyName(partyName).get();
	}
	public TavernTable update(Long id, TavernTable tavtable) {
		TavernTable exists = this.repo.findById(id).get();
		exists.setPartyName(tavtable.getPartyName());
		exists.setPartyTab(tavtable.getPartyTab());
		exists.setHasMagic(tavtable.isHasMagic());
		return this.repo.saveAndFlush(exists);
	}
}
