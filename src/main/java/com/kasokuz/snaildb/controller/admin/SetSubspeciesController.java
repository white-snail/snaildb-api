package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setsubspecies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSubspeciesController {

	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id,
										@RequestParam Integer speciesId,
										@RequestParam String name,
										@RequestParam Integer[] taxonomers,
										@RequestParam Integer taxonomyYear,
										@RequestParam Integer minHeight,
										@RequestParam Integer maxHeight,
										@RequestParam Integer minWidth,
										@RequestParam Integer maxWidth,
										@RequestParam Integer lifespan,
										@RequestParam String location) {
		
		Subspecies subspecies = new Subspecies();
		if(id != null) subspecies.setSubspeciesId(id);
		subspecies.setSpecies(this.service.getSpecies(speciesId));
		subspecies.setName(name);
		for(Integer taxonomer : taxonomers) subspecies.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		subspecies.setTaxonomyYear(taxonomyYear);
		subspecies.setMinHeight(minHeight);
		subspecies.setMaxHeight(maxHeight);
		subspecies.setMinWidth(minWidth);
		subspecies.setMaxWidth(maxWidth);
		subspecies.setLifespan(lifespan);
		subspecies.setLocation(location);
		this.service.saveSubspecies(subspecies);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSubspecies(id);
		return new SuccessfulResponse();
	}
	
}
