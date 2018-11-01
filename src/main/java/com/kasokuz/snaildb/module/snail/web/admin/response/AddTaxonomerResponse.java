package com.kasokuz.snaildb.module.snail.web.admin.response;

import com.kasokuz.snaildb.module.snail.dto.Taxonomer;

public class AddTaxonomerResponse {
	
	public final Integer taxonomerId;
	
	public final String name, surname;
	
	public AddTaxonomerResponse(Taxonomer taxonomer) {
		this.taxonomerId = taxonomer.getTaxonomerId();
		this.name = taxonomer.getName();
		this.surname = taxonomer.getSurname();
	}

}
