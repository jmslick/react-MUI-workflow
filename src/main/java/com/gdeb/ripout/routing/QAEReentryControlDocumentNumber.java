package main.java.com.gdeb.ripout.routing;

/**
 * @author jslick
 *
 */
public class QAEReentryControlDocumentNumber extends Routing {

	public QAEReentryControlDocumentNumber() {
		super(30, STATUS_NPUB, "QAEReentryControlDocumentNumber", "EBROQAE");
	}

	public String calculate() {
		return ROUTING_RIPOUT_UNDEFINED;
	}
}
