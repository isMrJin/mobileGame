package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DataDictionary)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:31:02
 */
public class DataDictionary implements Serializable {
    private static final long serialVersionUID = 102970615909781033L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 类型编码
     */
    private String typecode;
    /**
     * 类型名称
     */
    private String typename;
    /**
     * 类型值ID
     */
    private Integer valueid;
    /**
     * 类型值Name
     */
    private String valuename;
    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Integer createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
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

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getValueid() {
        return valueid;
    }

    public void setValueid(Integer valueid) {
        this.valueid = valueid;
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
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

