package kr.co.hyewon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import kr.co.hyewon.bean.ContentBean;

public interface BoardMapper {

	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)
	
	// 글 작성 페이지 정보를 서버에 저장 
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	//#{content_file, jdbcType=VARCHAR}
	//NULL이 허용되는 컬럼에 jdbcType=VARCHAR을 붙여줘야 된다.

	
	// 상단메뉴 게시판이름 출력 
	@Select("select board_info_name " + 
			"from board_info_table " + 
			"where board_info_idx = #{board_info_idx}")
	String getBaordInfoName(int board_info_idx);
	
	// 글목록 데이터 출력 
	@Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name, " +
			"		to_char(a1.content_date,'YYYY-MM-DD') as content_date " + 
			"from content_table a1, user_table a2 " + 
			"where a1.content_writer_idx = a2.user_idx " + 
			"    and a1.content_board_idx = #{board_info_idx} " + 
			"order by a1.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx);

	// 글 읽는 페이지 데이터 출력 
	@Select("select a2.user_name as content_writer_name, " + 
			"       to_char(a1.content_date, 'YYYY-MM-DD') as content_date, " + 
			"       a1.content_subject, a1.content_text, a1.content_file, a1.content_writer_idx " + 
			"from content_table a1, user_table a2 " + 
			"where a1.content_writer_idx = a2.user_idx " + 
			"      and content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);

}

	
















	
	