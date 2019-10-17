package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingWriter extends Routing {

	public RoutingWriter() {
		super(10, "WRITER", "EBRORipoutWriter");
	}

	public Routing calculate() {
		return new RoutingLeadTrade();
	}
}
