package dao;

import entity.BackendUser;
import entity.DevUser;
import org.apache.ibatis.annotations.Param;

/**
* @version : 1.0
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-17:36
*/
public interface DevUserMapper {
    /**
    * 获取开发者用户
    * @param devCode
    * @return DevUser
    * @author Mr.ShenJinChao
    * @date 2021/10/31-17:29
    */
    public DevUser getDevUser(@Param("devCode") String devCode);

}
