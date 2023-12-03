package kr.or.ddit.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;

import kr.or.ddit.servlet08.ServerTimeServlet;

class PropertiesFileReadTest {

	@Test
	void test() throws IOException, URISyntaxException {
		Properties properties = new Properties();
		String logicalPath = "/kr/or/ddit/message/message-common.properties";
		URL realPath = ServerTimeServlet.class.getResource(logicalPath);
		File file = new File(realPath.toURI());
		
		try(
			FileInputStream fis = new FileInputStream(file);
		){
			properties.load(fis);
			System.out.println(properties.size());
			properties.forEach((n,v)->{
				System.out.printf("%s : %s\n", n, v);
			});
		properties.setProperty("newProp", "newValue");
		// 프로퍼티에 내용을 추가할 수도 있으나, 이런 방법으로는 데이터가 저장되지 않으므로 별도의 outputstream 필요
		//store 메서드 이용
		}
		
	}
	@Test
	void testResouceBundle() {
		String baseName = "kr/or/ddit/message/message-common";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
		//읽기 전용
		bundle.keySet().forEach((mc)->{
			System.out.printf("%s : %s\n", mc, bundle.getString(mc));
		});
	}

}
