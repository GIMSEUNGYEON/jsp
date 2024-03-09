package kr.or.ddit.vo;

import java.io.Serializable;

/**
 * 하나의 MBTI 유형에 대한 정보를 캡슐화한 객체(VO, JavaBean, DataTransferObject, Model, Info).
 * 
 * 자바빈 규약
 * 1. 값을 저장할 수 있는 프로퍼티 제공
 * 2. 프로퍼티에 대한 캡슐화
 * 3. 캡슐화된 프로퍼티에 대해 인터페이스 지원(getter/setter) : get[set]프로퍼티네임의 첫글자를 대문자로한 프로퍼티명(capitalized property name)
 * 4. 프로퍼티 상태 확인 인터페이스 지원(toString)
 * 5. 객체의 상태를 비교할 수 있는 인터페이스 지원(equals, compareTo)
 * 6. 직렬화 지원.
 *
 */
public class MbtiDescVO implements Serializable{
	private int mtSort;
	private String mtType;
	private String mtTitle;
	private String mtContent;
	public int getMtSort() {
		return mtSort;
	}
	public void setMtSort(int mtSort) {
		this.mtSort = mtSort;
	}
	public String getMtType() {
		return mtType;
	}
	public void setMtType(String mtType) {
		this.mtType = mtType;
	}
	public String getMtTitle() {
		return mtTitle;
	}
	public void setMtTitle(String mtTitle) {
		this.mtTitle = mtTitle;
	}
	public String getMtContent() {
		return mtContent;
	}
	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}
	@Override
	public String toString() {
		return "MbtiDescVO [mtSort=" + mtSort + ", mtType=" + mtType + ", mtTitle=" + mtTitle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mtType == null) ? 0 : mtType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MbtiDescVO other = (MbtiDescVO) obj;
		if (mtType == null) {
			if (other.mtType != null)
				return false;
		} else if (!mtType.equals(other.mtType))
			return false;
		return true;
	}
	
}

















