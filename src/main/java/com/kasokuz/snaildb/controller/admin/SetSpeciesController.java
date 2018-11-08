package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setspecies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSpeciesController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam Integer genusId, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear, @RequestParam Boolean viviparous) {
		Species species = new Species();
		if(id != null) species.setSpeciesId(id);
		species.setGenus(this.service.getGenus(genusId));
		species.setName(name);
		for(Integer taxonomer : taxonomers) species.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		species.setTaxonomyYear(taxonomyYear);
		species.setViviparous(viviparous);
		this.service.saveSpecies(species);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSpecies(id);
		return new SuccessfulResponse();
	}

}
