package kr.co.hyewon.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.hyewon.bean.UserBean;

public interface UserMapper {

	@Insert("insert into user_table (user_idx, user_id, user_name, user_pw) " +
			"values (user_seq.nextval, #{user_id}, #{user_name}, #{user_pw})" )
	void addUserInfo(UserBean joinUserBean);
	
}
