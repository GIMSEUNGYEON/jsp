package kr.or.ddit.mission.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadFileVO {

	private MultipartFile[] uploadFile;
	
	public void setUploadFile(MultipartFile[] uploadFile) {
	
		this.uploadFile =  Arrays.stream(uploadFile)
							.filter(s->!s.isEmpty())
							.toArray(MultipartFile[]::new);
	}
}
