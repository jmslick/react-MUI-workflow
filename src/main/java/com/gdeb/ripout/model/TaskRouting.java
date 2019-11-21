package main.java.com.gdeb.ripout.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class TaskRouting {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	private Task task;

	private String routing;

	public TaskRouting() {
		super();
	}

	public TaskRouting(String routing, Task task) {
		super();
		this.routing = routing;
		this.task = task;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}
}
