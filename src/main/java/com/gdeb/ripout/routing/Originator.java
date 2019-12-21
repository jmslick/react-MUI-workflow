package main.java.com.gdeb.ripout.routing;

import org.springframework.stereotype.Component;

/**
 * @author jslick
 *
 */
@Component
public class Originator extends Routing {

	public Originator() {
		super(10, null, ROUTING_ORIGINATOR, ROLE_ORIGINATOR);
	}

	public String calculate() {
		return Routing.ROUTING_RIPOUT_WRITER;
	}

}
