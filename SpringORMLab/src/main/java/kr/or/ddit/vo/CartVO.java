package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"cartNo", "cartProd"})
public class CartVO implements Serializable {
	private String cartMember;
	private String cartNo;
	private String cartProd;
	private Integer cartQty;
	
	private ProdVO prod; // Has A 관계
}
