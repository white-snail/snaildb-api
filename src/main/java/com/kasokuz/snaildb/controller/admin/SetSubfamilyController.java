package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Subfamily;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setsubfamily", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSubfamilyController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear) {
		Subfamily subfamily = new Subfamily();
		if(id != null) subfamily.setSubfamilyId(id);
		subfamily.setName(name);
		for(Integer taxonomer : taxonomers) subfamily.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		subfamily.setTaxonomyYear(taxonomyYear);
		this.service.saveSubfamily(subfamily);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSubfamily(id);
		return new SuccessfulResponse();
	}

}
