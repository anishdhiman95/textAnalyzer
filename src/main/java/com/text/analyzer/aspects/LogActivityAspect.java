package com.text.analyzer.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class contains the core logic of the Logging Aspect.
 * 
 * @author anishdhiman95
 */
@Aspect
@Component
public class LogActivityAspect {

	/**
	 * Aspect Method for Logging. The poincut here is @Around for based on the
	 * annotation 'LogActivity'.
	 * 
	 * @param joinPoint
	 * @param logActivity
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(logActivity)")
	public Object around(ProceedingJoinPoint joinPoint, LogActivity logActivity) throws Throwable {

		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info(logActivity.value() + " Started");
		Object obj = null;
		obj = joinPoint.proceed();
		logger.info(logActivity.value() + " Completed");

		return obj;
	}
}
