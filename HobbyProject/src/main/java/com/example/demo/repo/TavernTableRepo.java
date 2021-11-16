package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.TavernTable;

public interface TavernTableRepo extends JpaRepository<TavernTable,Long>{

}
