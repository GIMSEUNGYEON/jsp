package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="stdNo")
public class ClassVO implements Serializable{

	private String stdNo;
	private String subCd;
	private Integer clsScore;
}
