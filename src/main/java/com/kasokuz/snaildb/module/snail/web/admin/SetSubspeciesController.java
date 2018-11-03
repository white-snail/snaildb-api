package com.kasokuz.snaildb.module.snail.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.domain.Subspecies;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.admin.response.SuccessfulResponse;

@RestController
@RequestMapping(value = "setsubspecies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSubspeciesController {

	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam Integer speciesId, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear, @RequestParam Boolean extinct) {
		Subspecies subspecies = new Subspecies();
		if(id != null) subspecies.setSubspeciesId(id);
		subspecies.setSpecies(this.service.getSpecies(speciesId));
		subspecies.setName(name);
		for(Integer taxonomer : taxonomers) subspecies.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		subspecies.setTaxonomyYear(taxonomyYear);
		subspecies.setExtinct(extinct);
		this.service.saveSubspecies(subspecies);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSubspecies(id);
		return new SuccessfulResponse();
	}
	
}
