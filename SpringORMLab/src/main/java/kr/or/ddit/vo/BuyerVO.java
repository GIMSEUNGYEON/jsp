package kr.or.ddit.vo;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.constraints.TelNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="buyerId")
public class BuyerVO {
	@NotBlank(groups = {UpdateGroup.class, DeleteGroup.class})
	private String buyerId;
	@NotBlank
	private String buyerName;	
	@NotBlank
	private String buyerLgu;
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	@TelNumber
	private String buyerComtel;
	private String buyerFax;
	@NotBlank
	@Email
	private String buyerMail;
	private String buyerCharger;
	private String buyerTelext;
	private String buyerMail2;
	private String buyerCharger2;
	private String buyerTelext2;
	private int rnum;
	//Has A 관계 - 1:1
	private Map<String, Object> lprod;
	
	//Has Many 관계 - 1:N collection
	private List<ProdVO> prodList; // 제조사와의 거래 품목
	
}
