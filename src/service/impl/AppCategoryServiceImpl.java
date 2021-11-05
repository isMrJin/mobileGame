package service.impl;

import dao.AppCategoryMapper;
import entity.AppCategory;
import org.apache.ibatis.javassist.tools.rmi.AppletServer;
import org.springframework.stereotype.Service;
import service.AppCategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 21:57
 */
@Service
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> getCategoryLevel(int parentId) {

        return appCategoryMapper.getCategoryLevel(parentId);
    }
}
