package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingLeadTrade extends Routing {

	public RoutingLeadTrade() {
		super(20, "LEADTRADE", "EBROLeadTrade");
	}

	public String calculate() {
		return Workflow.SHIP_MGR_APPROVAL;
	}

}
