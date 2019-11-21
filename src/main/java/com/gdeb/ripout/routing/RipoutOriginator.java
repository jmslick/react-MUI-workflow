package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class RipoutOriginator extends Routing {

	public RipoutOriginator() {
		super(0, null, "Originator", "EBROOriginator");
	}

	public String calculate() {
		return ROUTING_RIPOUT_WRITER;
	}
}
