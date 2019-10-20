package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QAESpecialEmphasisReview extends Routing {

	public QAESpecialEmphasisReview() {
		super(50, STATUS_NPUB, "QAESpecialEmphasisReview", "EBROQAE");
	}

	public String calculate() {
		if (Math.random() > 0.5) {
			System.out.println("\tQAE Review: IS nuclear interface");
			return ROUTING_NQCE_NUCLEAR_INTERFACE;
		}
		System.out.println("\tQAE Review: NOT nuclear interface");

		// is rec seq no required?
		if (Math.random() > 0.5) {
			System.out.println("\tQAE Review: rec_seq_no IS required");
			return ROUTING_ENGINEERING_INITIAL_REVIEW;
		} else {
			System.out.println("\tQAE Review: rec_seq_no NOT required");
			// is qai required?
			if (Math.random() > 0.5) {
				System.out.println("\tQAI IS required");
				// route to qai piping for now...
				return ROUTING_QAI_PIPING;
			} else {
				System.out.println("\tQAI NOT required");
				System.out.println("\tStatus = STEC");
				return ROUTING_TEST_DEPT_TEST_CONTROLS;
			}
		}
	}
}
