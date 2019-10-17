package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingNQCENuclear extends Routing {

	public RoutingNQCENuclear() {
		super(40, "NQCE", "EBRONuclearQualityControl");
	}

	public Routing calculate() {
		Double d = Math.random();
		System.out.println(d);
		if (d > 0.5)
			return new RoutingOriginator();
		else
			return new RoutingEngineeringInitalReview();
	}
}
