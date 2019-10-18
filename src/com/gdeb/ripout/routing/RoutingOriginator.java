package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingOriginator extends Routing {

	public RoutingOriginator() {
		super(0, "ORIGINATOR", "EBROOriginator");
	}

	public Routing _calculate() {
		return new RoutingRipoutWriter();
	}

	public String calculate() {
		return Workflow.RIPOUT_WRITER;
	}
}
