package kr.co.hyewon.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hyewon.bean.UserBean;
import kr.co.hyewon.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//로그인 성공시 데이터를 담을 bean
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	
	// 아이디 중복검사 
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
	
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	// 회원가입 정보 저장
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	// 로그인 
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {  //로그인 성공시 
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true); //UserLogin에 true를 넣어준다.
		}
	}
	
	// 정보수정 화면 사용자 정보 출력 
	public void getModifyUserInfo(UserBean modifyUserBean) {

		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(tempModifyUserBean.getUser_idx());
	}
	
	// 정보수정 - 업데이트
	public void modifyUserInfo(UserBean modifyUserBean) {
		
		//modifyUsreBean에 로그인된 사용자의 idx를 넣는다.
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.modifyUserInfo(modifyUserBean);
	}
}









