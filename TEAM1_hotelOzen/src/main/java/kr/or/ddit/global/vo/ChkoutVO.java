package kr.or.ddit.global.vo;

import lombok.Data;

@Data
public class ChkoutVO {
	
	private String rnum;
	
	private String chkinNo;
	private String coExcclcYn;
	private Integer coExcclcAmnt;
	private String coSetleNo;
	private String coDt;
	
	private ChkinVO chkin;
}