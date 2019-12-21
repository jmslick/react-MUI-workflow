package main.java.com.gdeb.ripout.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author admin
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class TaskRouting {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "task")
	private Task task;

	private Long routingNumber;

	private String routing;

	public TaskRouting() {
		super();
	}

	public TaskRouting(String routing, Task task) {
		super();
		this.routing = routing;
		this.task = task;
	}

	public TaskRouting(String routing, long routingNumber, Task task) {
		super();
		this.routing = routing;
		this.routingNumber = new Long(routingNumber);
		this.task = task;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(Long routingNumber) {
		this.routingNumber = routingNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((routing == null) ? 0 : routing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskRouting other = (TaskRouting) obj;
		if (id != other.id)
			return false;
		if (routing == null) {
			if (other.routing != null)
				return false;
		} else if (!routing.equals(other.routing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskRouting [id=" + id + ", routingNumber=" + routingNumber + ", routing=" + routing + ", task=" + task
				+ "]";
	}
}
