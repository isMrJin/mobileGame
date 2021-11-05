package service.impl;

import dao.AppInfoMapper;
import dao.AppVersionMapper;
import dao.DataDictionaryMapper;
import entity.AppInfo;
import entity.AppVersion;
import entity.DataDictionary;
import org.springframework.stereotype.Service;
import service.GameReviewService;
import tools.PageSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 15:29
 */
@Service
public class GameReviewServiceImpl implements GameReviewService {
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;
    @Resource
    private AppInfoMapper appInfoMapper;
    @Override
    public List<DataDictionary> getTterraceProperty() {
        return dataDictionaryMapper.getTterraceProperty("APP_FLATFORM");
    }
    @Override
    public List<DataDictionary> getStatus() {
        return dataDictionaryMapper.getTterraceProperty("APP_STATUS");
    }

    @Override
    public List<AppInfo> getAppInfoList(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, PageSupport pageSupport) {
        int pageIndexs = (pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize();
        pageSupport.setPageNo(pageIndexs);
        List<AppInfo> appInfoList = appInfoMapper.getAppInfoList(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageSupport);
        return appInfoList;
    }

    @Override
    public List<AppInfo> getDevAppInfoList(String softwareName, Integer appStatus, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, PageSupport pageSupport) {
        int pageIndexs = (pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize();
        pageSupport.setPageNo(pageIndexs);
        List<AppInfo> appInfoList = appInfoMapper.getDevAppInfoList(softwareName,appStatus, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageSupport);
        return appInfoList;
    }

    @Override
    public int getAppInfoListCout(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.getAppInfoListCout(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
    }

    @Override
    public int getDevAppInfoListCout(String softwareName, Integer appStatus, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.getDevAppInfoListCout(softwareName,appStatus,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
    }

    @Override
    public int putawayApp(Integer appId) {
        //如果数据库是上架状态就改成下架是下架就上架
        if (appInfoMapper.appStatus(appId)==4){
           return appInfoMapper.putawayApp(appId,5);
        }else if(appInfoMapper.appStatus(appId)==5){
           return appInfoMapper.putawayApp(appId,4);
        }else if(appInfoMapper.appStatus(appId)==2){
            return appInfoMapper.putawayApp(appId,2);
        }
        return 0;
    }
}
