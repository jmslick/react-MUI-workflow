package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QAIPipingReview extends Routing {

	public QAIPipingReview() {
		super(100, STATUS_NPUB, "QAIPipingReview", "EBROQAI");
	}

	public String calculate() {
		System.out.println("QAIPipingReview next routing: " + ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW);
		return ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW;
	}
}
