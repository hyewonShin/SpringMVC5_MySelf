package kr.co.hyewon.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hyewon.bean.ContentBean;
import kr.co.hyewon.bean.UserBean;
import kr.co.hyewon.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;

	@Autowired
	private BoardDao boardDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// 파일 저장하는 메서드 (현재시각을 붙여줘 중복파일 덮어쓰임 방지)
	private String saveUploadFile(MultipartFile upload_file) {

		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();

		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}

	public void addContentInfo(ContentBean writeContentBean) {

		MultipartFile upload_file = writeContentBean.getUpload_file();

		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}

		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());

		boardDao.addContentInfo(writeContentBean);
	}
}