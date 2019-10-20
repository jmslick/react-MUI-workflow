package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class PlanningBlueTags extends Routing {

	public PlanningBlueTags() {
		super(9, STATUS_DRFT, "PlanningBlueTags", "EBROPlanning");
	}

	public String calculate() {
		return ROUTING_RIPOUT_UNDEFINED;
	}
}
