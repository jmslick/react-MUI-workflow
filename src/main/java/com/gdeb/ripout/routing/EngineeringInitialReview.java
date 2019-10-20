package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class EngineeringInitialReview extends Routing {

	public EngineeringInitialReview() {
		super(60, STATUS_NPUB, "EngineeringInitialReview", "EBROEnhancedROEngineer");
	}

	public String calculate() {
		return ROUTING_TEST_DEPT_TEST_CONTROLS;
	}
}
