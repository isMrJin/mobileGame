package dao;

import entity.BackendUser;
import entity.DevUser;
import org.apache.ibatis.annotations.Param;

/**
* @version : 1.0
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-17:36
*/
public interface BackendUserMapper {

    /**
     * 获取后台用户
     * @param userCode
     * @return DevUser
     * @author Mr.ShenJinChao
     * @date 2021/10/31-17:29
     */
    public BackendUser getBackendUser(@Param("userCode") String userCode);
}
