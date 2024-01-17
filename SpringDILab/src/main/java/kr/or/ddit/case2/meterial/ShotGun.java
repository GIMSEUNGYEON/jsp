package kr.or.ddit.case2.meterial;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("shotGun")
@DependsOn("bibitan")
@Lazy
public class ShotGun implements Gun {

	public ShotGun() {
		log.info("{} 객체 생성됨.", this.getClass().getSimpleName());
	}
	
	@Override
	public void attack() {
		log.info("{}로 공격해서 -1000의 데미지 입혔음", this.getClass().getSimpleName());
		
	}

}
