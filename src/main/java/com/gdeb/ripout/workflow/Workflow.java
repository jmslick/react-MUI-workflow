package main.java.com.gdeb.ripout.workflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.RipoutApplication;
import main.java.com.gdeb.ripout.app.RipoutRepository;
import main.java.com.gdeb.ripout.app.TaskOriRepo;
import main.java.com.gdeb.ripout.app.TaskRepo;
import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.model.Task;
import main.java.com.gdeb.ripout.routing.Routing;

/**
 * 
 * @author jslick
 * 
 *         This class handles the work flow from step to step.
 *
 */
@Service
public class Workflow {

	private static Ripout ripout;
	private static Routing routing;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RipoutApplication.class);

	@Autowired
	TaskRepo taskRepository;

	@Autowired
	TaskOriRepo taskOriRepository;

	@Autowired
	RipoutRepository repository;

	Workflow(RipoutRepository repository, TaskOriRepo taskOriRepository, TaskRepo taskRepository) {
		log.debug("Workflow ctor");
		this.taskRepository = taskRepository;
		this.taskOriRepository = taskOriRepository;
	}

	public void start() {
		repository.save(new Ripout("001", true, "RO123450 001", "J. Siczpak", "987456", "w1487", "PHOTONIC", "PSA",
				"Type-4", "Mast Config", "722", "452", Routing.STATUS_ORIG, Routing.ROLE_ORIGINATOR));

		List<Ripout> list = repository.findAll();
		log.info("Ripout started: " + list.get(list.size() - 1));
	}

	public void signWorkflowStep(Ripout ripout) {
		System.out.println("--------------------");

		Task task = taskRepository.findByXref(ripout.getXref());
		System.out.println("Signing " + task.getRoutingCurrent() + ": " + ripout.signingMessage());

		loadRoutingClass(task.getRoutingCurrent()); // current routing
		task.setRoutingPredecessor(routing.getRoutingCurrent());

		loadRoutingClass(routing.calculate()); // next routing
		task.setRoutingCurrent(routing.getRoutingCurrent());

		taskRepository.save(task);

		System.out.println("Prev: " + task.getRoutingPredecessor());
		System.out.println("Now: " + task.getRoutingCurrent());
		System.out.println("Next: " + routing.calculate());
	}

	public static void signWorkflowStep(long id) {
		System.out.println("Signing " + ripout.toString());
		loadRoutingClass(ripout.getRouting());
		ripout.setStatus(routing.getStatus());
		ripout.setRouting(routing.calculate());
	}

	private static void loadRoutingClass(String routingName) {
		final String pkg = "main.java.com.gdeb.ripout.routing.";
		try {
			Class clazz = Class.forName(pkg + routingName);
			routing = (Routing) clazz.newInstance();
			// System.out.println("Loaded routing class: " + routing.toString());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
