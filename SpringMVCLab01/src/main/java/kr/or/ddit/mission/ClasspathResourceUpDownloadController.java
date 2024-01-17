package kr.or.ddit.mission;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.case10.vo.UploadFileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/files")
public class ClasspathResourceUpDownloadController {
	
	@Value("classpath:kr/or/ddit/images/")
	private Resource imageFolder;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("imageFolder : {}", imageFolder);
	}
	
	@GetMapping
	public String showList(Model model) throws IOException {
		
		File folder = imageFolder.getFile();
		String[] fileList = folder.list();
		
		for(String f : fileList) {
			log.info("{}", f);
		}
		
		model.addAttribute("fileList",fileList);
		
		return "mission/fileForm";
	}
	
	@PostMapping
	public String postHandler(
			@Valid @ModelAttribute("fileVO") UploadFileVO commandObject
			, BindingResult errors
			) throws IOException {
		
		log.info("uploadFile : {}", commandObject.getUploadFile());
		
		if(errors.hasErrors()) {
			return "mission/fileForm";
		}
		
		for(MultipartFile single : commandObject.getUploadFile()) {		
			
			if(single.isEmpty()) continue;
			
			String saveName = saveToResource(single, imageFolder);
			
			log.info("original file name : {}, save name : {}", single.getOriginalFilename(), saveName);
			
		}
		
		return "mission/fileForm";
	}
	
	
	private String saveToResource(MultipartFile single, Resource saveFolder) throws IOException {
		//저장 절차
		String saveName = UUID.randomUUID().toString();
		
		Resource saveFileResource = saveFolder.createRelative(saveName);
		File saveFile = saveFileResource.getFile();
		
		try(
			InputStream is = single.getInputStream();
		){
			FileUtils.copyInputStreamToFile(is, saveFile);
			return saveName;
		}
	}
}
