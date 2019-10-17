package com.gdeb.ripout.workflow;

import com.gdeb.ripout.routing.Routing;

public class Workflow {
	private Ripout ripout;
	private Routing routing;

	public Workflow(Ripout ripout) {
		super();
		this.ripout = ripout;
		this.routing = ripout.getRouting();
	}

	public void progress() {
		routing = ripout.getRouting();
		ripout.setRouting(routing.calculate());
	}
}
