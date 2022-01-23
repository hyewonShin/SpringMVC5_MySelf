package kr.co.hyewon.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.hyewon.bean.ContentBean;

public interface BoardMapper {

	// 글 작성 페이지 정보를 서버에 저장 
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
}

//#{content_file, jdbcType=VARCHAR}
//NULL이 허용되는 컬럼에 jdbcType=VARCHAR을 붙여줘야 된다.