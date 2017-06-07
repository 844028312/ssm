package com.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.ssm.util.CryptographyUtil;
import com.ssm.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * ����ԱController��
 * @author 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	/**
	 * �û���¼
	 * @param blogger
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletResponse response)throws Exception{
		Subject subject=SecurityUtils.getSubject();
		User u=userService.getByUserName(user.getUserName());
		if(u==null){
			return null;
		}
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), CryptographyUtil.md5(user.getPassword(), u.getSalt()));
		JSONObject result=new JSONObject();
		try{
			subject.login(token); // ��¼��֤
		
			result.put("success", true);
		}catch(Exception e){
			result.put("success", false);
			result.put("errorInfo", "�û������������");
			e.printStackTrace();
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * �û�ע��
	 * @param blogger
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String register(User user,HttpServletResponse response)throws Exception{
		Subject subject=SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), CryptographyUtil.md5(user.getPassword(), "java1234"));
		JSONObject result=new JSONObject();
		try{
			subject.login(token); // ��¼��֤
		
			result.put("success", true);
		}catch(Exception e){
			result.put("success", false);
			result.put("errorInfo", "�û������������");
			e.printStackTrace();
		}
		ResponseUtil.write(response, result);
		return null;
	}

}
