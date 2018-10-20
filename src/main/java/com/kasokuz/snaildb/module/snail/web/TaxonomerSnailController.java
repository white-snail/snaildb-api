package com.kasokuz.snaildb.module.snail.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("snail/taxonomer")
public class TaxonomerSnailController {
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getTaxonomers() {
		
	}

	@RequestMapping(value = "{taxonomer}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getTaxonomer(@PathVariable String taxonomer) {
		
	}

	@RequestMapping(value = "{taxonomer}/{year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getTaxonomerYear(@PathVariable String taxonomer) {
		
	}
	
}
