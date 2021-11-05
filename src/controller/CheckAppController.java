package controller;

import entity.AppInfo;
import entity.AppVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AppInfoService;
import service.AppVersionService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 23:26
 */
@Controller
@RequestMapping("/CheckAppController")
public class CheckAppController {
    @Resource
    private AppVersionService appVersionService;
    @Resource
    private AppInfoService appInfoService;
    @RequestMapping("/checkAppView")
    public String checkAppView(HttpServletRequest request, @RequestParam(required = true) int appinfoid,
                               @RequestParam(required = true) int versionid){
        AppInfo appInfoView = appInfoService.getAppInfoView(appinfoid);
        AppVersion appVersion = appVersionService.getAppVersion(versionid);
        request.setAttribute("appVersion",appVersion);
        request.setAttribute("appInfo",appInfoView);
        return "/backend/appcheck";
    }
    @RequestMapping("/checkApp")
    public String checkApp(int status,int id){
        int check = appInfoService.checkApp(status, id);
        if(check>0){
            return "redirect:/AuditApp/viewAppInfoList";
        }else{
            return "redirect:/AuditApp/viewAppInfoList";

        }
    }
}
