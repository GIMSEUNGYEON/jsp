package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.MberNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MberNoticeMapperTest extends AbstractRootContextTest{

	@Inject
	private MberNoticeMapper dao; 

	@Test
	void test() {
//		List<MberNoticeVO> memNotice = dao.MberNoticeList();
//		log.info("notice {}", memNotice);
	}
	
	@Test
	void testView() {
//		MberNoticeVO mbernt = dao.MberNoticeView("NNT0011");
//		log.info("mberNotice {}", mbernt);
	}
}
