package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {


        return "Hello Spring Boot11.";
    }

    @RequestMapping("/say1")
    @ResponseBody
    public String sss(){
        return alphaService.select();
    }

    @RequestMapping("/http")
    //可以通过response对象向浏览器输出任意数据，不依赖返回值，因此是void
    //获取请求对象，响应对象，由前段控制器传给你
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name =enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+" "+value);
        }
        //返回响应数据
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>牛客</h1>");
    }

    //GET请求
    // 查询学生
    // student 分页当前第几页，每页最多多少条
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@RequestParam(name = "current",required = false,defaultValue = "1") int current, int limit){
        System.out.println(current);
        return "some student";
    }

    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "str";
    }

    //响应html数据
    @RequestMapping(path = "/teaacher",method = RequestMethod.GET)
    public ModelAndView getTecher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age","12");
        mav.setViewName("/demo/view");
        return mav;
    }

    //效果类似上面的
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","beida");
        model.addAttribute("age","22");
        return "/demo/view";
    }

    // 响应json数据（异步请求）
    // 网页不刷新，仅返回数据
    // Java 通过json js就能接收
    @RequestMapping(path = "/emp")
    @ResponseBody
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","zhang");
        emp.put("age",23);
        emp.put("sa","222");
        list.add(emp);

        Map<String,Object> emp2 = new HashMap<>();
        emp2.put("name","zha2ng");
        emp2.put("age",23);
        emp2.put("sa","2222");
        list.add(emp2);
        return list;
    }

    //cookie
    @RequestMapping(path = "/cookie/set",method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response){

        //创建cookie
        Cookie cookie = new Cookie("code","asddasda");
        //Cooike的生效范围
        cookie.setPath("/community/alpha");
        //Cookie的生效时间,不设置就关掉浏览器没了，设置了就存到硬盘里了
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
        //code=33; Max-Age=600; Expires=Thu, 31-Mar-2022 12:31:59 GMT; Path=/comunity/alpha
        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get")
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
        return "get cookie";
    }

    @RequestMapping(path = "/session/set",method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("id",1);
        session.setAttribute("name","beida");
        return "set session";
    }

    @RequestMapping(path = "/session/get",method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session";
    }

//    // cookie示例
//
//    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
//    @ResponseBody
//    public String setCookie(HttpServletResponse response) {
//        // 创建cookie
////        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
//        Cookie cookie = new Cookie("code", "fffadsadad");
//        // 设置cookie生效的范围
//        cookie.setPath("/community/alpha");
//        // 设置cookie的生存时间
//        cookie.setMaxAge(60 * 10);
//        // 发送cookie
//        response.addCookie(cookie);
//
//        return "set cookie";
//    }
//
//    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
//    @ResponseBody
//    public String getCookie(@CookieValue("code") String code) {
//        System.out.println(code);
//        return "get cookie";
//    }







}