package com.kasokuz.snaildb.module.snail.web.get;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.snail.entity.Superfamily;
import com.kasokuz.snaildb.module.snail.service.SnailService;
import com.kasokuz.snaildb.module.snail.web.get.response.GetSuperfamilyResponse;

@RestController
@RequestMapping("snail/getall")
public class GetAllSnailController {

	@Autowired
	private SnailService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GetSuperfamilyResponse> getAll() {
		List<GetSuperfamilyResponse> response = new ArrayList<>();
		for(Superfamily superfamily : service.getSuperfamilies()) {
			response.add(new GetSuperfamilyResponse(superfamily));
		}
		return response;
	}
	
}
