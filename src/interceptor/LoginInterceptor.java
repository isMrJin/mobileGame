package interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ShenJ
 */
public class LoginInterceptor  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("启动登录拦截");
        HttpSession session = request.getSession();
        //用户完成登录后
        if(null!=session.getAttribute("backendUser")||null!=session.getAttribute("devUser")){
            return true;
        }
        //用户访问登录页面不进行拦截
        if(request.getRequestURI().contains("/devlogin")||request.getRequestURI().contains("/backendlogin")){
            return true;
        }
        //登录请求不进行拦截
        if(request.getRequestURI().contains("/backendLoginIn")||request.getRequestURI().contains("/DevLoginIn")){
            return true;
        }
        request.getRequestDispatcher("/403.jsp").forward(request,response);
        return false;
    }
}
