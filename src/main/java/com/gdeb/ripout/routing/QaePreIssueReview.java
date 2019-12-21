package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QaePreIssueReview extends Routing {

	public QaePreIssueReview() {
		super(100, STATUS_STEC, ROUTING_QAE_PRE_ISSUE_REVIEW, "EBROQAI");
	}

	public String calculate() {
		return Routing.ROUTING_TEST_DEPT_TEST_CONTROLS;
	}
}
