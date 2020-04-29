package com.extendaretail.miscotask;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		packages("com.extendaretail.miscotask.perfectnumber");
	}
}
