package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class LeadTrade extends Routing {

	public LeadTrade() {
		super(20, STATUS_DRFT, "LeadTrade", "EBROLeadTrade");
	}

	public String calculate() {
		return ROUTING_SHIP_MGMT_APPROVAL;
	}

}
