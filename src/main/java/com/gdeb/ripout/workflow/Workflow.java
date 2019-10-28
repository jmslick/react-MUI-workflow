package main.java.com.gdeb.ripout.workflow;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.routing.Routing;

/**
 * 
 * @author jslick
 * 
 *         This class handles the work flow from step to step.
 *
 */
public class Workflow {

	private static Ripout ripout;
	private static Routing routing;

	public static void signWorkflowStep(Ripout ripout) {
		System.out.println("Sign off: " + ripout.toString());
		loadRoutingClass(ripout.getRouting());
		System.out.println("Loaded next routing object: " + routing.toString());
		ripout.setStatus(routing.getStatus());
		ripout.setRouting(routing.calculate());
	}

	private static void loadRoutingClass(String routingName) {
		final String pkg = "main.java.com.gdeb.ripout.routing.";
		try {
			Class clazz = Class.forName(pkg + routingName);
			routing = (Routing) clazz.newInstance();			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
