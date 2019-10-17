package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingShipMgrApproval extends Routing {

	public RoutingShipMgrApproval() {
		super(30, "SHIP MGR APPROVAL", "EBROShipManager");
	}

	public Routing calculate() {
		return new RoutingQAEReview();
	}
}
