package kr.co.hyewon.validator;

import javax.validation.Validator;

import org.springframework.validation.Errors;

import kr.co.hyewon.bean.UserBean;

public class UserValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserBean userBean = (UserBean)target;

		String beanName = errors.getObjectName();

		// 회원가입, 정보수정에서 비밀번호 재확인 
		if(beanName.equals("joinUserBean")|| beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		}
		
		// 아이디 중복확인
		if(beanName.equals("joinUserBean")) {
		
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
			}
		}
	}
}