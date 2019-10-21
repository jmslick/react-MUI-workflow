package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class ShipsManagementApproval extends Routing {

	public ShipsManagementApproval() {
		super(30, STATUS_NPUB, "ShipsManagementApproval", "EBROShipManager");
	}

	public String calculate() {
		return ROUTING_TEST_DEPT_TEST_CONTROLS;
	}
}
