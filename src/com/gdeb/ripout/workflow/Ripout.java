package com.gdeb.ripout.workflow;

import com.gdeb.ripout.routing.Routing;

public class Ripout {
	// protected static final Logger log = LogManager.getLogger(Ripout.class);

	private Routing routing;
	private String openRouting;

	private int xref;
	private int xref_seq;
	private int badge;
	private String userid;
	private String status;
	private boolean nuclear;

	public Ripout(int xref, int xref_seq, boolean nuclear, String status, int badge, String userid) {
		super();
		this.xref = xref;
		this.xref_seq = xref_seq;
		this.nuclear = nuclear;
		this.status = status;
		this.badge = badge;
		this.userid = userid;
		this.openRouting = Workflow.RIPOUT_ORIGINATOR;

		System.out.println("Ripout origin: " + toString());
		System.out.println("----");
	}

	public Routing getRouting() {
		return routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
		System.out.println("Open: " + routing.toString());
	}

	public String getOpenRouting() {
		return openRouting;
	}

	public void setOpenRouting(String openRouting) {
		this.openRouting = openRouting;
		System.out.println("Open: " + openRouting);
		System.out.println("----");
	}

	public int getXref() {
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
		return "Ripout [xref=" + xref + ", xref_seq=" + xref_seq + ", nuclear=" + nuclear + ", status=" + status
				+ ", routing=" + routing + ", openRouting=" + openRouting + "]";
	}

}
