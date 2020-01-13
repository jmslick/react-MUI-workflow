package main.java.com.gdeb.ripout.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.Data;
import main.java.com.gdeb.ripout.routing.Routing;

@Data
@Entity
public class Ripout {

	@Id
	@GeneratedValue
	private long xref;

	private String xrefSeq;
	private boolean nuclear;
	private String ripoutNo;
	private String originator;
	private String originationDate;
	private String status;
	private String workOrder;
	private String wppn;
	private String sysComp;
	private String psaNew;
	private String badge;
	private String userid;
	private String authDocType;
	private String authDoc;
	private String ship;
	private String leadTrade;
	private String drawing1;
	private String drawing1Rev;
	private String drawing1ApplicPages;
	private String tradeBoundary;
	private String routing;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Ripout.class);

	public Ripout() {
		super();
	}

	@PersistenceConstructor
	public Ripout(String xrefSeq, boolean nuclear, String badge, String userid) {
		super();
		this.xrefSeq = xrefSeq;
		this.nuclear = nuclear;
		this.badge = badge;
		this.userid = userid;
		this.originator = userid;
		this.status = Routing.STATUS_ORIG;
		this.routing = Routing.ROLE_ORIGINATOR;

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.originationDate = now.format(formatter);

		log.info("Ripout record: " + toString());
	}

	public Ripout(String xrefSeq, boolean nuclear, String ripoutNo, String originator, String badge, String wppn,
			String sysComp, String psaNew, String authDocType, String authDoc, String ship, String leadTrade,
			String status, String routing) {
		super();
		this.xrefSeq = xrefSeq;
		this.nuclear = nuclear;
		this.originator = originator;
		this.badge = badge;
		this.wppn = wppn;
		this.sysComp = sysComp;
		this.psaNew = psaNew;
		this.authDocType = authDocType;
		this.authDoc = authDoc;
		this.ship = ship;
		this.leadTrade = leadTrade;
		this.status = status;
		this.routing = routing;

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.originationDate = now.format(formatter);

		log.info("New record: " + toString());
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		System.out.println("Predecessor: " + this.routing);
		this.routing = routing;
		System.out.println("Successor: " + routing);
		System.out.println("----");
	}

	public String getXrefSeq() {
		return xrefSeq;
	}

	public void setXrefSeq(String xrefSeq) {
		this.xrefSeq = xrefSeq;
	}

	public boolean isNuclear() {
		return nuclear;
	}

	public void setNuclear(boolean nuclear) {
		this.nuclear = nuclear;
	}

	public String getNuclear() {
		return nuclear == true ? "Yes" : "No";
	}

	public String getRipoutNo() {
		return ripoutNo;
	}

	public void setRipoutNo(String ripoutNo) {
		this.ripoutNo = ripoutNo;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getOriginationDate() {
		return originationDate;
	}

	public void setOriginationDate(String originationDate) {
		this.originationDate = originationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(String workOrder) {
		this.workOrder = workOrder;
	}

	public String getWppn() {
		return wppn;
	}

	public void setWppn(String wppn) {
		this.wppn = wppn;
	}

	public String getSysComp() {
		return sysComp;
	}

	public void setSysComp(String sysComp) {
		this.sysComp = sysComp;
	}

	public String getPsaNew() {
		return psaNew;
	}

	public void setPsaNew(String psaNew) {
		this.psaNew = psaNew;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAuthDocType() {
		return authDocType;
	}

	public void setAuthDocType(String authDocType) {
		this.authDocType = authDocType;
	}

	public String getAuthDoc() {
		return authDoc;
	}

	public void setAuthDoc(String authDoc) {
		this.authDoc = authDoc;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getLeadTrade() {
		return leadTrade;
	}

	public void setLeadTrade(String leadTrade) {
		this.leadTrade = leadTrade;
	}

	public String getDrawing1() {
		return drawing1;
	}

	public void setDrawing1(String drawing1) {
		this.drawing1 = drawing1;
	}

	public String getDrawing1Rev() {
		return drawing1Rev;
	}

	public void setDrawing1Rev(String drawing1Rev) {
		this.drawing1Rev = drawing1Rev;
	}

	public String getDrawing1ApplicPages() {
		return drawing1ApplicPages;
	}

	public void setDrawing1ApplicPages(String drawing1ApplicPages) {
		this.drawing1ApplicPages = drawing1ApplicPages;
	}

	public String getTradeBoundary() {
		return tradeBoundary;
	}

	public void setTradeBoundary(String tradeBoundary) {
		this.tradeBoundary = tradeBoundary;
	}

	public long getXref() {
		return xref;
	}

	public String signingMessage() {
		return "Ripout [xref=" + xref + ", " + (xrefSeq != null ? "xrefSeq=" + xrefSeq + ", " : "") + "]";
	}

	@Override
	public String toString() {
		return "Ripout [xref=" + xref + ", " + (xrefSeq != null ? "xrefSeq=" + xrefSeq + ", " : "") + "nuclear="
				+ nuclear + ", " + (ripoutNo != null ? "ripoutNo=" + ripoutNo + ", " : "")
				+ (originator != null ? "originator=" + originator + ", " : "")
				+ (originationDate != null ? "originationDate=" + originationDate + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (workOrder != null ? "workOrder=" + workOrder + ", " : "")
				+ (wppn != null ? "wppn=" + wppn + ", " : "") + (sysComp != null ? "sysComp=" + sysComp + ", " : "")
				+ (psaNew != null ? "psaNew=" + psaNew + ", " : "") + (badge != null ? "badge=" + badge + ", " : "")
				+ (userid != null ? "userid=" + userid + ", " : "")
				+ (authDocType != null ? "authDocType=" + authDocType + ", " : "")
				+ (authDoc != null ? "authDoc=" + authDoc + ", " : "") + (ship != null ? "ship=" + ship + ", " : "")
				+ (leadTrade != null ? "leadTrade=" + leadTrade + ", " : "")
				+ (drawing1 != null ? "drawing1=" + drawing1 + ", " : "")
				+ (drawing1Rev != null ? "drawing1Rev=" + drawing1Rev + ", " : "")
				+ (drawing1ApplicPages != null ? "drawing1ApplicPages=" + drawing1ApplicPages + ", " : "")
				+ (tradeBoundary != null ? "tradeBoundary=" + tradeBoundary + ", " : "")
				+ (routing != null ? "routing=" + routing : "") + "]";
	}
}
