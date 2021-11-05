package service;

import entity.AppInfo;
import entity.AppVersion;
import entity.DataDictionary;
import org.apache.ibatis.annotations.Param;
import tools.PageSupport;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 15:27
 */
public interface GameReviewService {
    /**
    * @Description: 获取平台属性分类
    * @return: List<DataDictionary>
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-15:29
    */
    public List<DataDictionary> getTterraceProperty();

    /**
    * @Description: 获取手游全部状态
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-18:03
    */
    public List<DataDictionary> getStatus();
        /**
        * @Description: 查询待审核App
        * @Author: Mr.ShenJinChao
        * @Date: 2021/11/1-19:16
         * @return
        */
    public List<AppInfo> getAppInfoList(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, PageSupport pageSupport);
    
    /** 
    * @Description: dev查询app列表
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-20:34
    */
    public List<AppInfo> getDevAppInfoList(String softwareName, Integer appStatus, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, PageSupport pageSupport);

    /** 
    * @Description: 获取app审核总数据
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-21:12
    */
    public int getAppInfoListCout( String softwareName,  Integer flatformId,  Integer categoryLevel1, Integer categoryLevel2,  Integer categoryLevel3);

    /** 
    * @Description: 获取Devapp列表总数
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-20:44
    */
    public int getDevAppInfoListCout( String softwareName,Integer appStatus, Integer flatformId,  Integer categoryLevel1, Integer categoryLevel2,  Integer categoryLevel3);

    /** 
    * @Description: app上架
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-21:45
    */
    public int putawayApp(Integer appId);
    

}
