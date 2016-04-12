package cn.richard.ssm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import cn.richard.ssm.mapper.UserCustomMapper;
import cn.richard.ssm.po.User;
import cn.richard.ssm.po.UserCustom;
import cn.richard.ssm.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserCustomMapper userCustomMapper;

	@Override
	public UserCustom getUserByName(String name, String password) throws Exception {
		UserCustom userCustom =new UserCustom();
		userCustom.setUsername(name);
		
		userCustom=userCustomMapper.findUserByNameAndPwd(userCustom);
		return userCustom;
	}

	@Override
	public int registerUser(UserCustom userCustom) throws Exception {
		
		int count =userCustomMapper.insertUser(userCustom);
		
		return count;
	}
	


}
