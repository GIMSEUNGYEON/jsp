package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="memId")
public class MemberVO implements Serializable {
	private String memId;
	private String memPass;
	private String memName;
	private String memMail;
	
	private List<String> memRoles;
}
