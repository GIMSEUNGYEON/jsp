package kr.or.ddit.emp.myinfo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.emp.myinfo.service.EmpMyInfoService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/myInfo")
public class EmpMyInfoUpdateController {
	
	@Inject
	private EmpMyInfoService service;
	
	@Value("#{appInfo.empProfPath}")
	private Resource saveFolder;
	
//	,  produces = MediaType.APPLICATION_JSON_VALUE
	@PostMapping(value = "updateMyInfo.do")
	@ResponseBody
	public Map<String, Object> updateMyInfo(
		@ModelAttribute("empVO") EmpVO emp
		, BindingResult errors
	) throws IOException {
		
		Map<String, Object> jsonData = new HashMap<>();
		MultipartFile file = emp.getProflImg();
		if(!file.isEmpty()) {
			String saveName = saveToResource(file, saveFolder);
			log.info("기존 파일 이름 : {}, 저장할 이름 : {}", file.getOriginalFilename(), saveName);
			emp.setEmpProflNm(file.getOriginalFilename());
			emp.setEmpProflUuid(saveName);
		}
		ServiceResult result = service.modifyInfo(emp);
		log.info("result : {}", result);
		switch (result) {
		case OK:
			jsonData.put("message", "ok");
			break;

		default:
			jsonData.put("message", "error");
			break;
		}
		
		return jsonData;
	}
	
	private String saveToResource(MultipartFile file, Resource saveFolder) throws IOException {
		String saveName = UUID.randomUUID().toString();
		
		Resource saveFileResource = saveFolder.createRelative(saveName);
		File saveFile = saveFileResource.getFile();
		
		try(
			InputStream is = file.getInputStream();
		){
			FileUtils.copyInputStreamToFile(is, saveFile);
			
			return saveName;
		}
	}
}
