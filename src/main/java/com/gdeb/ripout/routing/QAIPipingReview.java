package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaiPipingReview extends Routing {

	public QaiPipingReview() {
		super(100, STATUS_NPUB, "QAIPipingReview", "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_QAI_MECH_REVIEW;
	}
}
