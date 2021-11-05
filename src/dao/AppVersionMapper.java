package dao;

import entity.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 9:24
 */
public interface AppVersionMapper {
    public AppVersion getAppVersion(@Param("versionid") int versionid);

    /**
    * @Description: 新增app版本号
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-10:12
    */
    public int appVersionAdd(@Param("appVersion")AppVersion appVersion);

    /**
    * @Description: 获取软件版本列表
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-15:50
    */
    public List<AppVersion> getAppversionList(@Param("appId")Integer appId);

    /**
    * @Description: 查询当前app最新版本
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-20:44
    */
    public AppVersion getAppVersionView(@Param("appId") Integer appId,@Param("versionId") Integer versionId);
    
    /** 
    * @Description: 更新当前版本信息
    * @Param:  
    * @return:  
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/3-21:26
    */
    public int updateVersion(@Param("appVersion")AppVersion appVersion);


    /** 
    * @Description: 删除数据库版本文件
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-15:59
    */
    public int updateUpload(@Param("id")int id);

    /** 
    * @Description: 删除版本
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-19:04
    */
    public int delVersion(@Param("aid")Integer id);
}
