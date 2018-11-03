package com.kasokuz.snaildb.module.snail.web.get;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.domain.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllFamiliesResponse;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllGenusesResponse;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllSpeciesResponse;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllSubspeciesResponse;
import com.kasokuz.snaildb.module.snail.web.get.response.GetAllSuperfamiliesResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getallsnails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetAllSnailsController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "superfamilies")
	public List<GetAllSuperfamiliesResponse> getSuperfamilies() {
		List<GetAllSuperfamiliesResponse> response = new ArrayList<>();
		for(Superfamily superfamily : service.getSuperfamilies()) {
			response.add(new GetAllSuperfamiliesResponse(superfamily));
		}
		return response;
	}
	
	@GetMapping(value = "families")
	public List<GetAllFamiliesResponse> getFamilies() {
		List<GetAllFamiliesResponse> response = new ArrayList<>();
		for(Family family : service.getFamilies()) {
			response.add(new GetAllFamiliesResponse(family));
		}
		return response;
	}
	
	@GetMapping(value = "genuses")
	public List<GetAllGenusesResponse> getGenuses() {
		List<GetAllGenusesResponse> response = new ArrayList<>();
		for(Genus genus : service.getGenuses()) {
			response.add(new GetAllGenusesResponse(genus));
		}
		return response;
	}
	
	@GetMapping(value = "species")
	public List<GetAllSpeciesResponse> getSpecies() {
		List<GetAllSpeciesResponse> response = new ArrayList<>();
		for(Species species : service.getSpecies()) {
			response.add(new GetAllSpeciesResponse(species));
		}
		return response;
	}
	
	@GetMapping(value = "subspecies")
	public List<GetAllSubspeciesResponse> getSubspecies() {
		List<GetAllSubspeciesResponse> response = new ArrayList<>();
		for(Subspecies subspecies : service.getSubspecies()) {
			response.add(new GetAllSubspeciesResponse(subspecies));
		}
		return response;
	}
	
}
