package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class Originator extends Routing {

	public Originator() {
		super(10, null, ROUTING_RIPOUT_UNDEFINED, ROLE_Originator);
	}

	public String calculate() {
		return "undefined";
	}

}
