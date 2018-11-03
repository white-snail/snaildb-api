package com.kasokuz.snaildb.module.snail.utils;

public class Result<T> {
	
	private T result;
	
	public Result(T result) {
		this.result = result;
	}
	
	public T getResult() {
		return result;
	}
	
}
