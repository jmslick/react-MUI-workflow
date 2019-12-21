package main.java.com.gdeb.ripout.app;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.model.Task;
import main.java.com.gdeb.ripout.workflow.Workflow;

@CrossOrigin(maxAge = 3600) // CORS support
@RestController
class RipoutController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RipoutController.class);

	private final RipoutRepository ripoutRepository;
	private final TaskRepo taskRepository;
	private final Workflow workflow;

	RipoutController(RipoutRepository ripoutRepository, TaskRepo taskRepository, Workflow workflow) {
		this.ripoutRepository = ripoutRepository;
		this.taskRepository = taskRepository;
		this.workflow = workflow;
	}

	// Aggregate root
	@GetMapping("/ripout")
	List<Ripout> all() {
		return ripoutRepository.findAll();
	}

//	@PostMapping("/ripout/originate")
//	Ripout newRipout(@RequestBody Ripout ripout) {
//		return ripoutRepository.save(ripout);
//	}

	@PostMapping("/ripout/originate")
	// public void originate(@RequestBody Ripout ripout) {
	public void originate(@RequestParam Map<String, String> params) {
		Ripout ripout = new Ripout(params.get("xrefSeq"), false, params.get("badge"), params.get("userid"));
		ripoutRepository.save(ripout);
	}

	@PostMapping("/ripout/start")
	void workflowStart() {
		workflow.start();
	}

	// Ripout by id
	@GetMapping("/ripout/{id}")
	Ripout findOne(@PathVariable Long id) {
		return ripoutRepository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
	}

	// Open Routings
	@GetMapping("/ripout/openroutings")
	Iterable<String> findOpenRoutings() {
		return ripoutRepository.findOpenRoutings();
	}

	// Ripouts by routing
	@GetMapping("/ripout/active/{routing}")
	Iterable<Ripout> findByRouting(@PathVariable String routing) {
		return ripoutRepository.findByRouting(routing);
	}

	// progress and return the progressed ripout record
	@PutMapping("/ripout/progress/{id}")
	Ripout _progress(@PathVariable Long id) {
		Ripout ripout = ripoutRepository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
		Workflow.signWorkflowStep(ripout);
		ripoutRepository.save(ripout);
		return ripoutRepository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
	}

	// progress and return the progressed ripout record
	@PutMapping("/ripout/_progress/{id}")
	Ripout progress(@PathVariable Long id) {
		// Ripout ripout = repository.findById(id).orElseThrow(() -> new
		// RipoutNotFoundException(id));
		Workflow.signWorkflowStep(id);
		// repository.save(ripout);
		return ripoutRepository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
	}

	/*
	 * @PutMapping("/ripout/{id}") Ripout replaceRipout(@RequestBody Ripout
	 * ripout, @PathVariable Long id) {
	 * 
	 * return repository.findById(id).map(employee -> {
	 * //employee.setName(newEmployee.getName());
	 * //employee.setRole(newEmployee.getRole()); return repository.save(r);
	 * }).orElseGet(() -> { newEmployee.setId(id); return
	 * repository.save(newEmployee); }); }
	 */

	@DeleteMapping("/ripout/delete/{id}")
	void deleteRipout(@PathVariable Long id) {
		ripoutRepository.deleteById(id);
	}

	// Tasks
	@GetMapping("/ripout/tasks")
	Iterable<Task> findAllTasks() {
		return taskRepository.findAll();
	}

	// Task
	@GetMapping("/ripout/task/{id}")
	Task findTasks(@PathVariable Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
	}

}