package main.java.com.gdeb.ripout.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

/**
 * @author admin
 *
 */
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Task {

	@Id
	// @GeneratedValue
	private long id;

	private String status;
	private String role;
	private String routingCurrent;
	private String routingNext;
	private String routingClass;

	@OneToMany(mappedBy = "task")
	private List<TaskRouting> taskRoutings;

	public List<TaskRouting> getTaskRoutings() {
		return taskRoutings;
	}

	public void setTaskRoutings(List<TaskRouting> taskRoutings) {
		this.taskRoutings = taskRoutings;
	}

	public Task() {
		super();
	}

	public Task(long id) {
		super();
		this.id = id;
	}

	public Task(long id, String status, String routingCurrent, String role, String routingClass) {
		super();

		this.id = id;
		this.status = status;
		this.routingCurrent = routingCurrent;
		this.role = role;
		this.routingClass = routingClass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoutingCurrent() {
		return routingCurrent;
	}

	public void setRoutingCurrent(String routingCurrent) {
		this.routingCurrent = routingCurrent;
	}

	public String getRoutingNext() {
		return routingNext;
	}

	public void setRoutingNext(String routingNext) {
		this.routingNext = routingNext;
	}

	public String getRoutingClass() {
		return routingClass;
	}

	public void setRoutingClass(String routingClass) {
		this.routingClass = routingClass;
	}

}
