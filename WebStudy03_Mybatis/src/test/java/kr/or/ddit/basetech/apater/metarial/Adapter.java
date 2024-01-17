package kr.or.ddit.basetech.apater.metarial;

public class Adapter implements Target {

	private final Adaptee adaptee;
	
	
	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest();
	}
}
