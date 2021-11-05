package service;

import entity.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 9:24
 */
public interface AppVersionService {
    public AppVersion getAppVersion(int versionid);

    /**
     * @Description: 新增app版本
     * @Author: Mr.ShenJinChao
     * @Date: 2021/11/3-10:45
     */
    public int appVersionAdd(AppVersion appVersion);

    /**
     * @Description: 获取app版本列表
     * @Author: Mr.ShenJinChao
     * @Date: 2021/11/3-15:54
     */
    public List<AppVersion> getAppVersionList(Integer appId);

    /** 
    * @Description: 获取当前app最新版本
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-20:48
    */
    public AppVersion getAppVersionView(Integer appId,Integer versionId);

    /** 
    * @Description: 修改app当前版本信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-21:28
    */
    public int updateVersion(AppVersion appVersion);

    /** 
    * @Description: 删除app版本文件
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-16:01
    */
    public int updateUpload(@Param("id")int id);

    /**
    * @Description: 删除版本
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-19:05
    */
    public int delVersion(Integer appId);

}
