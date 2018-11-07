package com.kasokuz.snaildb.module.snail.web.get.response;

public class GetTotalResponse {
	
	public final Long taxonomers, superfamilies, families, genuses, species, subspecies;
	
	public GetTotalResponse(Long taxonomers, Long superfamilies, Long families, Long genuses, Long species, Long subspecies) {
		this.taxonomers = taxonomers;
		this.superfamilies = superfamilies;
		this.families = families;
		this.genuses = genuses;
		this.species = species;
		this.subspecies = subspecies;
	}

}
