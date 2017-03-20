package com.test.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.core.ObjectMapperSingleTon;
import com.test.core.TestObject;

@Path("json/api")
public class TestApi {
	@GET
	@Path("/get/object")
	@Produces(MediaType.APPLICATION_JSON)
	public String convertCtoF() throws JsonProcessingException {
		ObjectMapper mapper = ObjectMapperSingleTon.getInstance();
		List<TestObject> list = new ArrayList<TestObject>();
		TestObject test = new TestObject();
		TestObject test1 = new TestObject();
		test.setKey("1");
		test.setValue("anurag");
		list.add(test);
		test1.setKey("2");
		test1.setValue("bhavik");
		list.add(test1);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

	}

	@POST
	@Path("/post/object")
	@Produces("application/json")
	public String convertC() throws JsonProcessingException {
		ObjectMapper mapper = ObjectMapperSingleTon.getInstance();
		List<TestObject> list = new ArrayList<TestObject>();
		TestObject test = new TestObject();
		TestObject test1 = new TestObject();
		test.setKey("1");
		test.setValue("anurag");
		list.add(test);
		test1.setKey("2");
		test1.setValue("bhavik");
		list.add(test1);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
	}

	@GET
	@Path("/get/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String convertCtol() {
		return "test";

	}

}