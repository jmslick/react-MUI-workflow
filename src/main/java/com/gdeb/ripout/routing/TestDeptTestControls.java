package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class TestDeptTestControls extends Routing {

	public TestDeptTestControls() {
		super(160, STATUS_STEC, ROUTING_TEST_DEPT_TEST_CONTROLS, "EBROTestDepartment");
	}

	public String calculate() {
		return ROUTING_END;
	}

}
