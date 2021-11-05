package dao;

import entity.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Mr.ShenJinChao
 * @date : 2021/11/1 15:10
 */
public interface DataDictionaryMapper {
    public List<DataDictionary> getTterraceProperty(@Param("status") String status);
}
