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

	public Routing calculateRouting() {
		return new RoutingShipMgrApproval();
	}

	public String calculate() {
		return Workflow.SHIP_MGR_APPROVAL;
	}

}
