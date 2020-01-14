package main.java.com.gdeb.ripout.routing;

import main.java.com.gdeb.ripout.model.Ripout;

/**
 * @author jslick
 *
 */
public class StopWorkLeadTrade extends Routing {

	public StopWorkLeadTrade() {
		super(100, Routing.STATUS_WORK, ROUTING_STOP_WORK_LEAD_TRADE, ROLE_LEAD_TRADE);
	}

	public String calculate() {
		ripout.setStatus(STATUS_STOP);
		ripoutRepository.save(ripout);
		Ripout temp = ripoutRepository.findByXref(ripout.getXref());
		System.out.println(ripout.toString());
		return null;
		// return ripout.getStatus().equals(STATUS_STOP) ?
		// ROUTING_TEST_DEPT_TEST_CONTROLS;
	}
}
