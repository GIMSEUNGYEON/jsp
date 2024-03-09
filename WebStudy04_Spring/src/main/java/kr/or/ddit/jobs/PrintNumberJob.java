package kr.or.ddit.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrintNumberJob {
	
	private int number = 1;
	
//	@Scheduled(cron = "0 0 3 * * MON")	
	public void printNumberPerSecond() {
		log.info("number : {}, thread name : {}", number++, Thread.currentThread().getName());
	}
	
//	멤버를 실제로 삭제하는 기능 구현해보기
//	memberDAO에 memDelete가 true인 사람 조회
//	true인 사람 
}
