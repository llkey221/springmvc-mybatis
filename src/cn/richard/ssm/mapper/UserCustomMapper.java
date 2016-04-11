package cn.richard.ssm.mapper;

import cn.richard.ssm.po.UserCustom;

public interface UserCustomMapper {
	
	//根据用户名和密码查询用户信息
	public UserCustom findUserByNameAndPwd(UserCustom userCustom) throws Exception;
	//添加一条用户信息
	public int insertUser(UserCustom userCustom) throws Exception;
	
}
