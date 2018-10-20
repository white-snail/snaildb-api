package com.kasokuz.snaildb.module.snail.web.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("snail/search")
public class SearchSnailController {
	
	@GetMapping
	public void search(@RequestParam(value = "query", required = true) String query) {
		
	}

}
