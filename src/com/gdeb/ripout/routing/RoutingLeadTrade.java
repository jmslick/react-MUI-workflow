package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingLeadTrade extends Routing {

	public RoutingLeadTrade() {
		super(20, "LEADTRADE", "EBROLeadTrade");
	}

	public Routing calculate() {
		return new RoutingShipMgrApproval();
	}
}
