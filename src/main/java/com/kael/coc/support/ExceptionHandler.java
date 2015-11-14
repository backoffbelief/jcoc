package com.kael.coc.support;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ExceptionHandler implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Map<String, Object> ret = null;
		try {
			ret = (Map<String, Object>) invocation.proceed();
			ret.put("status", ErrorCode.success);
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = new HashMap<>();
			ret.put("status", ErrorCode.error);
			if(ex instanceof BusinessException){
				ret.put("errcode", ((BusinessException)ex).getErrorCode());
			}else{
				ret.put("errcode", ErrorCode.error);
			}
		}
		return ret;
	}


}
