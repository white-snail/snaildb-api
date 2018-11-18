package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Subgenus;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setsubgenus", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSubgenusController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear) {
		Subgenus subgenus = new Subgenus();
		if(id != null) subgenus.setSubgenusId(id);
		subgenus.setName(name);
		for(Integer taxonomer : taxonomers) subgenus.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		subgenus.setTaxonomyYear(taxonomyYear);
		this.service.saveSubgenus(subgenus);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSubgenus(id);
		return new SuccessfulResponse();
	}

}
