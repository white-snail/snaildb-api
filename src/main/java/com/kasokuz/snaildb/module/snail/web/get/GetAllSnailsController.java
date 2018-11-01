package com.kasokuz.snaildb.module.snail.web.get;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.dto.Superfamily;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.get.response.GetSuperfamilyResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getallsnails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetAllSnailsController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "")
	public List<GetSuperfamilyResponse> getAll() {
		List<GetSuperfamilyResponse> response = new ArrayList<>();
		for(Superfamily superfamily : service.getSuperfamilies()) {
			response.add(new GetSuperfamilyResponse(superfamily));
		}
		return response;
	}
	
}
