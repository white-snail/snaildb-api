package com.kasokuz.snaildb.controller.get.response;

public class GetSubspeciesResponse extends CommonResponse {
	
	public final Integer minHeight, maxHeight, minWidth, maxWidth;
	
	public final Boolean extinct, viviparous;
	
	public final String location;
	
	public GetSubspeciesResponse(com.kasokuz.snaildb.domain.Subspecies subspecies) {
		super(subspecies.getSubspeciesId(), subspecies.getName(), subspecies.getTaxonomers(), subspecies.getTaxonomyYear());
		minHeight = subspecies.getMinHeight();
		maxHeight = subspecies.getMaxHeight();
		minWidth = subspecies.getMinWidth();
		maxWidth = subspecies.getMaxWidth();
		extinct = subspecies.getExtinct();
		viviparous = subspecies.getViviparous();
		location = subspecies.getLocation();
	}
	
	public static GetSubspeciesResponse from(com.kasokuz.snaildb.domain.Subspecies subspecies) {
		if(subspecies == null) return null;
		else return new GetSubspeciesResponse(subspecies);
	}

}
