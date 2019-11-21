package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 * 
 *         This abstract class is the base class of all ripout routing step
 *         classes. Each extended instance of this class has its own calculate
 *         method which examines the ripout record and returns the name of the
 *         Ripout subclass to process the ensuing routing step.
 */
public abstract class Routing {
	// task table column: routing name
	public static final String ROUTING_RIPOUT_UNDEFINED = "undefined routing";
	public static final String ROUTING_ORIGINATOR = "Originator";
	public static final String ROUTING_RIPOUT_WRITER = "RipoutWriter";
	public static final String ROUTING_LEAD_TRADE = "LeadTrade";
	public static final String ROUTING_SHIP_MGMT_APPROVAL = "Ships Management Approval";
	public static final String ROUTING_NQCE_NUCLEAR_INTERFACE = "NQCE Nuclear Interface";
	public static final String ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW = "QAE - Special Emphasis Review";
	public static final String ROUTING_ENGINEERING_INITIAL_REVIEW = "Engineering Initial Review";
	public static final String ROUTING_ENGINEERING_SUPER_REVIEW = "Engineering Supervisor Review";
	public static final String ROUTING_QAE_REENTRY_CTL_DOC_NUM = "QAE - Reentry Control Document Number";
	public static final String ROUTING_PLANNING_D355_BLUE_TAGS = "Planning - Blue Tags";

	public static final String ROUTING_TEST_DEPT_TEST_CONTROLS = "Test Dept Test Controls";

	public static final String ROUTING_QAI_PIPING_REVIEW = "Qai - Piping Review";
	public static final String ROUTING_QAI_MECH_REVIEW = "Qai - Mech Review";
	public static final String ROUTING_QAI_STRU_REVIEW = "Qai - Stru Review";
	public static final String ROUTING_QAI_ELEC_REVIEW = "Qai - Elec Review";
	public static final String ROUTING_QAI_SUPERVISOR_REVIEW = "Qai - Supervisor Review";

	// task table column: role
	public static final String ROLE_Originator = "EBROOriginator";
	public static final String ROLE_RipoutWriter = "EBRORipoutWriter";
	public static final String ROLE_LeadTrade = "EBROLeadTrade";
	public static final String ROLE_ShipManager = "EBROShipManager";
	public static final String ROLE_NuclearQualityControl = "EBRONuclearQualityControl";
	public static final String ROLE_QAE = "EBROQAE";
	public static final String ROLE_ENHANCED_RO_ENGINEER = "EBROEnhancedROEngineer";
	public static final String ROLE_ENHANCED_RO_ENGINEER_SUPERVISOR = "EBROEnhancedROEngineerSupervisor";
	public static final String ROLE_PLANNING = "EBROPlanning";
	public static final String ROLE_TEST_DEPT_TEST_CONTROLS = "EBROTestDepartment";

	public static final String ROLE_EBRONuclearQualityControl = "EBRONuclearQualityControl";
	public static final String ROLE_QAI = "EBROQAI";
	public static final String ROLE_QAI_SUPERVISOR_REVIEW = "EBROQAISupervisor";

	public static final String STATUS_DRFT = "DRFT";
	public static final String STATUS_NPUB = "NPUB";
	public static final String STATUS_STEC = "STEC";
	public static final String STATUS_WORK = "WORK";
	public static final String STATUS_INSP = "INSP";
	public static final String STATUS_RFRT = "RFRT";
	public static final String STATUS_RTON = "RTON";
	public static final String STATUS_INST = "INST";

	protected int id;
	protected String routingClass;
	protected String role;

	protected String status;

	public Routing(int id, String status, String routingClass, String role) {
		super();
		this.id = id;
		this.status = status;
		this.routingClass = routingClass;
		this.role = role;
	}

	public String calculate() {
		throw new UnsupportedOperationException("Undefined routing class");
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Routing [id=" + id + ", routingClass=" + routingClass + ", role=" + role + "]";
	}
}
