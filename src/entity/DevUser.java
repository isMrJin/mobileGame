package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DevUser)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:31:02
 */
public class DevUser implements Serializable {
    private static final long serialVersionUID = -13684585015278202L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 开发者帐号
     */
    private String devcode;
    /**
     * 开发者名称
     */
    private String devname;
    /**
     * 开发者密码
     */
    private String devpassword;
    /**
     * 开发者电子邮箱
     */
    private String devemail;
    /**
     * 开发者简介
     */
    private String devinfo;
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

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public String getDevpassword() {
        return devpassword;
    }

    public void setDevpassword(String devpassword) {
        this.devpassword = devpassword;
    }

    public String getDevemail() {
        return devemail;
    }

    public void setDevemail(String devemail) {
        this.devemail = devemail;
    }

    public String getDevinfo() {
        return devinfo;
    }

    public void setDevinfo(String devinfo) {
        this.devinfo = devinfo;
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

