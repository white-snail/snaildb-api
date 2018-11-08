package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setfamily", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetFamilyController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam Integer superfamilyId, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear) {
		Family family = new Family();
		if(id != null) family.setFamilyId(id);
		family.setSuperfamily(this.service.getSuperfamily(superfamilyId));
		family.setName(name);
		for(Integer taxonomer : taxonomers) family.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		family.setTaxonomyYear(taxonomyYear);
		this.service.saveFamily(family);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteFamily(id);
		return new SuccessfulResponse();
	}

}
