package kr.or.ddit.case2.conf;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case2.meterial.Bibitan;
import kr.or.ddit.case2.meterial.Hunter;
import kr.or.ddit.case2.meterial.ShotGun;

@Configuration
@ComponentScan("kr.or.ddit.case2.meterial")
public class Case2JavaConfiguration {
	
//	@Bean
//	@Scope("prototype")
//	public Bibitan bibitan() {
//		return new Bibitan();
//	}
//	
//	@Bean
//	@Scope("prototype")
//	@DependsOn("bibitan")
//	public ShotGun shotGun() {
//		return new ShotGun();
//	}
//	
//	@Bean
//	public Hunter hunter() {
//		return new Hunter();
//	}
	
	@Bean
	@Scope("prototype")
	public LocalDateTime localDateTime() {
		return LocalDateTime.now();
	}
}
