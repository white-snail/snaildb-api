package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setgenus", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetGenusController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam Integer familyId, @RequestParam(required = false) Integer subfamilyId, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear) {
		Genus genus = new Genus();
		if(id != null) genus.setGenusId(id);
		genus.setFamily(this.service.getFamily(familyId));
		if(subfamilyId != null) genus.setSubfamily(this.service.getSubfamily(subfamilyId));
		genus.setName(name);
		for(Integer taxonomer : taxonomers) genus.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		genus.setTaxonomyYear(taxonomyYear);
		this.service.saveGenus(genus);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteGenus(id);
		return new SuccessfulResponse();
	}

}
