package controller;

import com.alibaba.fastjson.JSON;
import entity.AppCategory;
import entity.AppInfo;
import entity.DataDictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.AppCategoryService;
import service.GameReviewService;
import tools.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 11:26
 */
@Controller
@RequestMapping("/AuditApp")
public class AuditAppController {
    @Resource
    private GameReviewService gameReviewService;
    @Resource
    private AppCategoryService appCategoryService;

    /**
    * @Description: app审核页面查询
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-19:23
    */
    @RequestMapping("/viewAppInfoList")
    public String viewAppInfoList(HttpServletRequest request,
                                  @RequestParam(required = false,defaultValue = "") String softwareName,
                                  @RequestParam(required = false,defaultValue = "0") Integer flatformId,
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
        pageSupport.setTotalCount(gameReviewService.getAppInfoListCout(softwareName, flatformId, categoryLevel1,  categoryLevel2,  categoryLevel3));
        //查询列表数据
        List<AppInfo> appInfoList = gameReviewService.getAppInfoList(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3
                , pageSupport);
        //平台属性
        List<DataDictionary> terraceProperty = gameReviewService.getTterraceProperty();
        //分类
        List<AppCategory> categoryLevel1List = appCategoryService.getCategoryLevel(0);
        List<AppCategory> categoryLevel2List = appCategoryService.getCategoryLevel(1);
        List<AppCategory> categoryLevel3List = appCategoryService.getCategoryLevel(2);

        if(appInfoList!=null){
            request.setAttribute("categoryLevel1List",categoryLevel1List);
            request.setAttribute("categoryLevel2List",categoryLevel2List);
            request.setAttribute("categoryLevel3List",categoryLevel3List);
            request.setAttribute("flatFormList",terraceProperty);
            request.setAttribute("appInfoList",appInfoList);
            request.setAttribute("pages",pageSupport);
            return "backend/applist";
        }else {
            return "backend/applist";
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

}
