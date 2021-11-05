package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BackendUser)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:31:02
 */
public class BackendUser implements Serializable {
    private static final long serialVersionUID = -93928224289205624L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户编码
     */
    private String usercode;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    private Integer usertype;

    private String usertypes;
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
    /**
     * 用户密码
     */
    private String userpassword;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsertypes() {
        return usertypes;
    }

    public void setUsertypes(String usertypes) {
        this.usertypes = usertypes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
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

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

}

