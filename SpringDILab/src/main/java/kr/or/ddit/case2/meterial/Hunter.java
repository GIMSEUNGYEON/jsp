package kr.or.ddit.case2.meterial;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Lazy(true)
public class Hunter {

	private Gun gun;

	public void hunting(){
		gun.attack();
	}
	
		
	public Hunter() {
		log.info("{} 객체 생성됨.", this.getClass().getSimpleName());
	}


//	public Hunter(Gun gun) {
//		super();
//		this.gun = gun;
//		log.info("{} 객체 생성 및 생성자로 {} 주입 완료.", this.getClass().getSimpleName(), gun.getClass().getSimpleName());
//	}
	
//	@Inject()
//	@Resource(name="shotGun")
	@Autowired
	@Named("shotGun")
	public void setGun(Gun gun) {
		this.gun = gun;
		log.info("setter {} 주입 완료.", gun.getClass().getSimpleName());
	}
}
