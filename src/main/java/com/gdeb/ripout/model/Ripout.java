package main.java.com.gdeb.ripout.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ripout {

	@Id
	@GeneratedValue
	private long xref;

	private int xref_seq;
	private int badge;
	private String userid;
	private String status;
	private boolean nuclear;

	private String routing;

	public Ripout() {
		super();
	}

	public Ripout(int xref_seq, String routing, boolean nuclear, String status, int badge, String userid) {
		super();
		this.xref_seq = xref_seq;
		this.nuclear = nuclear;
		this.status = status;
		this.badge = badge;
		this.userid = userid;
		this.routing = routing;

		System.out.println("Ripout origin: " + toString());
		System.out.println("----");
	}

	public Ripout(long xref, int xref_seq, String routing, boolean nuclear, String status, int badge, String userid) {
		super();
		this.xref = xref;
		this.xref_seq = xref_seq;
		this.nuclear = nuclear;
		this.status = status;
		this.badge = badge;
		this.userid = userid;
		this.routing = routing;

		System.out.println("Ripout origin: " + toString());
		System.out.println("----");
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routingNext) {
		System.out.println("Routing current: " + this.routing);
		this.routing = routingNext;
		System.out.println("Routing next: " + routingNext);
		System.out.println("----");
	}

	public long getXref() {
		return xref;
	}

	public void setXref(int xref) {
		this.xref = xref;
	}

	public int getXref_seq() {
		return xref_seq;
	}

	public void setXref_seq(int xref_seq) {
		this.xref_seq = xref_seq;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isNuclear() {
		return nuclear;
	}

	public void setNuclear(boolean nuclear) {
		this.nuclear = nuclear;
	}

	@Override
	public String toString() {
		return "Ripout [xref=" + xref + ", xref_seq=" + xref_seq + ", routing=" + routing + ", nuclear=" + nuclear
				+ ", badge=" + badge + ", userid=" + userid + ", status=" + status + "]";
	}

}
