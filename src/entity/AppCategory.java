package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AppCategory)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:30:44
 */
public class AppCategory implements Serializable {
    private static final long serialVersionUID = -94376607739398197L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 分类编码
     */
    private String categorycode;
    /**
     * 分类名称
     */
    private String categoryname;
    /**
     * 父级节点id
     */
    private Integer parentid;
    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Integer createdby;
    /**
     * 创建时间
     */
    private Date creationtime;
    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Integer modifyby;
    /**
     * 最新更新时间
     */
    private Date modifydate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getModifyby() {
        return modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

}

