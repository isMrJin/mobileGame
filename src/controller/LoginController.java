package controller;

import entity.BackendUser;
import entity.DevUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BackendUserService;
import service.DevUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* @version : 1.0
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-22:10
*/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private BackendUserService backendUserService;
    @Resource
    private DevUserService devUserService;
    /**
    * @Description: 后台用户导向登录
    * @Author: Mr.ShenJinChao
    * @Date: 2021/10/31-22:47
    */
    @RequestMapping("/backendlogin")
    public String toManagerLogin(){
        System.out.println("===进入后台登录===");
        return "backendlogin";
    }

    /**
    * @Description: 开发者导向登录页面
    * @Author: Mr.ShenJinChao
    * @Date: 2021/10/31-22:10
    */
    @RequestMapping("/devlogin")
    public String toDevLogin(){
        System.out.println("===进入开发者登录===");
        return "devlogin";
    }
    
    /** 
    * @Description: 登录后台验证
    * @Param:  userCode userPassword
    * @Author: Mr.ShenJinChao
    * @Date: 2021/10/31-23:02
    */
    @PostMapping("/backendLoginIn")
    public String BackendLogin(HttpServletRequest request, @RequestParam(defaultValue = "error") String userCode, @RequestParam(defaultValue = "error") String userPassword){
        BackendUser backendUser=null;
        try{
            backendUser = backendUserService.backendUserLogin(userCode, userPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(null!=backendUser){
            //登录成功跳转到后台首页
            HttpSession session = request.getSession();
            session.setAttribute("backendUser",backendUser);
            return "redirect:/login/toBackendMain";
        }else {
            request.setAttribute("loginError","后台用户名或密码错误！");
            return "/backendlogin";
        }
    }
    @RequestMapping("/toBackendMain")
    public String toBackendMain(){
        return "/backend/main";
    }


    /**
     * @Description: 登录开发者后台验证
     * @Param:  userCode userPassword
     * @Author: Mr.ShenJinChao
     * @Date: 2021/10/31-23:02
     */
    @PostMapping("/DevLoginIn")
    public String DevLogin(HttpServletRequest request, @RequestParam(defaultValue = "error") String devCode, @RequestParam(defaultValue = "error") String devPassword){
        DevUser devUser=null;
        try{
            devUser = devUserService.devUserLogin(devCode, devPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(null!=devUser){
            //登录成功跳转到后台首页
            HttpSession session = request.getSession();
            session.setAttribute("devUser",devUser);
            return "redirect:/login/toDevMain";
        }else {
            request.setAttribute("loginError","开发者用户名或密码错误！");
            return "/devlogin";
        }
    }
    @RequestMapping("/toDevMain")
    public String toDevMain(){
        return "/developer/main";
    }
    
    /** 
    * @Description: 注销后台用户
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-10:40
    */
    @GetMapping("/logoutBackendUser/{userCode}")
    public String logoutBackendUser(HttpServletRequest request,@PathVariable String userCode){
        HttpSession session = request.getSession();
        BackendUser backendUser = (BackendUser) session.getAttribute("backendUser");
        if(null!=backendUser){
            if(userCode.equals(backendUser.getUsercode())){
                System.out.println(backendUser.getUsercode()+"成功注销");
                session.removeAttribute("backendUser");
                return "/backendlogin";
            }
        }
        return "/toBackendMain";
    }



    /**
     * @Description: 注销后台用户
     * @Author: Mr.ShenJinChao
     * @Date: 2021/11/1-10:40
     */
    @GetMapping("/logoutDevUser/{userCode}")
    public String logoutDevUser(HttpServletRequest request,@PathVariable String userCode){
        HttpSession session = request.getSession();
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        if(null!=devUser){
            if(userCode.equals(devUser.getDevcode())){
                System.out.println(devUser.getDevcode()+"成功注销");
                session.removeAttribute("devUser");
                return "/devlogin";
            }
        }
        return "/toDveMain";
    }
}
