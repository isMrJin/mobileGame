package service.impl;

import dao.BackendUserMapper;
import entity.BackendUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BackendUserService;

/** 
* @version : 1.0 
* @Author: Mr.ShenJinChao
* @Date: 2021/10/31-22:43
*/
@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Autowired
    private BackendUserMapper backendUserMapper;
    @Override
    public BackendUser backendUserLogin(String userCode, String userPassword) {
        BackendUser backendUser = backendUserMapper.getBackendUser(userCode);
        if(null!=backendUser){
            //密码相等返回该用户
           if( userPassword.equals(backendUser.getUserpassword())){
                return backendUser;
           }
        }
        return null;
    }
}
