package service.impl;

import dao.DevUserMapper;
import entity.BackendUser;
import entity.DevUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DevUserService;

/** 
* @version : 1.0 
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-22:43
*/
@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public DevUser devUserLogin(String devCode, String devPassword) {
       DevUser devUser = devUserMapper.getDevUser(devCode);
        if(null!=devUser){
            //密码相等返回该用户
            if( devPassword.equals(devUser.getDevpassword())){
                return devUser;
            }
        }
        return null;
    }


}
