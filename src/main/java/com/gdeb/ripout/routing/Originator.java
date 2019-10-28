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
		String next = ROUTING_RIPOUT_WRITER;
		System.out.println("Originator routing to: " + next);
		return next;
	}
}
