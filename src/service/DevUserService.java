package service;

import entity.AppInfo;
import entity.BackendUser;
import entity.DevUser;
import org.apache.ibatis.annotations.Param;

/**
* @version : 1.0
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-17:36
*/
public interface DevUserService {
    /**
     * @Description: 开发者登录方法
     * @Param: userCode  userPassword
     * @return:  DevUser
     * @Author: Mr.ShenJinChao
     * @Date: 2021/10/31-22:34
     */
    public DevUser devUserLogin(String devCode, String devPassword);


}
