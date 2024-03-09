package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "setleNo")
public class SetleVO {

	private String setleCardNm;
	private String setleCardNumber;
	private String setleImpUid;
	private String setleMerchantUid;
	private String setleNo;
	private String cstNo;
	private String setleYmd;
	private String setlePayMethod;
}
