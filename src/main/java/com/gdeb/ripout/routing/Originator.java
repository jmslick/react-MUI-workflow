package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class Originator extends Routing {

	public Originator() {
		super(0, null, "Originator", "EBROOriginator");
	}

	public String calculate() {
		return ROUTING_RIPOUT_WRITER;
	}
}
