package main.java.com.gdeb.ripout.routing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.gdeb.ripout.app.RipoutRepository;
import main.java.com.gdeb.ripout.app.TaskOriRepo;
import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.model.TaskOri;
import main.java.com.gdeb.ripout.model.TaskRouting;

/**
 * @author jslick
 * 
 *         This abstract class is the base class of all ripout routing step
 *         classes. Each extended instance of this class has its own calculate
 *         method which examines the ripout record and returns the name of the
 *         Ripout subclass to process the ensuing routing step.
 */

public abstract class Routing {
	// task table column: routing map of java classes
	public static final String ROUTING_RIPOUT_UNDEFINED = "undefined routing";
	public static final String ROUTING_ORIGINATOR = "Originator";
	public static final String ROUTING_RIPOUT_WRITER = "RipoutWriter";
	public static final String ROUTING_LEAD_TRADE = "LeadTrade";
	public static final String ROUTING_SHIP_MGMT_APPROVAL = "ShipsManagementApproval";
	public static final String ROUTING_SHIPS_FORCE = "ShipsForce";
	public static final String ROUTING_SHIPS_MANAGEMENT = "ShipsManagement";

	public static final String ROUTING_NQCE_NUCLEAR_INTERFACE = "NQCENuclearInterface";
	public static final String ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW = "QAESpecialEmphasisReview";
	public static final String ROUTING_ENGINEERING_INITIAL_REVIEW = "EngineeringInitialReview";
	public static final String ROUTING_ENGINEERING_SUPER_REVIEW = "EngineeringSupervisorReview";
	public static final String ROUTING_QAE_REENTRY_CTL_DOC_NUM = "QAEReentryControlDocumentNumber";
	public static final String ROUTING_PLANNING_D355_BLUE_TAGS = "PlanningBlueTags";
	public static final String ROUTING_TEST_DEPT_TEST_CONTROLS = "TestDeptTestControls";
	public static final String ROUTING_QAI_PIPING_REVIEW = "QaiPipingReview";
	public static final String ROUTING_QAI_MECH_REVIEW = "QaiMechReview";
	public static final String ROUTING_QAI_STRU_REVIEW = "QaiStruReview";
	public static final String ROUTING_QAI_ELEC_REVIEW = "QaiElecReview";
	public static final String ROUTING_QAI_SUPERVISOR_REVIEW = "QaiSupervisorReview";
	public static final String ROUTING_QAE_PRE_ISSUE_REVIEW = "QaePreIssueReview";

	public static final String ROUTING_SAFETY_TECH_MECH = "SafetyTechMechanical";
	public static final String ROUTING_SAFETY_TECH_ELEC = "SafetyTechElectrical";
	public static final String ROUTING_SAFETY_TECH_ELTX = "SafetyTechElectronics";

	public static final String ROUTING_STOP_WORK = "StopWork";
	public static final String ROUTING_STOP_WORK_SHIPS_FORCE = "StopWorkShipsForce";
	public static final String ROUTING_STOP_WORK_SHIPS_MANAGEMENT = "StopWorkShipsManagement";
	public static final String ROUTING_STOP_WORK_LEAD_TRADE = "StopWorkLeadTrade";

	public static final String ROUTING_END = "RoutingEnd";

	// task table column: role
	public static final String ROLE_ORIGINATOR = "EBROOriginator";
	public static final String ROLE_RIPOUT_WRITER = "EBRORipoutWriter";
	public static final String ROLE_LEAD_TRADE = "EBROLeadTrade";
	public static final String ROLE_SHIP_MANAGER = "EBROShipManager";
	public static final String ROLE_SHIPS_FORCE = "EBROShipsForce";
	public static final String ROLE_NUCLEAR_QUALITY_CONTROL = "EBRONuclearQualityControl";
	public static final String ROLE_QAE = "EBROQAE";
	public static final String ROLE_ENHANCED_RO_ENGINEER = "EBROEnhancedROEngineer";
	public static final String ROLE_ENHANCED_RO_ENGINEER_SUPERVISOR = "EBROEnhancedROEngineerSupervisor";
	public static final String ROLE_PLANNING = "EBROPlanning";
	public static final String ROLE_TEST_DEPT_TEST_CONTROLS = "EBROTestDepartment";
	public static final String ROLE_SAFETY_TECH_MECH = "EBROSafetyTechMechanical";
	public static final String ROLE_SAFETY_TECH_ELEC = "EBROSafetyTechElectrical";
	public static final String ROLE_SAFETY_TECH_ELTX = "EBROSafetyTechElectronics";

	public static final String ROLE_EBRONuclearQualityControl = "EBRONuclearQualityControl";
	public static final String ROLE_QAI = "EBROQAI";
	public static final String ROLE_QAI_SUPERVISOR_REVIEW = "EBROQAISupervisor";

	public static final String STATUS_ORIG = "ORIG";
	public static final String STATUS_DRFT = "DRFT";
	public static final String STATUS_NPUB = "NPUB";
	public static final String STATUS_STEC = "STEC";
	public static final String STATUS_WORK = "WORK";
	public static final String STATUS_INSP = "INSP";
	public static final String STATUS_RFRT = "RFRT";
	public static final String STATUS_RTON = "RTON";
	public static final String STATUS_INST = "INST";
	public static final String STATUS_STOP = "STOP";
	public static final String STATUS_END = "END";

	protected int id;
	protected String status;
	protected String role;
	protected String routingCurrent;
	protected List<TaskRouting> routings;

	protected Ripout ripout;

	@Autowired
	TaskOriRepo taskrepo;

	RipoutRepository ripoutRepository;

	public Routing(int id, String status, String routingCurrent, List<String> routings, String role) {
		super();
		this.id = id;
		this.status = status;
		this.routingCurrent = routingCurrent;
		this.role = role;
	}

	// old c'tor w/o routings list
	public Routing(int id, String status, String routingCurrent, String role) {
		super();
		this.id = id;
		this.status = status;
		this.routingCurrent = routingCurrent;
		this.role = role;
		// System.out.println("Routing created: " + toString());
		// loadRoutings();
	}

	public void setRipout(Ripout ripout) {
		this.ripout = ripout;
	}

	public void setRipoutRepository(RipoutRepository ripoutRepository) {
		this.ripoutRepository = ripoutRepository;
	}

	private void loadRoutings() {
		TaskOri task = taskrepo.findTaskOriByRoutingCurrent(routingCurrent);
		System.out.println(task.toString());
		// routings = task.getTaskRoutings();
	}

	public List<TaskRouting> getTaskRoutings() {
		return routings;
	}

	public String calculate() {
		throw new UnsupportedOperationException("Undefined routing class");
	}

	public String getStatus() {
		return status;
	}

	public String getRoutingCurrent() {
		return routingCurrent;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", routingClass=" + routingCurrent + ", role=" + role + "]";
	}
}
