package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
	
	@Query(value = "SELECT * FROM orders JOIN taverntable ON orders.tableid = taverntable.id WHERE partyname = ?1",nativeQuery = true)
	Optional<Orders> findByPartyName(String partyname);

}
