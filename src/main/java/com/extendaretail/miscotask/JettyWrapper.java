package com.extendaretail.miscotask;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyWrapper {
	private int port = 8080;
	private String contextPath = "/";

	private final Server server;
	
	public JettyWrapper() {
		server = configureJetty();
	}
	
	public JettyWrapper(int port, String contextPath) {
		this.port = port;
		this.contextPath = contextPath;
		server = configureJetty();
	}
	
	public void run() {
		if (!server.isStarted()) {
			jettyStart();
		} else {
			
		}
	}

	private void jettyStart() {
		try {
		    server.start();
		    server.join();
		} catch (Exception ex) {
		    System.out.println("Error occurred while starting Jetty");
		    System.out.println(ex.getMessage());
		    System.exit(1);
		}

		finally {
		    server.destroy();
		}
	}

	public void jettyStop() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Server configureJetty() {
		Server server = new Server(port);
    	ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);
		servletContextHandler.setContextPath(contextPath);
        server.setHandler(servletContextHandler);
        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, contextPath + "*");
        servletHolder.setInitOrder(0);
//        servletHolder.setInitParameter(
//                "jersey.config.server.provider.classnames",
//                PerfectNumbersRestService.class.getCanonicalName());
        servletHolder.setInitParameter(ServerProperties.PROVIDER_PACKAGES,
                "com.fasterxml.jackson.jaxrs.json;"
              + "com.extendaretail.miscotask"
        );
		return server;
	}
}
