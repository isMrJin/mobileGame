package service;

import entity.BackendUser;
import org.apache.ibatis.annotations.Param;

/**
* @version : 1.0
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-17:36
*/
public interface BackendUserService {
    /** 
    * @Description: 后台登录方法
    * @Param: userCode  userPassword
    * @return:  BackendUser
    * @Author: Mr.ShenJinChao
    * @Date: 2021/10/31-22:34
    */
    public BackendUser backendUserLogin(String userCode,String userPassword);
}
