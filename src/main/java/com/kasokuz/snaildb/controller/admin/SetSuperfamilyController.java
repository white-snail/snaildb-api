package com.kasokuz.snaildb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.admin.response.SuccessfulResponse;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "setsuperfamily", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class SetSuperfamilyController {
	
	@Autowired
	private SnailService service;
	
	@PostMapping(value = "edit")
	public SuccessfulResponse postEdit(@RequestParam(required = false) Integer id, @RequestParam String name, @RequestParam Integer[] taxonomers, @RequestParam Integer taxonomyYear, @RequestParam Boolean complete, @RequestParam String type, @RequestParam Boolean airBreathing) {
		Superfamily superfamily = new Superfamily();
		if(id != null) superfamily.setSuperfamilyId(id);
		superfamily.setName(name);
		for(Integer taxonomer : taxonomers) superfamily.getTaxonomers().add(this.service.getTaxonomer(taxonomer));
		superfamily.setTaxonomyYear(taxonomyYear);
		superfamily.setComplete(complete);
		superfamily.setType(type);
		superfamily.setAirBreathing(airBreathing);
		this.service.saveSuperfamily(superfamily);
		return new SuccessfulResponse();
	}
	
	@PostMapping(value = "delete")
	public SuccessfulResponse postDelete(@RequestParam Integer id) {
		this.service.deleteSuperfamily(id);
		return new SuccessfulResponse();
	}

}
