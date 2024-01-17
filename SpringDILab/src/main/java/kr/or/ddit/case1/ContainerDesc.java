package kr.or.ddit.case1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case1.conf.Case1JavaConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * IoC Container, DI Container, Bean Container 사용단계
 * 1. pom.xml에 spring-context 의존성 추가
 * 2. spring bean configuration file (bean metadata file)생성
 * 	1) bean 등록 : bean -> class, id, ...
 * 	2) 등록된 bean들 간의 관계 형성을 위한 주입 설정.
 * 		- setter injection : property -> name(setter 종류 결정), ref(injection 대상 결정)
 * 		- constructor injection(필수 전략인 경우 추천) : constructor-arg -> name(생성자의 파라미터 결정), ref(injection 대상 결정)
 * 3. application entry point에서 컨테이너 객체 생성 -> new 키워드 사용
 * 4. getBean의 형태로 컨테이너 내부의 빈을 주입받아 사용함.
 * 5. 어플리케이션 엔드 포인트에서 컨테이너 종료 작업. -> registerShutdownHook 종료조건을 설정할 수 있는 스레드 예약
 * 어플리케이션과 동일한 컨테이너의 생명주기
 * 
 */
@Slf4j
public class ContainerDesc {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
//			new ClassPathXmlApplicationContext("kr/or/ddit/case1/conf/case1-context.xml");
//			new FileSystemXmlApplicationContext("D:/case1-context.xml");
//			new GenericXmlApplicationContext("file:d:/case1-context.xml");
//			new GenericXmlApplicationContext("classpath:kr/or/ddit/case1/conf/case1-context.xml");
			new AnnotationConfigApplicationContext(Case1JavaConfiguration.class);
		Foo foo = context.getBean(Foo.class);
		
		log.info("주입된 foo : {}", foo.toString());
		
		context.registerShutdownHook();
		
		
	}
}
