package kr.or.ddit.basetech.apater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.basetech.apater.metarial.Adaptee;
import kr.or.ddit.basetech.apater.metarial.Adapter;
import kr.or.ddit.basetech.apater.metarial.Client;
import kr.or.ddit.basetech.apater.metarial.OtherConcrte;

class AdapterPatternTest {

	@Test
	void test() {
		Client client = new Client();
		client.setTarget(new OtherConcrte());
		
		client.getTarget().request();
	}
	@Test
	void testUseAdaptee() {
		Client client = new Client();
		client.setTarget(new Adapter(new Adaptee()));
		
		client.getTarget().request();
	}
}
