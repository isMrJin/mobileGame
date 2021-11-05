package dao;

import entity.AppInfo;
import org.apache.ibatis.annotations.Param;
import tools.PageSupport;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 18:47
 */
public interface AppInfoMapper {
    /**
    * @Description: 查询app列表
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-19:18
    */
    public List<AppInfo> getAppInfoList(@Param("softwareName") String softwareName, @Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1, @Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3,@Param("pageSupport") PageSupport pageSupport);

    /** 
    * @Description: 查询DevApp列表
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-20:37
    */
    public List<AppInfo> getDevAppInfoList(@Param("softwareName") String softwareName,@Param("appStatus")Integer appStatus, @Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1, @Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3,@Param("pageSupport") PageSupport pageSupport);


    /** 
    * @Description: 查询分页总数
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-19:22
    */
    public int getAppInfoListCout(@Param("softwareName") String softwareName,@Param("flatformId") Integer flatformId,@Param("categoryLevel1") Integer categoryLevel1,@Param("categoryLevel2") Integer categoryLevel2,@Param("categoryLevel3") Integer categoryLevel3);

    /** 
    * @Description: 获取devApp查询列表总数
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-20:41
    */
    public int getDevAppInfoListCout(@Param("softwareName") String softwareName,@Param("appStatus")Integer appStatus,@Param("flatformId") Integer flatformId,@Param("categoryLevel1") Integer categoryLevel1,@Param("categoryLevel2") Integer categoryLevel2,@Param("categoryLevel3") Integer categoryLevel3);


    /** 
    * @Description: 查询appInfo信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-23:35
    */
    public AppInfo getAppInfo(@Param("appinfoid") int appinfoid);

    /** 
    * @Description: 更新审核状态
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-10:43
    */
    public int checkApp(@Param("status") int status,@Param("id") int id);

    /** 
    * @Description: app上架下架操作
     *     * @Author: Mr.ShenJinChao
     *     * @Date: 2021/11/2-21:25
    */
    public int putawayApp(@Param("appId") Integer appId,@Param("status")Integer status);

    /** 
    * @Description: 查询当前app状态
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-9:25
    */
    public int appStatus(@Param("appId") Integer appId);

    /**
    * @Description: 修改app版本号
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-8:56
    */
    public int updateAppVersion(@Param("appId") Integer appId,@Param("versionId") Integer versionId);

    /** 
    * @Description: 判断新增app名称是否重复
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-10:52
    */
    public int selectApkNameCount(@Param("apkName") String apkName);

    /** 
    * @Description: 新增app信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-10:53
    */
    public int addAppInfo(@Param("app") AppInfo appInfo);

    /** 
    * @Description: 更新app信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-15:44
    */
    public int doAppUpdate(@Param("app") AppInfo appInfo);
    
    /** 
    * @Description: 删除修改appinfo文件
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-16:33
    */
    public int updateFile(@Param("id")int id);
    
    /** 
    * @Description: 删除app信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-19:02
    */
    public int delAppInfo(@Param("id")int id);

}
