package kr.or.ddit.payment;

import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.payment.controller.ReceiveCommandController;
import kr.or.ddit.payment.dao.SalaryDAO;
import kr.or.ddit.payment.service.PaymentService;
import kr.or.ddit.payment.view.PayMonthlyView;

public class HirarchyPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent 
//					= new GenericXmlApplicationContext("classpath:kr/or/ddit/payment/conf/hirarchy/parent-context.xml");
					= new AnnotationConfigApplicationContext(PaymentParentJavaConfiguration.class);
		ConfigurableApplicationContext child = new ClassPathXmlApplicationContext(new String [] {"classpath:kr/or/ddit/payment/conf/hirarchy/child-context.xml"}, parent);
		
		child.registerShutdownHook();
		
		child.getBean(ReceiveCommandController.class);
		
		child.getBean(PaymentService.class);
		
		child.getBean(PayMonthlyView.class);
		
		child.getBean(SalaryDAO.class);
		
		child.getBean(PayMonthlyView.class);
		
		
		parent.getBean(PaymentService.class);
		
//		parent.getBean(ReceiveCommandController.class);
		
//		parent.getBean(PayMonthlyView.class);
		
	}
}
