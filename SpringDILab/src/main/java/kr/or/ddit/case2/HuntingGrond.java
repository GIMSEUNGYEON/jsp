package kr.or.ddit.case2;


import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case2.conf.Case2JavaConfiguration;
import kr.or.ddit.case2.meterial.Bibitan;
import kr.or.ddit.case2.meterial.Gun;
import kr.or.ddit.case2.meterial.Hunter;
import kr.or.ddit.case2.meterial.ShotGun;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class HuntingGrond {
	public static void main(String[] args) throws InterruptedException {
		
		ConfigurableApplicationContext context 
//				= new GenericXmlApplicationContext("classpath:kr/or/ddit/case2/conf/case2_context2.xml");
				= new AnnotationConfigApplicationContext(Case2JavaConfiguration.class);
		//generic : xml 파일의 위치가 고정되어 있지 않음. 컴파일 시점엔 정해지지 않고 런타임에 고정됨
		context.registerShutdownHook();
		
		Hunter hunter = context.getBean(Hunter.class);
		LocalDateTime now = context.getBean(LocalDateTime.class);
		log.info("공격 시점 : {}",now);
		hunter.hunting();
		
		Thread.sleep(1000);

		Gun gun = (context.getBean(Bibitan.class));
//		Gun gun = context.getBean(Gun.class, "bibitan");
		hunter.setGun(gun);
		hunter.hunting();
		now = context.getBean(LocalDateTime.class);
		log.info("공격 시점 : {}",now);

		Thread.sleep(1000);

		gun = context.getBean(ShotGun.class);
		hunter.setGun(gun);
		hunter.hunting();
		now = context.getBean(LocalDateTime.class);
		log.info("공격 시점 : {}",now);
		
	}
}
