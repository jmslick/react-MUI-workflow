package main.java.com.gdeb.ripout.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author admin
 *
 *         Rev 2 of a task, aka open routing.
 * 
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Task {

	@Id
	// @GeneratedValue
	private long id;

	private long xref;
	private long xrefSeq;

	private String status;
	private String routingCurrent;
	private String routingPredecessor;
	private String routingSuccessor;

	public Task() {
		super();
	}

	public Task(long id) {
		super();
		this.id = id;
	}

	public Task(long xref, long xrefSeq, String routingCurrent, String routingSuccessor) {
		super();

		this.xref = xref;
		this.xrefSeq = xrefSeq;
		this.status = status;
		this.routingCurrent = routingCurrent;
		this.routingSuccessor = routingSuccessor;
		toString();
	}

	public long getXref() {
		return xref;
	}

	public void setXref(long xref) {
		this.xref = xref;
	}

	public long getXrefSeq() {
		return xrefSeq;
	}

	public void setXrefSeq(long xrefSeq) {
		this.xrefSeq = xrefSeq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoutingCurrent() {
		return routingCurrent;
	}

	public void setRoutingCurrent(String routingCurrent) {
		this.routingCurrent = routingCurrent;
	}

	public String getRoutingPredecessor() {
		return routingPredecessor;
	}

	public void setRoutingPredecessor(String routingPredecessor) {
		this.routingPredecessor = routingPredecessor;
	}

	public String getRoutingSuccessorClass() {
		return routingSuccessor;
	}

	public void setRoutingSuccessor(String routingSuccessor) {
		this.routingSuccessor = routingSuccessor;
	}

	public String getRoutingSuccessor() {
		return routingSuccessor;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", xref=" + xref + ", xrefSeq=" + xrefSeq + ", "
				+ (status != null ? "status=" + status + ", " : "")
				+ (routingCurrent != null ? "routingCurrent=" + routingCurrent + ", " : "")
				+ (routingPredecessor != null ? "routingPredecessor=" + routingPredecessor + ", " : "")
				+ (routingSuccessor != null ? "routingSuccessor=" + routingSuccessor : "") + "]";
	}
}
