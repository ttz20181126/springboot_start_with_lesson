package com.learn.springboot.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * springboot处理异常方式一：自定义错误页面。
 */
public class ExceptionController {


    /**
     * 出现错误，向/error请求，springboot的BasicExceptionController处理请求
     * ~~~~~~默认的错误页面对用户不太友好  --》 解决:在templates下建立error.html ~~~~~~~~~~~~
     * @return
     */
    @RequestMapping("/defaultExceptionPage")
    public String defaultExceptionPage(){
        String str = null;
        str.length();
        return "ok";
    }

    @RequestMapping("/defaultExceptionPage2")
    public String defaultExceptionPage2(){
        int a = 10/0;
        return "ok";
    }

    /**
     * 返回ModelAndView，可以让我们封装异常信息以及视图的指定。
     * @param e  将产生的异常对象注入到方法中
     * @return
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionHandler(Exception e){
        ModelAndView mv = new  ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error_null");
        return mv;
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new  ModelAndView();
        mv.addObject("error2",e.toString());
        mv.setViewName("error_arithmetic");
        return mv;
    }
}