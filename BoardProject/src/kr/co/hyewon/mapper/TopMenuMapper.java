package kr.co.hyewon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.hyewon.bean.BoardInfoBean;

public interface TopMenuMapper {

	//상단메뉴 게시판 이름 데이터베이스에서 가져오기 
	@Select("select board_info_idx, board_info_name " +
			"from board_info_table " +
			"order by board_info_idx")
	List<BoardInfoBean> getTopmenuList();
}
