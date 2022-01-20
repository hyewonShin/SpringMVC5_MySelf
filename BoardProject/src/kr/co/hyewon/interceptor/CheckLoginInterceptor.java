package kr.co.hyewon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.hyewon.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(loginUserBean.isUserLogin() == false) {  //로그아웃 상태일때 
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			return false; 
		}
		
		return true;  // 로그인상태라면 다음단계인 controller로 이동
	}
	
}
