package kr.or.ddit.cstmr.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.RegistVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MberAuthServiceTest extends AbstractRootContextTest {

	@Inject
	MberAuthService service;

	@Test
	void test() {
		RegistVO newMber = new RegistVO();
		newMber.setCstNm("김춘자");
		newMber.setCstHp("010-5435-3580");
//		newMber.setMberId("sujin06@hanmail.net");
		newMber.setMberId("sujin06");
		newMber.setMberPw("asdf");
		newMber.setMberAddr("asdf");
		newMber.setMberDetailAddr("jkl");
		newMber.setCstBirth(LocalDate.now());
		newMber.setCstGen("F");
		ServiceResult result = service.createNewMber(newMber);
	
		log.info("{}", result);
	}	

}
