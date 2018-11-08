package com.kasokuz.snaildb.controller.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.search.response.SearchResponse;
import com.kasokuz.snaildb.controller.search.response.SearchResponse.Child;
import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.service.SnailService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("searchsnail")
public class SearchSnailController {
	
	@Autowired
	private SnailService service;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SearchResponse search(@RequestParam(value = "query", required = true) String query, @RequestParam(value = "filter", required = false) String filter) {
		SearchResponse response = new SearchResponse();
		List<String> filters = filter == null ? new ArrayList<>() : Arrays.asList(filter.split(","));
		if(filters.size() == 0 || filter.contains("superfamily")) {
			for(Superfamily superfamily : service.searchSuperfamilies(query)) response.superfamilies.add(new Child(superfamily));
		}
		if(filters.size() == 0 || filter.contains("family")) {
			for(Family family : service.searchFamilies(query)) response.families.add(new Child(family));
		}
		if(filters.size() == 0 || filter.contains("genus")) {
			for(Genus genus : service.searchGenuses(query)) response.genuses.add(new Child(genus));
		}
		if(filters.size() == 0 || filter.contains("species")) {
			for(Species species : service.searchSpecies(query)) response.species.add(new Child(species));
		}
		if(filters.size() == 0 || filter.contains("subspecies")) {
			for(Subspecies subspecies : service.searchSubspecies(query)) response.subspecies.add(new Child(subspecies));
		}
		return response;
	}

}
