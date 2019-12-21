package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaiSupervisorReview extends Routing {

	public QaiSupervisorReview() {
		super(100, STATUS_NPUB, ROUTING_QAI_SUPERVISOR_REVIEW, "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_QAE_PRE_ISSUE_REVIEW;
	}
}
