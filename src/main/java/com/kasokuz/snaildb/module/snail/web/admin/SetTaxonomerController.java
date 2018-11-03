package com.kasokuz.snaildb.module.snail.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.domain.Taxonomer;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.admin.response.SuccessfulResponse;

@RestController
@RequestMapping(value = "settaxonomer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetTaxonomerController {
	
	@Autowired
	private SnailService service;

	@PostMapping(value = "edit")
	public SuccessfulResponse addTaxonomer(@RequestParam(required = false) Integer id, @RequestParam String name, @RequestParam String surname) {
		Taxonomer taxonomer = new Taxonomer();
		if(id != null) taxonomer.setTaxonomerId(id);
		taxonomer.setName(name);
		taxonomer.setSurname(surname);
		this.service.saveTaxonomer(taxonomer);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse deleteTaxonomer(@RequestParam Integer id) {
		this.service.deleteTaxonomer(id);
		return new SuccessfulResponse();
	}
	
}
