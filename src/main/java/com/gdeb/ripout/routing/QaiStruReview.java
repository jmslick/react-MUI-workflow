package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaiStruReview extends Routing {

	public QaiStruReview() {
		super(100, STATUS_NPUB, ROUTING_QAI_STRU_REVIEW, "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_QAI_ELEC_REVIEW;
	}
}
