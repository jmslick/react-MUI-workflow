package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingOriginator extends Routing {

	public RoutingOriginator() {
		super(0, "ORIGINATOR", "EBROOriginator");
	}

	public Routing calculate() {
		return new RoutingWriter();
	}
}
