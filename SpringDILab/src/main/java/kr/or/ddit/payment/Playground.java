package kr.or.ddit.payment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.payment.controller.ReceiveCommandController;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Playground {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/payment/conf/payment-autodi.xml");
		
		context.registerShutdownHook();
		// 종료할 수 있는 조건
		ReceiveCommandController controller = context.getBean(ReceiveCommandController.class);
		
		String empCode = "a001";
		
		String payStub = controller.receiveCommand(empCode);
		
		log.info("급여명세서 : {}", payStub);
		
	}
}
