package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AppVersion)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:31:02
 */
public class AppVersion implements Serializable {
    private static final long serialVersionUID = 216591090760887266L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * appId（来源于：app_info表的主键id）
     */
    private Integer appid;
    /**
     * 版本号
     */
    private String versionno;

    private String appName;
    /**
     * 版本介绍
     */
    private String versioninfo;
    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    private Integer publishstatus;
    private String publishStatusName;
    /**
     * 下载链接
     */
    private String downloadlink;
    /**
     * 版本大小（单位：M）
     */
    private Double versionsize;
    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Integer createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Integer modifyby;
    /**
     * 最新更新时间
     */
    private Date modifydate;
    /**
     * apk文件的服务器存储路径
     */
    private String apklocpath;
    /**
     * 上传的apk文件名称
     */
    private String apkfilename;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPublishStatusName() {
        return publishStatusName;
    }

    public void setPublishStatusName(String publishStatusName) {
        this.publishStatusName = publishStatusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo;
    }

    public Integer getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(Integer publishstatus) {
        this.publishstatus = publishstatus;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public Double getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(Double versionsize) {
        this.versionsize = versionsize;
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

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath;
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename;
    }

}

