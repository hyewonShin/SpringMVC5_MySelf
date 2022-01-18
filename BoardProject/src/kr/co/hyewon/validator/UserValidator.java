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
		
		// 비밀번호 확인 
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
		
		// 아이디 중복확인
		if(userBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
		}
	}
}
