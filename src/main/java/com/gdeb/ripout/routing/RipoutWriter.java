package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class RipoutWriter extends Routing {

	public RipoutWriter() {
		super(10, STATUS_DRFT, "RipoutWriter", "EBRORipoutWriter");
	}

	public String calculate() {
		return ROUTING_LEAD_TRADE;
	}
}
