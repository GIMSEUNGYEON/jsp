package kr.or.ddit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 주소록 관리 Domain Layer
 * primary key는 ADS_NO
 *
 */
@Data
@EqualsAndHashCode(of= {"adrsNo"})
@NoArgsConstructor
@ToString
public class AddressVO {
	// 번호는 시퀀스로 자동생성, 오너는 로그인한 사용자의 정보, 나머지는 파라미터로 직접 작성할 것
	public AddressVO(String adrsOwner, String adrsName,String adrsHp, String adrsZip,String adrsAdd1,String adrsAdd2) {		
		this.adrsOwner = adrsOwner;
		this.adrsName = adrsName;
		this.adrsHp = adrsHp;
		this.adrsZip = adrsZip;
		this.adrsAdd1 = adrsAdd1;
		this.adrsAdd2 = adrsAdd2;
	}
	
	private int adrsNo;
	private String adrsOwner;
	private String adrsName;
	private String adrsHp;
	private String adrsZip;
	private String adrsAdd1;
	private String adrsAdd2;

}
