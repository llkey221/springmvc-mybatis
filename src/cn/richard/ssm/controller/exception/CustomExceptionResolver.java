package cn.richard.ssm.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

/**
 * 全局异常处理器
 * @author Richard
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

			
		CustomException customException=null;
		
		if(ex instanceof CustomException){
			customException=(CustomException)ex;
		}else{
			//记录异常，并声明为未知异常
			customException=new CustomException("未知异常");
		}
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message",customException.getMessage());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
