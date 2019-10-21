package main.java.com.gdeb.ripout.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.workflow.Workflow;

@RestController
class RipoutController {

	private final RipoutRepository repository;

	RipoutController(RipoutRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	@GetMapping("/ripout")
	List<Ripout> all() {
		return repository.findAll();
	}

	@PostMapping("/ripout/originate")
	Ripout newRipout(@RequestBody Ripout ripout) {
		return repository.save(ripout);
	}

	// Single item
	@GetMapping("/ripout/{id}")
	Ripout findOne(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
	}

	// progress and return the progressed ripout record
	@PutMapping("/ripout/progress/{id}")
	Ripout progress(@PathVariable Long id) {
		Ripout ripout = repository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
		Workflow.signWorkflowStep(ripout);
		repository.save(ripout);
		return repository.findById(id).orElseThrow(() -> new RipoutNotFoundException(id));
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
		repository.deleteById(id);
	}
}