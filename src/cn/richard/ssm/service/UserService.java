package cn.richard.ssm.service;

import cn.richard.ssm.po.UserCustom;

public interface UserService {
	
	public UserCustom getUserByName(String name,String password) throws Exception;
	
	public int registerUser(UserCustom userCustom)throws Exception;
	
}
