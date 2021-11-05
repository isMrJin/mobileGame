package service.impl;


import dao.AppInfoMapper;
import entity.AppInfo;
import org.springframework.stereotype.Service;
import service.AppInfoService;

import javax.annotation.Resource;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 8:24
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;
    @Override
    public AppInfo getAppInfoView(int appinfoid) {
        return appInfoMapper.getAppInfo(appinfoid);
    }

    @Override
    public int checkApp(int status, int id) {
        return appInfoMapper.checkApp(status,id);
    }

    @Override
    public int updateAppVersion(Integer appId, Integer versionId) {
        return appInfoMapper.updateAppVersion(appId,versionId);
    }

    @Override
    public int selectApkNameCount(String apkName) {
        return appInfoMapper.selectApkNameCount(apkName);
    }

    @Override
    public int addAppInfo(AppInfo appInfo) {
        return appInfoMapper.addAppInfo(appInfo);
    }

    @Override
    public int doAppUpdate(AppInfo appInfo) {
        return appInfoMapper.doAppUpdate(appInfo);
    }

    @Override
    public int updateFile(int id) {
        return appInfoMapper.updateFile(id);
    }

    @Override
    public int delAppInfo(Integer appId) {
        return appInfoMapper.delAppInfo(appId);
    }
}
