package com.kasokuz.snaildb.module.snail;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kasokuz.snaildb.module.snail.service.SnailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTest extends SnailTest {
	
	@Autowired
	private SnailService service;
	
	@Before
	public void before() {
		populate(service);
	}
	
	@After
	public void after() {
		depopulate(service);
	}
	
	@Test
	public void testGetSuperfamily() throws Exception {
		
	}
	
	@Test
	public void testGetFamily() {
		
	}

}
