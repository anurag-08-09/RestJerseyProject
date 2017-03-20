package com.test.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.test.core.ObjectMapperSingleTon;
import com.test.core.TestObject;

public class TestPostClient {

	public static void main(String[] args) {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(
					"http://localhost:8080/CrunchifyRESTJerseyExample/test/json/api/post/object");

			StringEntity input = new StringEntity("");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			String json = EntityUtils.toString(response.getEntity());

			System.out.println(json);

			ObjectMapper mapper = ObjectMapperSingleTon.getInstance();
			List<TestObject> list = mapper.readValue(json,
					TypeFactory.defaultInstance().constructCollectionType(List.class, TestObject.class));
			System.out.println(list);
			/*
			 * BufferedReader br = new BufferedReader(new
			 * InputStreamReader((response.getEntity().getContent())));
			 * 
			 * String output; System.out.println("Output from Server .... \n");
			 * while ((output = br.readLine()) != null) {
			 * System.out.println(output); }
			 */
			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
