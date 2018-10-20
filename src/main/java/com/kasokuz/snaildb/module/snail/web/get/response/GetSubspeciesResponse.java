package com.kasokuz.snaildb.module.snail.web.get.response;

public class GetSubspeciesResponse extends CommonResponse {
	
	public Integer minHeight, maxHeight, minWidth, maxWidth;
	
	public GetSubspeciesResponse(com.kasokuz.snaildb.module.snail.entity.Subspecies subspecies) {
		id = subspecies.getSubspeciesId();
		name = subspecies.getName();
		taxonomer = new Taxonomer(subspecies.getTaxonomer());
		taxonomyYear = subspecies.getTaxonomyYear();
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
