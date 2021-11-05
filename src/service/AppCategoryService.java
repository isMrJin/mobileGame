package service;

import entity.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 21:56
 */
public interface AppCategoryService {
    /** 
    * @Description: 根据分类id查询二三级分类
    * @Param:  
    * @return:  
    * @Author: Mr.ShenJinChao
    * @Date: 2021/11/1-23:07
    */
    public List<AppCategory> getCategoryLevel(int parentId);
}
