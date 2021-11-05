package service.impl;

import dao.AppVersionMapper;
import entity.AppVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AppVersionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/2 9:44
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionMapper appVersionMapper;
    @Override
    public AppVersion getAppVersion(int versionid) {
        return appVersionMapper.getAppVersion(versionid);
    }

    @Override
    public int appVersionAdd(AppVersion appVersion) {
        return appVersionMapper.appVersionAdd(appVersion);
    }

    @Override
    public List<AppVersion> getAppVersionList(Integer appId) {
        return appVersionMapper.getAppversionList(appId);
    }

    @Override
    public AppVersion getAppVersionView(Integer appId, Integer versionId) {
        return appVersionMapper.getAppVersionView(appId,versionId);
    }

    @Override
    public int updateVersion(AppVersion appVersion) {
        return appVersionMapper.updateVersion(appVersion);
    }

    @Override
    public int updateUpload(int id) {
        return appVersionMapper.updateUpload(id);
    }

    @Override
    public int delVersion(Integer appId) {
        return appVersionMapper.delVersion(appId);
    }
}
