package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public class RoutingQAEReview extends Routing {

	public RoutingQAEReview() {
		super(30, "QAE REVIEW", "EBROQAE");
	}

	public Routing calculate() {
		if (Math.random() > 0.5) {
			System.out.println("QAE Review: IS nuclear interface");
			return new RoutingNQCENuclear();
		}
		System.out.println("QAE Review: NOT nuclear interface");

		// is rec seq no required?
		if (Math.random() > 0.5) {
			System.out.println("QAE Review: rec_seq_no IS required");
			return new RoutingEngineeringInitalReview();
		} else {
			System.out.println("QAE Review: rec_seq_no NOT required");
			// is qai required?
			if (Math.random() > 0.5) {
				System.out.println("QAI IS required");
				// route to qai piping for now...
				return new RoutingQAIPiping();
			} else {
				System.out.println("QAI NOT required");
				System.out.println("Status = STEC");
				return new RoutingTestDeptTestControls();
			}
		}
	}
}
