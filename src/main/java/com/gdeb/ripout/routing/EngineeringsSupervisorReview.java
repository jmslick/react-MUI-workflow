package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class EngineeringsSupervisorReview extends Routing {

	public EngineeringsSupervisorReview() {
		super(60, STATUS_NPUB, "EngineeringsSupervisorReview", "EBROEnhancedROEngineerSupervisor");
	}

	public String calculate() {
		return ROUTING_QAI_MECH_REVIEW;
	}
}
