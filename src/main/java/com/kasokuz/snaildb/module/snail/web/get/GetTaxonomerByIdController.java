package com.kasokuz.snaildb.module.snail.web.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.Result;
import com.kasokuz.snaildb.module.snail.web.get.response.GetTaxonomerResponse;

@RestController
@RequestMapping("api/gettaxonomerbyid")
public class GetTaxonomerByIdController {
	
	@Autowired
	private SnailService service;

	@GetMapping(value = "{taxonomerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Result<GetTaxonomerResponse> getTaxonomer(@PathVariable Integer taxonomerId) {
		return new Result<>(GetTaxonomerResponse.from(service.getTaxonomer(taxonomerId)));
	}
	
}