package kr.co.hyewon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.hyewon.bean.UserBean;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	//로그인 성공시 데이터를 담을 bean
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}

}
