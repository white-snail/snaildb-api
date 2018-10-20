package com.kasokuz.snaildb.module.snail.web.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.search.response.SearchResponse;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/searchsnail")
public class SearchSnailController {
	
	@Autowired
	private SnailService service;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SearchResponse search(@RequestParam(value = "query", required = true) String query) {
		return new SearchResponse(service.searchSuperfamilies(query), service.searchFamilies(query), service.searchGenuses(query), service.searchSpecies(query), service.searchSubspecies(query));
	}

}
