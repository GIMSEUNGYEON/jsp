package kr.or.ddit.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * 예외 : 프로그램의 실행 중 예측하지 않은 상태에서 발생하는 모든 상황에 대한 통칭
 * Throwable
 * 	1. Error : 시스템 디폴트 상황처럼 개발자가 코드로 해결할 수 없는 모든 상황.
 * 	2. Exception : 필요하다면 의도적으로 발생시킬 수도 있고 원하는 형태로 처리가 가능한 상황.
 * 		1) checked exception(Exception) : 처리하지 않으면 컴파일 에러 발생 (throw 혹은 try catch) ex) IOException, SQLException
 * 		2) uncheced exception(RuntimeException) : 직접 처리하지 않아도 자동으로 최종 JVM에게까지 전달(throw)되는 예외. 
 * 		ex) NullPointerException, ArithmeticException, IllegalArgumentException
 * 	처리가 가능하다는 공통점,  직접 처리해야하는 예외와 자동으로 처리되는 예외의 차이가 있다
 *
 *	*예외 처리
 *	1. 예외 회피 : throws, 호출자에게 예외를 떠넘기는 구조. 가장 상위 호출자는 JVM
 * 	
 * 	try(
 * 		with resource(closable)
 * 	){
 * 		예외 발생 코드
 * 	}catch(예외 타입 | 여 | 러 | 개 |... e){
 * 		예외 
 * 	}finally{
 * 		메소드 종료 전 (복귀 주소(호출지점)로 가기 전)
 * 	}
 * 
 *	2. 예외 전환 : 발생한 예외의 종류를 전혀 다른 형태의 예외로 변경
 *				(발생한 예외가 checked exception일 때 unchecked exception으로 전환)
 *
 *	3. 예외 복구 : 배치 처리에서 주로 활용됨. 예외에 의해 영향을 받은 코드를 복구가 될때까지 대기
 *	어플리케이션 처리 방식 : 실시간 처리 / 배치 처리
 * 	지금 당장 명령 / 구체적인 시간이 지정되는 스케쥴링이 포함된 처리(주로 대용량 데이터에 대해 처리됨)
 * 
 * custom exception 활용 구조.(throw)
 * 	1. 예외 클래스 정의(extends Exception : checked exception / extends RuntimeException : unchecked exception
 * 	2. throw new 예외 생성자
 * 
 */
public class ExceptionDesc {
	@Test
	void first() {
//		second();
		System.out.println("first method");
		try {
			
			StringBuffer sb= makeSb();
			System.out.println(sb.toString());
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("이유");
		}
	}
	
	StringBuffer makeSb() {
		return null;
	}
	
	private void second() {
		try {
			third();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("second method");
	}

	private void third() throws IOException {
		if(1==1) {
			throw new IOException("강제 발생 예외");
		}
		System.out.println("third method");
	}
}
