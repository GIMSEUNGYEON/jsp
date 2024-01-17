package kr.or.ddit.case2.meterial;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("prototype")
@Lazy
public class Bibitan implements Gun {
	
	public Bibitan() {
		log.info("{} 객체 생성됨.", this.getClass().getSimpleName());
	}

	@Override
	public void attack() {
		log.info("{}로 공격해서 -10 데미지 입혔음.", this.getClass().getSimpleName());
		
	}

}
