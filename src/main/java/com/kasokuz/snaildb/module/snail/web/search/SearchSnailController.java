package com.kasokuz.snaildb.module.snail.web.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kasokuz.snaildb.module.snail.service.SnailService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/searchsnail")
public class SearchSnailController {
	
	@Autowired
	private SnailService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void search(@RequestParam(value = "query", required = true) String query) {
		
	}

}
