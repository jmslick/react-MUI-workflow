package main;

import com.gdeb.ripout.workflow.Ripout;
import com.gdeb.ripout.workflow.Workflow;

public class ripoutTest {
	public static void main(String[] args) {
		Ripout ripout = new Ripout(1, 1, true, "DRFT", 012345, "siczpak");

		Workflow workflow = new Workflow(ripout);
		workflow.signRoutingStep(ripout);
		workflow.signRoutingStep(ripout);
		workflow.signRoutingStep(ripout);
		workflow.signRoutingStep(ripout);
		workflow.signRoutingStep(ripout);
	}
}