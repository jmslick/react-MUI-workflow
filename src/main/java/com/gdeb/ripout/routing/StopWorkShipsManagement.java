package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class StopWorkShipsManagement extends Routing {

	public StopWorkShipsManagement() {
		super(100, Routing.STATUS_WORK, ROUTING_STOP_WORK_SHIPS_MANAGEMENT, ROLE_SHIP_MANAGER);
	}

	public String calculate() {
		return ROUTING_STOP_WORK_LEAD_TRADE;
	}
}
