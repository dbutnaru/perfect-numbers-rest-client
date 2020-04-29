package com.extendaretail.miscotask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class RestApiTest extends JerseyTest {

	@Override
	public Application configure() {
		return new ResourceConfig(PerfectNumbersRestService.class);
	}

	@Test
	public void testIsRunning() {
		Response response = target("/test").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		String responseValue = response.readEntity(String.class);
		assertTrue(responseValue.contains("is running"));
	}
	
	@Test
	public void testIsPerfect() {
		Response response = target("/isPerfect/6").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		Boolean responseValue = response.readEntity(Boolean.class);
		assertTrue(responseValue);
	}
	
	@Test
	public void testIsNotPerfect() {
		Response response = target("/isPerfect/8").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		Boolean responseValue = response.readEntity(Boolean.class);
		assertFalse(responseValue);
	}
	
	@Test
	public void testRangeHasPerfectNumbers() {
		Response response = target("/perfectNumbersFromRange/1/10000").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		List responseValue = response.readEntity(List.class);
		assertEquals(4, responseValue.size());
		assertEquals(6, responseValue.get(0));
	}
}
