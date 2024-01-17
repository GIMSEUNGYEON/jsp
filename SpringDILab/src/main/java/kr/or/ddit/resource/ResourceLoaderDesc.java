package kr.or.ddit.resource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

/**
 * {@link Resource} : 모든 종류의 자원에 대한 접근 방법을 추상화시켜놓은 타입.
 * {@link ResourceLoader} : 자원을 검색하고 메모리에 로딩하는 객체
 * 1. 파일 시스템 자원 : D:/01.medias/img/hamster.jpg 물리
 * 2. 클래스패스 자원  : kr/or/ddit/db/dbInfo.properties 논리
 * 3. 웹 자원        : https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png 논리
 *
 */
@Slf4j
public class ResourceLoaderDesc {
	public static void main(String[] args) throws MalformedURLException {
		File fileSystemFile = new File("D:/01.medias/img/hamster.jpg");
		
		String realPath = ResourceLoaderDesc.class.getResource("/kr/or/ddit/db/dbInfo.properties").getFile();
		File classPathFile = new File(realPath);
	
		URL url = new URL("https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/resource/conf/resource-context.xml");
		
		context.registerShutdownHook();
		
		Resource fileSystemResource = context.getResource("file:D:/01.medias/img/hamster.jpg");
		Resource classpathResource = context.getResource("classpath:kr/or/ddit/db/dbInfo.properties");
		Resource webResource = context.getResource("https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		
		log.info("file system resource : {}", fileSystemResource);
		log.info("class path resource : {}", classpathResource);
		log.info("web resource : {}", webResource);
		
		VariousVO vo = context.getBean(VariousVO.class);
		
		log.info("주입 결과 : {}", vo);
		
		OtherVariousVO vo2 = context.getBean(OtherVariousVO.class);
		
		log.info("주입 결과 : {}", vo2);
		
		
	}
}
