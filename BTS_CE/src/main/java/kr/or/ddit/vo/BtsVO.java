package kr.or.ddit.vo;

import java.io.Serializable;

/**
 *  하나의 MBTI 유형에 대한 정보를 캡슐화한 객체(VO, (Java)Bean, DTO(Data Transfer Object), Model, Info).
 * 
 *  자바빈 규약
 *  1. 값을 저장할 수 있는 프로퍼티
 *  2. 프로퍼티에 대한 캡슐화
 *  3. 캡슐화된 프로퍼티에 대해 인터페이스 지원(getter/setter) : get[set]프로퍼티네임의 첫글자를 대문자로한 프로퍼티명(capitalized property name)
 *  4. 프로퍼티 상태 확인 인터페이스 지원(toString)
 *  5. 객체의 상태를 비교할 수 있는 인터페이스 지원(equals,compareTo)
 *  6. 직렬화 지원.
 *
 */
public class BtsVO implements Serializable{
	
	public BtsVO() {
	      super();
	   }
	   
	public BtsVO(String name, String title, String logicalPath) {
	      super();
	      this.name = name;
	      this.title = title;
	      this.logicalPath = logicalPath;
	   }
	
	private String name;
	private String title;
	private String logicalPath;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogicalPath() {
		return logicalPath;
	}
	public void setLogicalPath(String logicalPath) {
		this.logicalPath = logicalPath;
	}
	
	@Override
	public String toString() {
		return "BtsVO [name=" + name + ", title=" + title + ", logicalPath=" + logicalPath + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BtsVO other = (BtsVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
