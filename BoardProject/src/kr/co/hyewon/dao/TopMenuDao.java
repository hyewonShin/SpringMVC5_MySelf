package kr.co.hyewon.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hyewon.bean.BoardInfoBean;
import kr.co.hyewon.mapper.TopMenuMapper;

@Repository
public class TopMenuDao {

	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoBean> getTopmenuList(){
		List<BoardInfoBean> topMenuList = topMenuMapper.getTopmenuList();
		return topMenuList;
	}
}
