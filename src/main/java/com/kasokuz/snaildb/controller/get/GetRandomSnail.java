package com.kasokuz.snaildb.controller.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.get.response.GetRandomSpeciesResponse;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getrandomsnail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetRandomSnail {
	
	@Autowired
	private SnailService service;
	
	@GetMapping
	public GetRandomSpeciesResponse getRandom() {
		return new GetRandomSpeciesResponse(this.service.getRandomSpecies());
	}

}
