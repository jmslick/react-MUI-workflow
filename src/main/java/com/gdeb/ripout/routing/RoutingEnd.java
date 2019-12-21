package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class RoutingEnd extends Routing {

	public RoutingEnd() {
		super(100, STATUS_END, ROUTING_END, "END");
	}

	public String calculate() {
		return ROUTING_END;
	}
}
