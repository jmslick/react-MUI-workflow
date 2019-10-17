package com.gdeb.ripout.routing;

/**
 * @author admin
 *
 */
public abstract class Routing {
	protected int id;
	protected String name;
	protected String role;

	public Routing(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Routing calculate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Routing [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
}
