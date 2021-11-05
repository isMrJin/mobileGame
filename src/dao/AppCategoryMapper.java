package dao;

import entity.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 21:48
 */
public interface AppCategoryMapper {

    public List<AppCategory> getCategoryLevel(@Param("parentId") int parentId);

}
