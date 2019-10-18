package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingShipMgrApproval extends Routing {

	public RoutingShipMgrApproval() {
		super(30, "SHIP MGR APPROVAL", "EBROShipManager");
	}

	public Routing calculateRouting() {
		return new RoutingQAEReview();
	}

	public String calculate() {
		return Workflow.QAE_REVIEW;
	}
}
