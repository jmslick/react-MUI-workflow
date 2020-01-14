package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class StopWork extends Routing {

	public StopWork() {
		super(100, Routing.STATUS_STEC, ROUTING_STOP_WORK, null);
		ripout.setStatus(STATUS_WORK);
	}

	public String calculate() {
		return ROUTING_STOP_WORK_SHIPS_FORCE;
	}
}
