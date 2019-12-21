package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class ShipsManagementApproval extends Routing {

	public ShipsManagementApproval() {
		super(30, STATUS_NPUB, ROUTING_SHIP_MGMT_APPROVAL, "EBROShipManager");
	}

	public String calculate() {
		return Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW;
	}
}
