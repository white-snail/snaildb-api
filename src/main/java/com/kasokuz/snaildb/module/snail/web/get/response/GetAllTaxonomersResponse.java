package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Taxonomer;

public class GetAllTaxonomersResponse {
	
	public final Integer id;
	
	public final String name, surname;
	
	public GetAllTaxonomersResponse(Taxonomer taxonomer) {
		this.id = taxonomer.getTaxonomerId();
		this.name = taxonomer.getName();
		this.surname = taxonomer.getSurname();
	}

}
