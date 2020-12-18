package com.springbook.biz.common;

public class Log4jAdvice {

    public Log4jAdvice() {
        System.out.println("===> Log4jAdvice 객체 생성");
    }

    public void printLogging() {
        System.out.println("[공통 로그-Log4j] 비즈니스 로직 수행 전 동작");
    }
}
