package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingQAEReview extends Routing {

	public RoutingQAEReview() {
		super(30, "QAE REVIEW", "EBROQAE");
	}

	public Routing calculateRouting() {
		if (Math.random() > 0.5) {
			System.out.println("QAE Review: IS nuclear interface");
			return new RoutingNQCENuclear();
		}
		System.out.println("QAE Review: NOT nuclear interface");

		// is rec seq no required?
		if (Math.random() > 0.5) {
			System.out.println("QAE Review: rec_seq_no IS required");
			return new RoutingEngineeringInitialReview();
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

	public String calculate() {
		if (Math.random() > 0.5) {
			System.out.println("\tQAE Review: IS nuclear interface");
			return Workflow.NQCE_Nuclear;
		}
		System.out.println("\tQAE Review: NOT nuclear interface");

		// is rec seq no required?
		if (Math.random() > 0.5) {
			System.out.println("\tQAE Review: rec_seq_no IS required");
			return Workflow.ENGINEERING_INITIAL_REVIEW;
		} else {
			System.out.println("\tQAE Review: rec_seq_no NOT required");
			// is qai required?
			if (Math.random() > 0.5) {
				System.out.println("\tQAI IS required");
				// route to qai piping for now...
				return Workflow.QAI_PIPING;
			} else {
				System.out.println("\tQAI NOT required");
				System.out.println("\tStatus = STEC");
				return Workflow.TEST_DEPT_TEST_CONTROLS;
			}
		}
	}
}
