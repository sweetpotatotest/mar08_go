package com.kgb4232.web.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AOPConfig {

	/*
	 * @Pointcut("execution(* com.kgb4232.web.controller.*.*(..))") public void
	 * cut() {
	 * 
	 * }
	 * 
	 * @Before("cut()") public void before(JoinPoint joinPoint) { MethodSignature
	 * methodSignature = (MethodSignature) joinPoint.getSignature();
	 * System.err.println("시작할때 : " + methodSignature.getName()); //실행 메소드명
	 * System.err.println("시작할때 : " + methodSignature.getMethod());
	 * 
	 * //파라미터 Object[] args = joinPoint.getArgs();
	 * System.out.println(Arrays.toString(args));
	 * 
	 * //파라미터 배열의 종류 값 for (Object object : args) { System.out.println("파라미터 타입 :" +
	 * object.getClass().getSimpleName()); System.out.println("파라미터 값 :" + object);
	 * } }
	 * 
	 * @After("cut()") public void after(JoinPoint joinPoint) { MethodSignature
	 * methodSignature = (MethodSignature) joinPoint.getSignature();
	 * System.err.print(methodSignature.getName()); //실행 메소드명
	 * System.err.println("메소드가 종료 되었습니다"); }
	 */
	
}
