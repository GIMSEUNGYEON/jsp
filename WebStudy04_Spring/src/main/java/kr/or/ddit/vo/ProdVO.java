package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.ToString.Exclude;

/**
 * 상품관리 Domain Layer
 * 
 */
@Data
@ToString
@EqualsAndHashCode(of="prodId")
public class ProdVO implements Serializable {
	private int rnum;
	@NotBlank(groups = {UpdateGroup.class, DeleteGroup.class})
	private String prodId;
	@NotBlank
	@Size(max = 20)
	private String prodName;
	@NotBlank(groups = InsertGroup.class)
	private String prodLgu;
	@NotBlank(groups = InsertGroup.class)
	private String prodBuyer;
	@NotNull
	@Min(0)
	private Integer prodCost;
	@NotNull
	@Min(0)
	private Integer prodPrice;
	@NotNull
	@Min(0)
	private Integer prodSale;
	@NotBlank
	private String prodOutline;
	@ToString.Exclude
	private String prodDetail;
	@NotBlank(groups = InsertGroup.class)
	private String prodImg; // prod 엔터티의 정보 바인드용	
	@NotNull(groups = InsertGroup.class)
	private MultipartFile prodImage; // client 전송 파일 바인드용
	@NotNull
	@Min(0)
	private Integer prodTotalstock;
	private LocalDate prodInsdate;
	@NotNull
	@Min(0)
	private Integer prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Integer prodQtyin;
	private Integer prodQtysale;
	private Integer prodMileage;
	
	private Map<String, Object> lprod; 
	// 1:1관계 바인딩 -> Has A 관계 association 엘리먼트로 바인딩
	// 1:N 관계 바인딩 -> Has Many 관계, collection 엘리먼트로 바인딩
	private BuyerVO buyer;

	public void setProdImage(MultipartFile prodImage) {
		if(prodImage == null || prodImage.isEmpty()) return;
		
		this.prodImg = UUID.randomUUID().toString();
		this.prodImage = prodImage;
	}
}
