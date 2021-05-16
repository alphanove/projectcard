package com.example.springbootderby;

import com.example.springbootderby.controller.CardController;
import com.example.springbootderby.model.Card;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.JsonExpectationsHelper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDerbyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootDerbyApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void addValidCard() {
		Card cardDetails = new Card("1556954993914435", "Kamal", 1000, 00.00);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/cardapi/v1", cardDetails, String.class);
		String obj1 = String.valueOf(postResponse.getBody());
		assertEquals("Adding a Valid card Detail - Result :", "{\"apiStatusCode\":\"200\",\"apiStatusMessage\":\"Card Added Successfully\"}", obj1);
	}

	@Test
	public void addInvalidCard() {
		Card cardDetails = new Card("1556954993914436", "Kamal", 1000, 00.00);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/cardapi/v1", cardDetails, String.class);
		String obj1 = String.valueOf(postResponse.getStatusCode());
		assertEquals("Adding a InValid card Detail - Result :", "400 BAD_REQUEST", obj1);
	}

	@Test
	public void invalidApiContextPath() {
		Card cardDetails = new Card("1556954993914436", "Kamal", 1000, 00.00);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/addCard", cardDetails, String.class);
		String obj1 = String.valueOf(postResponse.getStatusCode());
		assertEquals("InValid Url Detail - Result :", "404 NOT_FOUND", obj1);

	}
}
