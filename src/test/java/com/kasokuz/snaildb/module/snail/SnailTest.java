package com.kasokuz.snaildb.module.snail;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

@SpringBootTest
public abstract class SnailTest {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private SnailService service;
	
	protected Superfamily superfamily;
	protected Family family;
	protected Genus genus;
	protected Species species;
	protected Subspecies subspecies;

	@Before
	public void populateDatabase() {
		
		superfamily = new Superfamily();
		superfamily.setName("achatinoidea");
		superfamily = service.saveSuperfamily(superfamily);
		
		family = new Family();
		family.setSuperfamily(superfamily);
		family.setName("achatinidae");
		family = service.saveFamily(family);
		
		genus = new Genus();
		genus.setFamily(family);
		genus.setName("achatina");
		genus = service.saveGenus(genus);
		
		species = new Species();
		species.setGenus(genus);
		species.setName("achatina");
		species = service.saveSpecies(species);
		
		subspecies = new Subspecies();
		subspecies.setSpecies(species);
		subspecies.setName("depravata");
		subspecies = service.saveSubspecies(subspecies);
		
	}

	@After
	public void depopulateDatabase() {
		
		// cascade delete must be used
		service.deleteSuperfamily(superfamily.getSuperfamilyId());
		
	}
	
}
