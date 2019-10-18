package com.gdeb.ripout.workflow;

import java.util.Map;
import java.util.TreeMap;

import com.gdeb.ripout.routing.Routing;

public class Workflow {
	// Class names of routing step classes. These are instantiated at steps in the
	// work flow.
	public static final String RIPOUT_UNDEFINED = "undefined routing";
	public static final String RIPOUT_ORIGINATOR = "RoutingOriginator";
	public static final String RIPOUT_WRITER = "RoutingRipoutWriter";
	public static final String SHIP_MGR_APPROVAL = "RoutingShipMgrApproval";
	public static final String QAI_PIPING = "RoutingQAIPiping";
	public static final String QAE_REVIEW = "RoutingQAEReview";
	public static final String NQCE_Nuclear = "RoutingNQCENuclear";
	public static final String LEAD_TRADE = "RoutingLeadTrade";
	public static final String ENGINEERING_INITIAL_REVIEW = "RoutingEngineeringInitialReview";
	public static final String TEST_DEPT_TEST_CONTROLS = "RoutingTestDeptTestControls";

	private Map<String, String> routings;

	private Ripout ripout;
	private Routing routing;

	public Workflow(Ripout ripout) {
		super();
		// populateRoutings();
		this.ripout = ripout;
		// this.routing = ripout.getRouting();
	}

	public void signRoutingStep(Ripout ripout) {
		loadRoutingClass(ripout.getOpenRouting());
		progress();
	}

	public void progress() {
		// routing = ripout.getRouting();
		// ripout.setRouting(routing.calculate());
		String nextStep = routing.calculate();
		ripout.setOpenRouting(nextStep);
	}

	private void loadRoutingClass(String routingName) {
		final String pkg = "com.gdeb.ripout.routing.";
		// String className = routings.get(routingName);
		try {
			Class clazz = Class.forName(pkg + routingName);
			routing = (Routing) clazz.newInstance();
			System.out.println(routing.toString());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void populateRoutings() {
		routings = new TreeMap<String, String>();
		routings.put("Engineering Initial Review", "RoutingEngineeringInitialReview");
		routings.put("Lead Trade", "RoutingLeadTrade");
		routings.put("NQCE Nuclear", "RoutingNQCENuclear");
		routings.put("QAI Review", "RoutingQAIReview");
		routings.put("QAI Piping", "RoutingQAIPiping");
		routings.put("Ship Mgr Approval", "RoutingShipMgrApproval");
		routings.put("Ripout Writer", "RoutingRipoutWriter");
		routings.put("Test Dept Test Controls", "RoutingTestDeptTestControls");
	}
}
