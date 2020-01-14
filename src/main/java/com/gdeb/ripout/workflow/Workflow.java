package main.java.com.gdeb.ripout.workflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.RipoutApplication;
import main.java.com.gdeb.ripout.app.RipoutRepository;
import main.java.com.gdeb.ripout.app.TaskRepo;
import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.model.Task;
import main.java.com.gdeb.ripout.routing.Routing;

/**
 * 
 * @author jslick
 *
 */
@Service
public class Workflow {

	private static Ripout ripout;
	private static Routing routing;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RipoutApplication.class);

	// @Autowired
	// TaskOriRepo taskOriRepository;

	@Autowired
	TaskRepo taskRepository;

	@Autowired
	RipoutRepository ripoutRepository;

	Workflow(RipoutRepository repository, TaskRepo taskRepository) {
		log.debug("Workflow ctor");
		this.taskRepository = taskRepository;
	}

	public void start() {
		ripoutRepository.save(new Ripout("001", true, "RO123450 001", "J. Siczpak", "987456", "w1487", "PHOTONIC",
				"PSA", "Type-4", "Mast Config", "722", "452", Routing.STATUS_ORIG, Routing.ROLE_ORIGINATOR));

		List<Ripout> list = ripoutRepository.findAll();
		log.info("Ripout started: " + list.get(list.size() - 1));
	}

//	public static void signWorkflowStep(long id) {
//		System.out.println("Signing " + ripout.toString());
//		loadRoutingClass(ripout.getRouting());
//		ripout.setStatus(routing.getStatus());
//		ripout.setRouting(routing.calculate());
//	}

	public void sign(Ripout ripout) {
		System.out.println("--------------------");

		Task task = taskRepository.findByXref(ripout.getXref());
		System.out.println("Signing " + task.getRoutingCurrent() + ": " + ripout.signingMessage());

		loadRoutingClass(task.getRoutingCurrent(), null);
		task.setRoutingPredecessor(routing.getRoutingCurrent());

		loadRoutingClass(routing.calculate(), ripout); // next routing
		task.setRoutingCurrent(routing.getRoutingCurrent());

		taskRepository.save(task);

		report(task);
	}

	public void stop(Ripout ripout) {
		System.out.println("--------------------");
		Task task = taskRepository.findByXref(ripout.getXref());
		System.out.println("STOP WORK " + task.getRoutingCurrent() + ": " + ripout.signingMessage());

		loadRoutingClass(task.getRoutingCurrent(), null);
		task.setRoutingPredecessor(routing.getRoutingCurrent());

		loadRoutingClass(Routing.ROUTING_STOP_WORK_SHIPS_FORCE, ripout);
		task.setRoutingCurrent(routing.getRoutingCurrent());

		taskRepository.save(task);

		report(task);
	}

	/**
	 * Looks like stop() but after final sig, routing resumes at lead trade. That
	 * decision is in class StopWorkLeadTrade.calculate();
	 * 
	 * @param ripout
	 */
	public void resume(Ripout ripout) {
		System.out.println("--------------------");
		Task task = taskRepository.findByXref(ripout.getXref());
		System.out.println("RESUME WORK " + task.getRoutingCurrent() + ": " + ripout.signingMessage());

		report(task);
	}

	private void loadRoutingClass(String routingName, Ripout ripout) {
		final String pkg = "main.java.com.gdeb.ripout.routing.";
		try {
			Class clazz = Class.forName(pkg + routingName);
			routing = (Routing) clazz.newInstance();
			routing.setRipout(ripout);
			routing.setRipoutRepository(ripoutRepository);
			// System.out.println("Loaded routing class: " + routing.toString());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void report(Task task) {
//		System.out.println("Prev: " + task.getRoutingPredecessor());
		System.out.println("Now: " + task.getRoutingCurrent());
		System.out.println("Next: " + routing.calculate());
	}
}
