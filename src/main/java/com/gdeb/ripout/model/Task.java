package main.java.com.gdeb.ripout.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author admin
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Task {

	@Id
	// @GeneratedValue
	private long id;

	private String status;
	private String role;
	private long routingNumber;
	private String routingCurrent;
	private String routingNext;
	private String routingClass;

	@OneToMany(mappedBy = "task")
	private Set<TaskRouting> taskRoutings;

	public Task() {
		super();
	}

	public Task(long id) {
		super();
		this.id = id;
	}

	public Task(long id, String status, String routingCurrent, String role, String routingClass) {
		super();

		this.status = status;
		this.role = role;
		// this.routingNumber = routingNumber;
		this.id = id;
		this.routingCurrent = routingCurrent;
		this.routingClass = routingClass;
	}

	public Set<TaskRouting> getTaskRoutings() {
		return taskRoutings;
	}

	public void setTaskRoutings(Set<TaskRouting> taskRoutings) {
		this.taskRoutings = taskRoutings;
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

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", routingNumber=" + routingNumber + ", status=" + status + ", role=" + role
				+ ", routingCurrent=" + routingCurrent + ", routingNext=" + routingNext + ", routingClass="
				+ routingClass + ", taskRoutings=" + taskRoutings + "]";
	}
}
