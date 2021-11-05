package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AppInfo)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:30:51
 */
public class AppInfo implements Serializable {
    private static final long serialVersionUID = 988821641745454340L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 软件名称
     */
    private String softwarename;
    /**
     * APK名称（唯一）
     */
    private String apkname;
    /**
     * 支持ROM
     */
    private String supportrom;
    /**
     * 界面语言
     */
    private String interfacelanguage;
    /**
     * 软件大小（单位：M）
     */
    private Double softwaresize;
    /**
     * 更新日期
     */
    private Date updatedate;
    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Integer devid;
    /**
     * 应用简介
     */
    private String appinfo;
    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Integer status;
    private String statusName;
    /**
     * 上架时间
     */
    private Date onsaledate;
    /**
     * 下架时间
     */
    private Date offsaledate;
    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Integer flatformid;
    private String flatformName;
    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Integer categorylevel3;
    private String categoryLevel3Name;
    /**
     * 下载量（单位：次）
     */
    private Integer downloads;
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
     * 所属一级分类（来源于：data_dictionary）
     */
    private Integer categorylevel1;
    private String categoryLevel1Name;
    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Integer categorylevel2;
    private String categoryLevel2Name;
    /**
     * LOGO图片url路径
     */
    private String logopicpath;
    /**
     * LOGO图片的服务器存储路径
     */
    private String logolocpath;
    /**
     * 最新的版本id
     */
    private Integer versionid;
    private String versionNo;
    private double versionSize;

    public double getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(double versionSize) {
        this.versionSize = versionSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getApkname() {
        return apkname;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom;
    }

    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage;
    }

    public Double getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(Double softwaresize) {
        this.softwaresize = softwaresize;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getDevid() {
        return devid;
    }

    public void setDevid(Integer devid) {
        this.devid = devid;
    }

    public String getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOnsaledate() {
        return onsaledate;
    }

    public void setOnsaledate(Date onsaledate) {
        this.onsaledate = onsaledate;
    }

    public Date getOffsaledate() {
        return offsaledate;
    }

    public void setOffsaledate(Date offsaledate) {
        this.offsaledate = offsaledate;
    }

    public Integer getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Integer flatformid) {
        this.flatformid = flatformid;
    }

    public Integer getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Integer categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
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

    public Integer getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Integer categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public Integer getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Integer categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public String getLogopicpath() {
        return logopicpath;
    }

    public void setLogopicpath(String logopicpath) {
        this.logopicpath = logopicpath;
    }

    public String getLogolocpath() {
        return logolocpath;
    }

    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }

}

