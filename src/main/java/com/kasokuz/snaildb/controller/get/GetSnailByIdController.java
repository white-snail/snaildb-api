package com.kasokuz.snaildb.controller.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.get.response.GetFamilyResponse;
import com.kasokuz.snaildb.controller.get.response.GetGenusResponse;
import com.kasokuz.snaildb.controller.get.response.GetSpeciesResponse;
import com.kasokuz.snaildb.controller.get.response.GetSubspeciesResponse;
import com.kasokuz.snaildb.controller.get.response.GetSuperfamilyResponse;
import com.kasokuz.snaildb.service.SnailService;
import com.kasokuz.snaildb.utils.Result;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getsnailbyid", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetSnailByIdController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "superfamily/{superfamilyId}")
	public Result<GetSuperfamilyResponse> getSuperfamily(@PathVariable Integer superfamilyId) {
		return new Result<>(GetSuperfamilyResponse.from(service.getSuperfamily(superfamilyId)));
	}
	
	@GetMapping(value = "family/{familyId}")
	public Result<GetFamilyResponse> getFamily(@PathVariable Integer familyId) {
		return new Result<>(GetFamilyResponse.from(service.getFamily(familyId)));
	}
	
	@GetMapping(value = "genus/{genusId}")
	public Result<GetGenusResponse> getGenus(@PathVariable Integer genusId) {
		return new Result<>(GetGenusResponse.from(service.getGenus(genusId)));
	}
	
	@GetMapping(value = "species/{speciesId}")
	public Result<GetSpeciesResponse> getSpecies(@PathVariable Integer speciesId) {
		return new Result<>(GetSpeciesResponse.from(service.getSpecies(speciesId)));
	}
	
	@GetMapping(value = "subspecies/{subspeciesId}")
	public Result<GetSubspeciesResponse> getSubspecies(@PathVariable Integer subspeciesId) {
		return new Result<>(GetSubspeciesResponse.from(service.getSubspecies(subspeciesId)));
	}
	
}
