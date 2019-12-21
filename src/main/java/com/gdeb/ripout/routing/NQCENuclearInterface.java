package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class NQCENuclearInterface extends Routing {

	public NQCENuclearInterface() {
		super(40, STATUS_NPUB, "NQCENuclearInterface", "EBRONuclearQualityControl");
	}

	public String calculate() {
		Double d = Math.random();
		if (d > 0.5)
			return ROUTING_QAI_PIPING_REVIEW;
		else
			return ROUTING_ENGINEERING_INITIAL_REVIEW;
	}

}
