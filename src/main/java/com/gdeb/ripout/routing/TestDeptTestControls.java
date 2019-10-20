package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class TestDeptTestControls extends Routing {

	public TestDeptTestControls() {
		super(160, STATUS_STEC, "WRITER", "EBROTestDepartment");
	}

	public String calculate() {
		return ROUTING_SHIP_MGMT_APPROVAL;
	}

}
