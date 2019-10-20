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
	// routing constants define each routing class name for class loader use
	public static final String ROUTING_RIPOUT_UNDEFINED = "undefined routing";
	public static final String RIPOUT_ROUTING_ORIGINATOR = "Originator";
	public static final String ROUTING_RIPOUT_WRITER = "RipoutWriter";
	public static final String ROUTING_LEAD_TRADE = "LeadTrade";
	public static final String ROUTING_SHIP_MGMT_APPROVAL = "ShipsManagementApproval";
	public static final String ROUTING_NQCE_NUCLEAR_INTERFACE = "NQCENuclearInterface";
	public static final String ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW = "QAESpecialEmphasisReview";
	public static final String ROUTING_ENGINEERING_INITIAL_REVIEW = "EngineeringInitialReview";
	public static final String ROUTING_QAI_PIPING = "QAIPipingReview";
	public static final String ROUTING_TEST_DEPT_TEST_CONTROLS = "TestDeptTestControls";

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

	@Override
	public String toString() {
		return "Routing [id=" + id + ", routingClass=" + routingClass + ", role=" + role + "]";
	}
}
