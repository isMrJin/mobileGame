package controller;

import com.alibaba.fastjson.JSON;
import entity.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.AppCategoryService;
import service.AppInfoService;
import service.AppVersionService;
import service.GameReviewService;
import tools.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 14:22
 */
@Controller
@RequestMapping("/DevAppController")
public class DevAppController {
    @Resource
    private GameReviewService gameReviewService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppVersionService appVersionService;

    @Resource
    private AppInfoService appInfoService;
    @RequestMapping("/viewAppInfoList")
    public String viewAppInfoList(HttpServletRequest request,
                                  @RequestParam(required = false,defaultValue = "") String softwareName,
                                  @RequestParam(required = false,defaultValue = "0") Integer flatformId,
                                  @RequestParam(required = false,defaultValue = "0") Integer appStatus,
                                  @RequestParam(required = false,defaultValue = "0") Integer categoryLevel1,
                                  @RequestParam(required = false,defaultValue = "0") Integer categoryLevel2,
                                  @RequestParam(required = false,defaultValue = "0") Integer categoryLevel3,
                                  @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                  @RequestParam(required = false,defaultValue = "2") Integer pageSize){
        PageSupport pageSupport = new PageSupport();
        //页大小
        pageSupport.setPageSize(5);
        //当前页
        pageSupport.setCurrentPageNo(pageIndex);
        //总页数
        pageSupport.setTotalCount(gameReviewService.getDevAppInfoListCout(softwareName,appStatus,flatformId, categoryLevel1,  categoryLevel2,  categoryLevel3));
        //查询列表数据
        List<AppInfo> appInfoList = gameReviewService.getDevAppInfoList(softwareName,appStatus, flatformId, categoryLevel1, categoryLevel2, categoryLevel3
                , pageSupport);
        //手游状态
        List<DataDictionary> status = gameReviewService.getStatus();
        //平台属性
        List<DataDictionary> terraceProperty = gameReviewService.getTterraceProperty();
        //分类
        List<AppCategory> categoryLevel1List = appCategoryService.getCategoryLevel(0);
        List<AppCategory> categoryLevel2List = appCategoryService.getCategoryLevel(1);
        List<AppCategory> categoryLevel3List = appCategoryService.getCategoryLevel(2);

        if(appInfoList!=null){
            request.setAttribute("statusList",status);
            request.setAttribute("categoryLevel1List",categoryLevel1List);
            request.setAttribute("categoryLevel2List",categoryLevel2List);
            request.setAttribute("categoryLevel3List",categoryLevel3List);
            request.setAttribute("flatFormList",terraceProperty);
            request.setAttribute("appInfoList",appInfoList);
            request.setAttribute("pages",pageSupport);
            return "developer/appinfolist";
        }else {
            return "developer/appinfolist";
        }
    }

    /**
     * @Description: 获取二三级分类
     * @Author: Mr.ShenJinChao
     * @Date: 2021/11/1-23:05
     */
    @ResponseBody
    @RequestMapping("/getCategoryLevel")
    public String getCategoryLevel(@RequestParam(defaultValue = "0") int pid){
        List<AppCategory> categoryLevel = appCategoryService.getCategoryLevel(pid);
        String toJSON = JSON.toJSONString(categoryLevel);
        return toJSON;
    }

    @ResponseBody
    @RequestMapping("{appId}/putawayApp")
    public Object putawayApp(@PathVariable Integer appId){
        Map map = new HashMap<String, Object>();
        int putawayApp =0;
        try{
            putawayApp = gameReviewService.putawayApp(appId);
        }catch (Exception e){
            map.put("errorCode","exception000001");
        }
        if(putawayApp>0){
            map.put("resultMsg","success");
            map.put("errorCode","0");

        }else{
            map.put("resultMsg","failed");
        }
        map.put("appId",appId);
        String toJSON = JSON.toJSONString(map);
        return toJSON;
    }
    @RequestMapping("/appversionadd")
    public String appVersionAdd(AppVersion appVersion, Model model){
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(appVersion.getAppid());
        model.addAttribute("appVersionList",appVersionList);
        model.addAttribute("appVersion",appVersion.getAppid());
        return "developer/appversionadd";
    }

    @RequestMapping("/appVersionAdd")
    public String appVersionAdd(HttpServletRequest request, AppVersion appVersion,
                                @RequestParam(required = false) MultipartFile PicId) throws IOException {
        if(!PicId.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles"+File.separator);
            //源名称
            String originalFilename = PicId.getOriginalFilename();
            //获取后缀名
            String extension = FilenameUtils.getExtension(originalFilename);
            //文件大小
            long size = PicId.getSize();
            if(extension.equalsIgnoreCase("apk")){
                if(size<500000){
                   String orgName =  RandomUtils.nextInt(10000)+System.currentTimeMillis()+"."+extension;
                    File file = new File(path);
                    if(!file.exists()){
                        //不存在当前目录则创建一个目录
                        file.mkdirs();
                    }
                    //开始上传文件
                    PicId.transferTo(new File(file,orgName));
                    appVersion.setApklocpath("statics"+ File.separator+"uploadfiles"+File.separator+orgName);
                    //同时修改appInfo表中的版本
                    appVersion.setApkfilename(orgName);
                }else {
                    throw new RuntimeException("apk大小不允许超过500kb");
                }
            }else{
                throw new RuntimeException("apk后缀错误");
            }
        }
        appVersion.setCreationdate(new Date());
        appVersionService.appVersionAdd(appVersion);
        int updateAppVersion = appInfoService.updateAppVersion(appVersion.getAppid(), appVersion.getId());
        return "redirect:/DevAppController/viewAppInfoList";
    }
    @RequestMapping("/toAppVersionModify")
    public String toAppVersionModify(@RequestParam(defaultValue = "0") Integer aid,
                                     @RequestParam(defaultValue = "0") Integer vid,
                                     Model model){
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(aid);
        AppVersion appVersionView = appVersionService.getAppVersionView(aid, vid);
        appVersionView.setAppid(aid);
        model.addAttribute("appVersionList",appVersionList);
        model.addAttribute("appVersion",appVersionView);
        return "developer/appversionmodify";
    }

    @RequestMapping("/appversionmodifysave")
    public String appVersionModifySave(AppVersion appVersion,
                                       @RequestParam(required = false) MultipartFile PicId,
                                       HttpServletRequest request) throws IOException {
        if(!PicId.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles"+File.separator);
            //源名称
            String originalFilename = PicId.getOriginalFilename();
            //获取后缀名
            String extension = FilenameUtils.getExtension(originalFilename);
            //文件大小
            long size = PicId.getSize();
            if(extension.equalsIgnoreCase("apk")){
                if(size<500000){
                    String orgName =  RandomUtils.nextInt(10000)+System.currentTimeMillis()+"."+extension;
                    File file = new File(path);
                    if(!file.exists()){
                        //不存在当前目录则创建一个目录
                        file.mkdirs();
                    }
                    //开始上传文件
                    PicId.transferTo(new File(file,orgName));
                    appVersion.setApklocpath("statics"+ File.separator+"uploadfiles"+File.separator+orgName);
                    appVersion.setApkfilename(orgName);
                }else {
                    throw new RuntimeException("apk大小不允许超过500kb");
                }
            }else{
                throw new RuntimeException("apk后缀错误");
            }
        }
        appVersion.setModifydate(new Date());
        int appVersionAdd = appVersionService.updateVersion(appVersion);
        return "redirect:/DevAppController/viewAppInfoList";
    }


    @RequestMapping("/apkexist")
    @ResponseBody
    public String apkExist(String APKName) {
        String str = "";
        if (APKName == null || APKName.equals("")) {
            str = "[{\"APKName\":\"empty\"}]";
        } else if (appInfoService.selectApkNameCount(APKName) > 0) {
            System.out.println(1);
            str = "[{\"APKName\":\"exist\"}]";

        } else {
            System.out.println(2);
            str = "[{\"APKName\":\"noexist\"}]";
        }
        System.out.println(str);
        return str;
    }
    @ResponseBody
    @RequestMapping("/datadictionarylist")
    public String dataDictionaryList(){
        List<DataDictionary> terraceProperty = gameReviewService.getTterraceProperty();
        String toString = JSON.toJSONString(terraceProperty);
        return toString;
    }


    @RequestMapping("/toAppInfoAdd")
    public String toAdd(HttpServletRequest request) {
        request.setAttribute("categoryLevel1List", appCategoryService.getCategoryLevel(0));
        request.setAttribute("flatFormList", gameReviewService.getTterraceProperty());
        return "/developer/appinfoadd";
    }

    @RequestMapping("/appinfoaddsave")
    public String addAppInfo(AppInfo appInfo, HttpServletRequest request, MultipartFile a_logoPicPath) {
        String idPicPath = null;
        if (!a_logoPicPath.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles"+File.separator);
            appInfo.setLogolocpath(path + File.separator + a_logoPicPath.getOriginalFilename());
            String originalFile = a_logoPicPath.getOriginalFilename();
            String prefix = FilenameUtils.getExtension(originalFile);
            int filesize = 500000;
            if (a_logoPicPath.getSize() > filesize) {
                request.setAttribute("uploadFileError", "上传文件不能大于50KB");
                return "/developer/appin    foadd";
            } else if (prefix.equalsIgnoreCase("jpg") ||
                    prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("png")) {
                File targeFile = new File(path);
                String orgName =  RandomUtils.nextInt(10000)+System.currentTimeMillis()+"."+prefix;
                appInfo.setLogopicpath("/mobileGame/statics/uploadfiles/" + orgName);
                if (!targeFile.exists()) {
                    targeFile.mkdirs();
                }
                try {
                    a_logoPicPath.transferTo(new File(targeFile,orgName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        DevUser user = (DevUser) request.getSession().getAttribute("devUser");
        appInfo.setCreatedby(user.getId());
        appInfo.setDevid(user.getId());
        appInfo.setCreationdate(new Date());
        if (appInfoService.addAppInfo(appInfo) > 0) {
            return "redirect:/DevAppController/viewAppInfoList";
        }else{
            return "redirect:/DevAppController/viewAppInfoList";
        }
    }

    @RequestMapping("/appinfomodify")
    public String toUpdate(String id, HttpServletRequest request) {
        request.getSession().setAttribute("appInfo", appInfoService.getAppInfoView(Integer.valueOf(id)));
        return "/developer/appinfomodify";
    }

    @RequestMapping("/delfile")
    @ResponseBody
    public String updateUpload(String id,HttpServletRequest request){
        Map map = new HashMap();
        if(appInfoService.updateFile(Integer.valueOf(id))>0){
            map.put("result","success");
        } else {
            map.put("result","failed");
        }
        String toJSON = JSON.toJSONString(map);
        return toJSON;
    }

    @RequestMapping("/appinfomodifysave")
    public String doUpdate(AppInfo appInfo, HttpServletRequest request,MultipartFile attach) {
        String idPicPath = null;
        if (!attach.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles"+File.separator);
            appInfo.setLogolocpath(path + File.separator + attach.getOriginalFilename());
            String originalFile = attach.getOriginalFilename();
            String prefix = FilenameUtils.getExtension(originalFile);
            int filesize = 500000;
            if (attach.getSize() > filesize) {
                request.setAttribute("uploadFileError", "上传文件不能大于50KB");
                return "/developer/appinfoadd";
            } else if (prefix.equalsIgnoreCase("jpg") ||
                    prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("png")) {
                File targeFile = new File(path);
                String orgName =  RandomUtils.nextInt(10000)+System.currentTimeMillis()+"."+prefix;
                appInfo.setLogopicpath("/mobileGame/statics/uploadfiles/" + orgName);
                if (!targeFile.exists()) {
                    targeFile.mkdirs();
                }
                try {
                    attach.transferTo(new File(targeFile, orgName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        DevUser user = (DevUser) request.getSession().getAttribute("devUser");
        appInfo.setModifyby(user.getId());
        appInfo.setDevid(user.getId());
        appInfo.setModifydate(new Date());
        if (appInfoService.doAppUpdate(appInfo) > 0) {
            return "redirect:/DevAppController/viewAppInfoList";
        } else {
            return "redirect:/DevAppController/viewAppInfoList";
        }
    }

    @RequestMapping("/appview/{id}")
    public String appView(@PathVariable Integer id,HttpServletRequest request){
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(id);
        request.getSession().setAttribute("appVersionList",appVersionList);
        request.getSession().setAttribute("appInfo", appInfoService.getAppInfoView(Integer.valueOf(id)));
        return "/developer/appinfoview";
    }

    @RequestMapping("/delapp")
    @ResponseBody
    public String delApp(int id){
        Map map = new HashMap();
        if(appInfoService.delAppInfo(Integer.valueOf(id))>0){
            appVersionService.delVersion(Integer.valueOf(id));
            map.put("delResult","true");
        } else {
            map.put("delResult","false");
        }
        String toJSON = JSON.toJSONString(map);
        return toJSON;
    }
}
