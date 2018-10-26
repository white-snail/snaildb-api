package com.kasokuz.snaildb.module.snail.web.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.get.response.GetTotalResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("getinfo")
public class GetInfoController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "total", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GetTotalResponse getTotal() {
		return new GetTotalResponse(service.countSubspecies());
	}
	
}
