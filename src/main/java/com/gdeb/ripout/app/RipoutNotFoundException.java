package main.java.com.gdeb.ripout.app;

class RipoutNotFoundException extends RuntimeException {

	RipoutNotFoundException(Long id) {
		super("No ripout " + id);
	}
}