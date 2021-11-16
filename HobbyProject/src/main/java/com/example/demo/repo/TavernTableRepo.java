package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.TavernTable;

public interface TavernTableRepo extends JpaRepository<TavernTable,Long>{

	@Query(value="SELECT * FROM taverntable WHERE partyname=?1",nativeQuery= true)
	Optional<TavernTable> findByPartyName(String partyname);

}
