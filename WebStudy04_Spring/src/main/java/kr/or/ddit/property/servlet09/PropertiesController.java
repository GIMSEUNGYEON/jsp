package kr.or.ddit.property.servlet09;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.vo.PropertyVO;
/**
 * 요청의 목적 : 서버사이드의 자원을 대상으로 어떤 행위를 수행하기 위함.
 * 자원의 식별(명사) : URI 
 * 어떤 행위(동사) : request method
 * RESTful URI 구조 표현 명사와 동사를 분리하는 구조
 * /09/property GET : 전체 조회
 * /09/property/propertyName GET : 한건 조회
 * /09/property POST : 등록
 * /09/property/propertyName PUT : 한건 수정
 * /09/property/propertyName DELETE : 한건 삭제
 * /09/property DELETE : 전체 삭제
 */
@RestController
@RequestMapping({"/09/property", "/09/property/*"})
public class PropertiesController {
	
	@Inject
	private PropertyService service;

	@GetMapping
	public Collection<PropertyVO> getAll() {
		
		return service.retrieveProperties();
	
	}

	@GetMapping("{propertyName}")
	public PropertyVO getOne(@PathVariable String propertyName) {	
		return service.retrieveProperty(propertyName);
	}

	@PostMapping
	public Map<String, Object> insert(@RequestBody PropertyVO newProp) {	
		return null;
	}

	@PutMapping("{propertyName}")
	public Map<String, Object> update(@RequestBody PropertyVO newProp) {	
		return null;
	}
	
	@DeleteMapping("{propertyName}")
	public Map<String, Object> delete(@PathVariable String propertyName) {	
		return null;
	}

}
