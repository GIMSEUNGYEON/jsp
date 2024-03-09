package kr.or.ddit.mission;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.function.Failable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.case10.vo.UploadFileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/file")
public class ClasspathResourceUpDownloadController {
	
	@Value("classpath:/kr/or/ddit/images/")
	private Resource imageFolder;
	
	@GetMapping
	public String formUI() {
		return "mission/fileForm";
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String[] getImageList() throws IOException {
		return imageFolder.getFile().list();
	}
	
	
	@GetMapping("{name}")
	public ResponseEntity<Resource> getFile(@PathVariable String name) throws IOException {
	
		Resource imageFile = imageFolder.createRelative(name);
		
		if(!imageFile.exists()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s 그런 파일 없음", name));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(imageFile.contentLength());
		headers.setContentDisposition(ContentDisposition.attachment()
														.filename(name, Charset.forName("UTF-8"))
														.build());
		
		return ResponseEntity.ok()
							 .headers(headers)
							 .body(imageFile);	
	}
	
	@PostMapping
	public String uploadFiles(@RequestPart MultipartFile [] uploadFile) throws IOException {
		File imageFolerFile = imageFolder.getFile();
	
		Arrays.stream(uploadFile)
			  .filter(f->!f.isEmpty())
			  .forEach(Failable.asConsumer(f->{
				  File newFile = new File(imageFolerFile,f.getOriginalFilename());
				  f.transferTo(newFile);
			  }));
		return "redirect:/mission/file";
	}
}
