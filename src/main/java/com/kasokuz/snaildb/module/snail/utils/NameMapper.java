package com.kasokuz.snaildb.module.snail.utils;

import java.util.ArrayList;
import java.util.List;

public class NameMapper<T extends NameMapper.Mappable> {
	
	public List<String> map(Iterable<T> list) {
		List<String> ret = new ArrayList<>();
		for(T t : list) {
			ret.add(t.getName());
		}
		return ret;
	}
	
	public static interface Mappable {
		
		public String getName();
		
	}

}
