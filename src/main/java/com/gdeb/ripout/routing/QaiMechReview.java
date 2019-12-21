package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaiMechReview extends Routing {

	public QaiMechReview() {
		super(100, STATUS_NPUB, ROUTING_QAI_MECH_REVIEW, "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_QAI_STRU_REVIEW;
	}
}
