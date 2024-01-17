package kr.or.ddit.case1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/**
 * 0. 의존관계가 필요한 foo에 setter 혹은 constructor 생성
1. context 파일에 bean 등록 bar, baz, foo
2. bean 사이의 의존관계 등록 foo --> bar, baz
3. containerDesc 에서 context 호출, xml 파일 경로 넘겨주기
4. containerDesc에서 context에서 foo 인스턴스 꺼내오기
5. containderDesc에서 foo인스턴스의 toString 호출
6. context 닫는 시점 예약
 */
@Data
@Repository
@Slf4j
public class Foo {
	// 필수 전략
	private Bar bar = new Bar();
	// optional
//	@Autowired
	private Baz baz;

	public Foo(Bar bar) {
		super();
		this.bar = bar;
	}

	@Required
//	@Resource(name = "baz")
	@Inject
	@Named("baz")
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
	@PostConstruct
	public void init5904() {
		log.info("주입된 결과 ==> {}, {}", bar, baz);
	}
}
