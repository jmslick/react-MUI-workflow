package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaiElecReview extends Routing {

	public QaiElecReview() {
		super(100, STATUS_NPUB, ROUTING_QAI_ELEC_REVIEW, "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_QAI_SUPERVISOR_REVIEW;
	}
}
