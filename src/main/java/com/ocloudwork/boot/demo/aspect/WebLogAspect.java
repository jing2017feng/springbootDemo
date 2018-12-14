package com.ocloudwork.boot.demo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@ConfigurationProperties(prefix = "web.log")
public class WebLogAspect {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(public * com.ocloudwork.boot.demo.controller..*.*(..))")
	public void webLog() {
		throw new UnsupportedOperationException();
	}

	private boolean enableWebLog = false;

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint){
		if (!enableWebLog) {
			return;
		}
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info(Marker.ANY_MARKER, "URL : {0}", request.getRequestURL());
		logger.info(Marker.ANY_MARKER, "HTTP_METHOD : {0}", request.getMethod());
		logger.info(Marker.ANY_MARKER,"IP : {0}", request.getRemoteAddr());
		logger.info(Marker.ANY_MARKER,"CLASS_METHOD : {0}.{1}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		logger.info(Marker.ANY_MARKER,"ARGS : {0}", joinPoint.getArgs());

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret){
		if (!enableWebLog) {
			return;
		}
		// 处理完请求，返回内容
		logger.info(Marker.ANY_MARKER,"RESPONSE : {0}", ret);
	}

	public boolean isEnableWebLog() {
		return enableWebLog;
	}

	public void setEnableWebLog(boolean enableWebLog) {
		this.enableWebLog = enableWebLog;
	}

}