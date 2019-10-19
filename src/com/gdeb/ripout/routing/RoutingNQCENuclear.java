package com.gdeb.ripout.routing;

import com.gdeb.ripout.workflow.Workflow;

/**
 * @author admin
 *
 */
public class RoutingNQCENuclear extends Routing {

	public RoutingNQCENuclear() {
		super(40, "NQCE", "EBRONuclearQualityControl");
	}

	public String calculate() {
		Double d = Math.random();
		System.out.println(d);
		if (d > 0.5)
			return Workflow.RIPOUT_UNDEFINED;
		else
			return Workflow.ENGINEERING_INITIAL_REVIEW;
	}

}
