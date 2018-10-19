package com.kasokuz.snaildb.module.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.test.context.junit4.SpringRunner;

import com.kasokuz.snaildb.module.snail.service.SnailService;

import net.minidev.json.parser.JSONParser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTest extends SnailTest {
	
	@Test
	public void testGetSuperfamily() throws Exception {
		//TODO
	}
	
	@Test
	public void testGetFamily() {
		
	}

}
