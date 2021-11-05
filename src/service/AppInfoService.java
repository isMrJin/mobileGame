package service;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import entity.AppInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 8:24
 */
public interface AppInfoService {
    /**
    * @Description: 获取app信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-9:02
    */
    public AppInfo getAppInfoView(int appinfoid);

    /**
    * @Description: 审核
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/2-10:44
    */
    public int checkApp(int status, int id);

    /** 
    * @Description: 更新app版本信息
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-9:03
    */
    public int updateAppVersion(Integer appId,Integer versionId);

    /** 
    * @Description: 查询新增名称是否重复
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-10:57
    */
    public int selectApkNameCount( String apkName);

    /**
    * @Description: 新增app
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-10:57
    */
    public int addAppInfo(@Param("app") AppInfo appInfo);


    /**
     * @Description: 更新app信息
     * @Author: Mr.ShenJinChao
     * @Date: 2021/11/4-15:48
     */
    public int doAppUpdate(AppInfo appInfo);

    /** 
    * @Description: 删除app图片
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/4-16:34
    */
    public int updateFile( int id);

    public int delAppInfo(Integer appId);
}
