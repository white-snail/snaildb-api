package com.kasokuz.snaildb.module.snail.web.get;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.domain.Taxonomer;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllTaxonomersResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getalltaxonomers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetAllTaxonomers {
	
	@Autowired
	private SnailService service;
	
	@GetMapping
	public List<GetAllTaxonomersResponse> getAll() {
		List<GetAllTaxonomersResponse> response = new ArrayList<>();
		for(Taxonomer taxonomer : this.service.getTaxonomers()) {
			response.add(new GetAllTaxonomersResponse(taxonomer));
		}
		return response;
	}

}
