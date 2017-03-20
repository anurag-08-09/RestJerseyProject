package com.test.core;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleTon {

	private static ObjectMapper mapper = new ObjectMapper();

	private ObjectMapperSingleTon() {

	}

	public static ObjectMapper getInstance() {
		return mapper;
	}

}
