package com.kasokuz.snaildb.module.snail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.web.get.GetByNameSnailController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTest extends SnailTest {
	
	@Autowired
	private GetByNameSnailController controller;
	
	/*@Test
	public void testGetSuperfamily() {
		Result<Superfamily> result = controller.getSuperfamily(superfamily.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetFamily() {
		Result<Family> result = controller.getFamily(superfamily.getName(), family.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetGenus() {
		Result<Genus> result = controller.getGenus(superfamily.getName(), family.getName(), genus.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetSpecies() {
		Result<Species> result = controller.getSpecies(superfamily.getName(), family.getName(), genus.getName(), species.getName());
		Assert.assertNotNull(result.getResult());
	}
	
	@Test
	public void testGetSubspecies() {
		Result<Subspecies> result = controller.getSubspecies(superfamily.getName(), family.getName(), genus.getName(), species.getName(), subspecies.getName());
		Assert.assertNotNull(result.getResult());
	}*/

}
