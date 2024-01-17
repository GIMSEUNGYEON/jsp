package kr.or.ddit.log;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysoutVSLogger {
//	private static final Logger log = LoggerFactory.getLogger(SysoutVSLogger.class);
	
	@Test
	void testSysout() {
		byte[] array = new byte[1024000];
		for(int i = 0; i < array.length; i++) {
			array[i] = (byte)(Math.random() * 10);
		}
		System.out.println(Arrays.toString(array));
	}
	@Test
	void testLogging() {
		byte[] array = new byte[1024000];
		for(int i = 0; i < array.length; i++) {
			array[i] = (byte)(Math.random() * 10);
		}
		log.info("배열의 값 확인 : {}", array);
	}
}
