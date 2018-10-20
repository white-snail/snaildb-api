package com.kasokuz.snaildb.module.snail.web.get.response;

public class GetSubspeciesResponse extends CommonResponse {
	
	public final Integer minHeight, maxHeight, minWidth, maxWidth;
	
	public GetSubspeciesResponse(com.kasokuz.snaildb.module.snail.entity.Subspecies subspecies) {
		super(subspecies.getSubspeciesId(), subspecies.getName(), subspecies.getTaxonomer(), subspecies.getTaxonomyYear());
		minHeight = subspecies.getMinHeight();
		maxHeight = subspecies.getMaxHeight();
		minWidth = subspecies.getMinWidth();
		maxWidth = subspecies.getMaxWidth();
	}
	
	public static GetSubspeciesResponse from(com.kasokuz.snaildb.module.snail.entity.Subspecies subspecies) {
		if(subspecies == null) return null;
		else return new GetSubspeciesResponse(subspecies);
	}

}
