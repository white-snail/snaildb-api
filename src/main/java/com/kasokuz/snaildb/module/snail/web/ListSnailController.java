package com.kasokuz.snaildb.module.snail.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.utils.NameMapper;

@Controller
@RequestMapping("snail/list")
public class ListSnailController {
	
	@Autowired
	private SnailService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listSuperfamily() {
		return new NameMapper<Superfamily>().map(service.getSuperfamilies());
	}
	
	@RequestMapping(value = "{superfamily}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listFamilies(@PathVariable("superfamily") String superfamily) {
		return new NameMapper<Family>().map(service.getSuperfamily(superfamily).getFamilies());
	}
	
	@RequestMapping(value = "{superfamily}/{family}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listGenuses(@PathVariable("superfamily") String superfamily, @PathVariable("family") String family) {
		return new NameMapper<Genus>().map(service.getFamily(family, superfamily).getGenuses());
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listSpecies(@PathVariable("superfamily") String superfamily, @PathVariable("family") String family, @PathVariable("genus") String genus) {
		return new NameMapper<Species>().map(service.getGenus(genus, superfamily, family).getSpecies());
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}/{species}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listSubspecies(@PathVariable("superfamily") String superfamily, @PathVariable("family") String family, @PathVariable("genus") String genus, @PathVariable("species") String species) {
		return new NameMapper<Subspecies>().map(service.getSpecies(species, superfamily, family, genus).getSubspecies());
	}

}
