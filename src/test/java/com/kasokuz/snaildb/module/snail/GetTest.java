package com.kasokuz.snaildb.module.snail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kasokuz.snaildb.module.snail.web.Result;
import com.kasokuz.snaildb.module.snail.web.get.GetSnailByNameController;
import com.kasokuz.snaildb.module.snail.web.get.response.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTest extends SnailTest {
	
	@Autowired
	private GetSnailByNameController controller;
	
	@Test
	public void testGetSuperfamily() {
		Result<GetSuperfamilyResponse> result = controller.getSuperfamily(superfamily.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetFamily() {
		Result<GetFamilyResponse> result = controller.getFamily(superfamily.getName(), family.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetGenus() {
		Result<GetGenusResponse> result = controller.getGenus(superfamily.getName(), family.getName(), genus.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetSpecies() {
		Result<GetSpeciesResponse> result = controller.getSpecies(superfamily.getName(), family.getName(), genus.getName(), species.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetSubspecies() {
		Result<GetSubspeciesResponse> result = controller.getSubspecies(superfamily.getName(), family.getName(), genus.getName(), species.getName(), subspecies.getName());
		Assert.assertNotNull(result.getResult());
	}

}
