package kr.or.ddit.validate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberVOValidateTest {

	static Validator validator;
	
	@BeforeAll
	static void setUpClass() {
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory(); 
//		validator = validatorFactory.getValidator();
		validator = Validation.byDefaultProvider()
		        .configure()
		        .messageInterpolator(
		                new ResourceBundleMessageInterpolator(
		                        new PlatformResourceBundleLocator( "kr.or.ddit.message.ErrorMessages" )
		                )
		        )
		        .buildValidatorFactory()
		        .getValidator();
	}
	
	@Test
	void testMessageBundle() {
		String baseName = "org.hibernate.validator.ValidationMessages";
		ResourceBundle messageBundle = ResourceBundle.getBundle(baseName);
		log.info("message : {}", messageBundle.getString("javax.validation.constraints.NotBlank.message"));
	}
	
	@Test
	void test() {
		MemberVO target = new MemberVO();
//		target.setMemId("a001");
//		target.setMemPass("12");
//		target.setMemMail("dummy");
//		target.setMemAdd1("대전");
//		target.setMemRegno1("1234567");
		target.setMemHp("000-0000-1111");
		Set<ConstraintViolation<MemberVO>> constraintViolations = validator.validate(target, UpdateGroup.class);
		log.info("검증 통과 여부 : {}", constraintViolations.isEmpty());
		log.info("검증을 통과하지 못한 프로퍼티 수 : {}", constraintViolations.size());
		
		constraintViolations.stream()
			.forEach(v->{
				log.info("{} : {}", v.getPropertyPath().toString(), v.getMessage());
			});
		Map<String, String> errors = constraintViolations.stream()
										.collect(Collectors.toMap(v->{return v.getPropertyPath().toString();},v->{return v.getMessage();}));
		
		log.info("{}", errors);
	}
	
}
