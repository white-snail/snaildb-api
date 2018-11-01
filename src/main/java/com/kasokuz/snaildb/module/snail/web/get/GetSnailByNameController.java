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
import com.kasokuz.snaildb.module.snail.web.get.response.*;;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getsnailbyname", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetSnailByNameController {
	
	@Autowired
	private SnailService service;
	
	@GetMapping(value = "{superfamily}")
	public Result<GetSuperfamilyResponse> getSuperfamily(@PathVariable String superfamily) {
		return new Result<>(GetSuperfamilyResponse.from(service.getSuperfamily(superfamily)));
	}
	
	@GetMapping(value = "{superfamily}/{family}")
	public Result<GetFamilyResponse> getFamily(@PathVariable String superfamily, @PathVariable String family) {
		return new Result<>(GetFamilyResponse.from(service.getFamily(family, superfamily)));
	}
	
	@GetMapping(value = "{superfamily}/{family}/{genus}")
	public Result<GetGenusResponse> getGenus(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus) {
		return new Result<>(GetGenusResponse.from(service.getGenus(genus, superfamily, family)));
	}
	
	@GetMapping(value = "{superfamily}/{family}/{genus}/{species}")
	public Result<GetSpeciesResponse> getSpecies(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus, @PathVariable String species) {
		return new Result<>(GetSpeciesResponse.from(service.getSpecies(species, superfamily, family, genus)));
	}
	
	@GetMapping(value = "{superfamily}/{family}/{genus}/{species}/{subspecies}")
	public Result<GetSubspeciesResponse> getSubspecies(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus, @PathVariable String species, @PathVariable String subspecies) {
		return new Result<>(GetSubspeciesResponse.from(service.getSubspecies(subspecies, superfamily, family, genus, species)));
	}
	
}
