package com.kasokuz.snaildb.controller.get;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.get.response.GetAllFamiliesResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllGeneraResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllSpeciesResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllSubfamiliesResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllSubgeneraResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllSubspeciesResponse;
import com.kasokuz.snaildb.controller.get.response.GetAllSuperfamiliesResponse;
import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subfamily;
import com.kasokuz.snaildb.domain.Subgenus;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.service.SnailService;

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
	
	@GetMapping(value = "subfamilies")
	public List<GetAllSubfamiliesResponse> getSubfamilies() {
		List<GetAllSubfamiliesResponse> response = new ArrayList<>();
		for(Subfamily subfamily : service.getSubfamilies()) {
			response.add(new GetAllSubfamiliesResponse(subfamily));
		}
		return response;
	}
	
	@GetMapping(value = "genera")
	public List<GetAllGeneraResponse> getGenera() {
		List<GetAllGeneraResponse> response = new ArrayList<>();
		for(Genus genus : service.getGenera()) {
			response.add(new GetAllGeneraResponse(genus));
		}
		return response;
	}
	
	@GetMapping(value = "subgenera")
	public List<GetAllSubgeneraResponse> getSubgenera() {
		List<GetAllSubgeneraResponse> response = new ArrayList<>();
		for(Subgenus subgenus : service.getSubgenera()) {
			response.add(new GetAllSubgeneraResponse(subgenus));
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
