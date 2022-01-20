package kr.co.hyewon.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.hyewon.bean.BoardInfoBean;
import kr.co.hyewon.bean.UserBean;
import kr.co.hyewon.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {

	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService;
		this.loginUserBean = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		List<BoardInfoBean> topMenuList = topMenuService.getTopmenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		return true;
	}
	
}
 