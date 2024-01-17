package kr.or.ddit.vo;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 카드 발송 관리 Domain Layer
 *
 */
@Data
@EqualsAndHashCode(of="xcNo")
@NoArgsConstructor
@ToString
public class XmasCardVO {
	
	public XmasCardVO(String xcSender, String xcReciver, String xcTitle,String xcContent, LocalDate xcDate) {
		this.xcSender = xcSender;
		this.xcReciver = xcReciver;
		this.xcTitle = xcTitle;
		this.xcContent = xcContent;
		this.xcDate = xcDate;		
	}
	
	private int xcNo;
	private String xcSender;
	private String xcReciver;
	private String xcTitle;
	private String xcContent;
	private LocalDate xcDate;

	
}
