package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class SafetyTechElectronics extends Routing {

	public SafetyTechElectronics() {
		super(30, STATUS_NPUB, ROUTING_SAFETY_TECH_ELTX, ROLE_SAFETY_TECH_ELTX);
	}

	public String calculate() {
		if (ripout.getStatus().equals(STATUS_WORK)) {
			ripout.setStatus(STATUS_WORK);
		}
		return null;
	}
}
