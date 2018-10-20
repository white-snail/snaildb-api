package com.kasokuz.snaildb.module.snail.web.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.Result;
import com.kasokuz.snaildb.module.snail.web.get.response.*;;

@RestController
@RequestMapping("snail/getbyid")
public class GetByIdSnailController {

	@Autowired
	private SnailService service;
	
	@RequestMapping(value = "superfamily/{superfamilyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<GetSuperfamilyResponse> getSuperfamily(@PathVariable Integer superfamilyId) {
		return new Result<>(GetSuperfamilyResponse.from(service.getSuperfamily(superfamilyId)));
	}
	
	@RequestMapping(value = "family/{familyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<GetFamilyResponse> getFamily(@PathVariable Integer familyId) {
		return new Result<>(GetFamilyResponse.from(service.getFamily(familyId)));
	}
	
	@RequestMapping(value = "genus/{genusId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<GetGenusResponse> getGenus(@PathVariable Integer genusId) {
		return new Result<>(GetGenusResponse.from(service.getGenus(genusId)));
	}
	
	@RequestMapping(value = "species/{speciesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<GetSpeciesResponse> getSpecies(@PathVariable Integer speciesId) {
		return new Result<>(GetSpeciesResponse.from(service.getSpecies(speciesId)));
	}
	
	@RequestMapping(value = "subspecies/{subspeciesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<GetSubspeciesResponse> getSubspecies(@PathVariable Integer subspeciesId) {
		return new Result<>(GetSubspeciesResponse.from(service.getSubspecies(subspeciesId)));
	}
	
}
