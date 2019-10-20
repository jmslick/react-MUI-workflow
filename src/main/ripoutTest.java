package main;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.workflow.Workflow;

public class ripoutTest {
	public static void main(String[] args) {
		Ripout ripout = new Ripout(1, 1, "RipoutWriter", true, "STATUS", 012345, "siczpak");

		Workflow.signWorkflowStep(ripout);
		Workflow.signWorkflowStep(ripout);
		Workflow.signWorkflowStep(ripout);
		Workflow.signWorkflowStep(ripout);
	}
}