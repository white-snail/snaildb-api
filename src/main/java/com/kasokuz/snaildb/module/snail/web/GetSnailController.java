package com.kasokuz.snaildb.module.snail.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

@RestController
@RequestMapping("snail/get")
public class GetSnailController {
	
	@Autowired
	private SnailService service;
	
	@RequestMapping(value = "{superfamily}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Superfamily> getSuperfamily(@PathVariable String superfamily) {
		return new Result<>(service.getSuperfamily(superfamily));
	}
	
	@RequestMapping(value = "{superfamily}/{family}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Family> getFamily(@PathVariable String superfamily, @PathVariable String family) {
		return new Result<>(service.getFamily(family, superfamily));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Genus> getGenus(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus) {
		return new Result<>(service.getGenus(genus, superfamily, family));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}/{species}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Species> getSpecies(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus, @PathVariable String species) {
		return new Result<>(service.getSpecies(species, superfamily, family, genus));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}/{species}/{subspecies}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Subspecies> getSubspecies(@PathVariable String superfamily, @PathVariable String family, @PathVariable String genus, @PathVariable String species, @PathVariable String subspecies) {
		return new Result<>(service.getSubspecies(subspecies, superfamily, family, genus, species));
	}
	
	public static class Result<T> {
		
		private T result;
		
		public Result(T result) {
			this.result = result;
		}
		
		public T getResult() {
			return result;
		}
		
	}
	
}
