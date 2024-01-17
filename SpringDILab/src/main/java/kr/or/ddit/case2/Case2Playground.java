package kr.or.ddit.case2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case2.conf.Case2JavaConfiguration;
import kr.or.ddit.case2.meterial.Gun;
import kr.or.ddit.case2.meterial.Hunter;
import kr.or.ddit.case2.meterial.ShotGun;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case2Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context 
//			= new GenericXmlApplicationContext("classpath:kr/or/ddit/case2/conf/case2-context3.xml");
			= new AnnotationConfigApplicationContext(Case2JavaConfiguration.class);
		context.registerShutdownHook();
		
		Hunter hunter1 = context.getBean(Hunter.class);
		
		hunter1.hunting();
//		
//		Hunter hunter2 = context.getBean(Hunter.class);
//		
//		log.info("hunter1 == hunter2 : {}", hunter1 == hunter2);
		
		
	}
}
