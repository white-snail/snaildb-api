package com.kasokuz.snaildb.module.snail.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.dto.Taxonomer;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.admin.response.AddTaxonomerResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "settaxonomer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetTaxonomerController {
	
	@Autowired
	private SnailService service;

	@PostMapping(value = "add")
	public AddTaxonomerResponse addTaxonomer(@RequestParam String name, @RequestParam String surname) {
		Taxonomer taxonomer = new Taxonomer();
		taxonomer.setName(name);
		taxonomer.setSurname(surname);
		this.service.saveTaxonomer(taxonomer);
		return new AddTaxonomerResponse(taxonomer);
	}
	
	@PostMapping(value = "delete")
	public void deleteTaxonomer(@RequestParam Integer taxonomerId) {
		this.service.deleteTaxonomer(taxonomerId);
	}
	
}
