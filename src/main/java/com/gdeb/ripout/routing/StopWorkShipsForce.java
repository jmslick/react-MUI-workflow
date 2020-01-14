package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class StopWorkShipsForce extends Routing {

	public StopWorkShipsForce() {
		super(100, Routing.STATUS_WORK, ROUTING_STOP_WORK_SHIPS_FORCE, ROLE_SHIPS_FORCE);
	}

	public String calculate() {
		return ROUTING_STOP_WORK_SHIPS_MANAGEMENT;
	}
}
