package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingRipoutWriter extends Routing {

	public RoutingRipoutWriter() {
		super(10, "WRITER", "EBRORipoutWriter");
	}

	public String calculate() {
		return Workflow.LEAD_TRADE;
	}
}
