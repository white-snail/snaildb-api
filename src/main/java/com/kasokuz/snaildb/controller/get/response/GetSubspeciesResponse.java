package com.kasokuz.snaildb.controller.get.response;

public class GetSubspeciesResponse extends CommonResponse {
	
	public final Integer speciesId;
	
	public final Integer minHeight, maxHeight, minWidth, maxWidth;
	
	public final Integer lifespan;
	
	public final String location;
	
	public GetSubspeciesResponse(com.kasokuz.snaildb.domain.Subspecies subspecies) {
		super(subspecies.getSubspeciesId(), subspecies.getName(), subspecies.getTaxonomers(), subspecies.getTaxonomyYear());
		this.speciesId = subspecies.getSpecies().getSpeciesId();
		this.minHeight = subspecies.getMinHeight();
		this.maxHeight = subspecies.getMaxHeight();
		this.minWidth = subspecies.getMinWidth();
		this.maxWidth = subspecies.getMaxWidth();
		this.lifespan = subspecies.getLifespan();
		this.location = subspecies.getLocation();
	}
	
	public static GetSubspeciesResponse from(com.kasokuz.snaildb.domain.Subspecies subspecies) {
		if(subspecies == null) return null;
		else return new GetSubspeciesResponse(subspecies);
	}

}
