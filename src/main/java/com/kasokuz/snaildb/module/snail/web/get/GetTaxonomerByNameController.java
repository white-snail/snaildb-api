package com.kasokuz.snaildb.module.snail.web.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.Result;
import com.kasokuz.snaildb.module.snail.web.get.response.GetTaxonomerResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("gettaxonomerbyname")
public class GetTaxonomerByNameController {
	
	@Autowired
	private SnailService service;

	@GetMapping(value = "{surname}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Result<GetTaxonomerResponse> getTaxonomer(@PathVariable String surname) {
		return new Result<>(GetTaxonomerResponse.from(service.getTaxonomer(surname)));
	}
	
}
