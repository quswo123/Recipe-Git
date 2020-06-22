package com.recipe.exception;

public class DuplicatedException extends AddException {
	public DuplicatedException() {
		super();
	}
	public DuplicatedException(String message) {
		super(message);
	}
}
