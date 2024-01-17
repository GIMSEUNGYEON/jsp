package kr.or.ddit.case7;

import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.case7.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case7/formDataBind")
public class FormDataBindController {
	/**
	 * spring:form 커스텀 태그를 사용하기 위해 modelAttribute가 반드시 전달되어야함.
	 * 커스텀 태그의 path 속성은 modelAttribute로 전달되는 커맨드 오브젝트의 프로퍼티 경로가 그대로 반영됨.
	 * ex)sampleVO has a HasAInnerVO : inner => path="inner.innerParam1"
	 * ex)sampleVO has many HasManyInnerVO : innerList => path="innerList[0].innerParam3"
	 * SampleVO의 일반 프로퍼티 => path="strParam"
	 * @param sample
	 * @return
	 */
	@GetMapping
	public String formUI(@ModelAttribute("sample") SampleVO sample) {
		
		return "case7/formView2";
	}
	
	/**
	 * post 핸들러를 통해 커맨드 오브젝트를 사용할 떄,
	 * 검증을 하는 단계
	 * 1. command object에 검증룰을 어노테이션으로 설정.(has 관계를 가진 vo를 객체로 가진다면 valid 어노테이션 이용
	 * 2. 핸들러 메소드에서 커맨드 오브젝트를 아규먼트로 받을 때, @Valid 사용.
	 * 3. 검증 대상이 되는 커맨드 오브젝트 다음에 Errors 아규먼트를 설정해야함.
	 * 	  없는 경우, 400 에러가 발생함.
	 * @param sample
	 * @param errors
	 * @return
	 */
	@PostMapping
	public String formProcess(
			@Validated({InsertGroup.class, Default.class}) @ModelAttribute("sample") SampleVO sample
//			, @RequestHeader(required = false) String accept // 커맨드 오브젝트와 errors 사이에 아규먼트가 들어가면 안됨!!
			, Errors errors) {
		if(errors.hasErrors()) {
			return "case7/formView2";
		}else {
			log.info("검증 통과, logic 사용");
			return null;
		}
	}
}
