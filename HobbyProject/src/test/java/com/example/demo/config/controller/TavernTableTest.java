package com.example.demo.config.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.domain.TavernTable;
import com.example.demo.repo.TavernTableRepo;
import com.example.demo.service.TavernTableService;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TavernTableTest {

//	@InjectMocks
	@Autowired
	private TavernTableService service;

//	@Mock
	@MockBean
	private TavernTableRepo repo;

	@Test
	public void createTest() {
		TavernTable tab = new TavernTable("asd", 2l, true);
		TavernTable output = new TavernTable(1L, "asd", 2l, true);
		System.out.println(this.repo);
		Mockito.when(this.repo.saveAndFlush(tab)).thenReturn(output);

		assertEquals(output, this.service.create(tab));

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(Mockito.any());

	}

	@Test
	public void readAllTest() {
		TavernTable input = new TavernTable("asd", 2l, true);
		List<TavernTable> readAll = new ArrayList<>();
		TavernTable output = new TavernTable(1L, "asd", 2l, true);
		readAll.add(output);

		Mockito.when(this.repo.findAll()).thenReturn(readAll);

		assertEquals(readAll, this.service.readAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	@Test
	public void updateTest() {
		Long id = 1l;
		Optional<TavernTable> exists = Optional.of(new TavernTable(1L,"Fraser",3l,false));
		TavernTable input = new TavernTable(1L,"Fraserefsgs",3l,false);
		TavernTable output = new TavernTable(1L,"Fraserefsgs",3l,false);
		
		Mockito.when(this.repo.findById(id)).thenReturn(exists);
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);

		System.out.println(this.service.update(id, input));
		
		assertEquals(output, this.service.update(id, input));
		
		Mockito.verify(this.repo,Mockito.times(2)).findById(id);
		
	}
	@Test
	public void deleteTest() {
		Long id =1L;
		Boolean answer = true;
		assertEquals(answer, this.service.delete(id));
		
		Mockito.verify(this.repo,Mockito.times(1)).existsById(id);
	}
	@Test
	public void getByPartyNameTest() {
		String name = "bobby";
		Optional<TavernTable> tav = Optional.of(new TavernTable(1L,"bobby",2l,false));
		Mockito.when(this.repo.findByPartyName(name)).thenReturn(tav);
		
		assertEquals(tav.get(),this.service.getBypartyName("bobby"));
	}
}
