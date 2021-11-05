package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AdPromotion)实体类
 *
 * @author makejava
 * @since 2021-10-30 23:30:32
 */
public class AdPromotion implements Serializable {
    private static final long serialVersionUID = -33849616911017043L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * appId（来源于：app_info表的主键id）
     */
    private Integer appid;
    /**
     * 广告图片存储路径
     */
    private String adpicpath;
    /**
     * 广告点击量
     */
    private Integer adpv;
    /**
     * 轮播位（1-n）
     */
    private Integer carouselposition;
    /**
     * 起效时间
     */
    private Date starttime;
    /**
     * 失效时间
     */
    private Date endtime;
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

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getAdpicpath() {
        return adpicpath;
    }

    public void setAdpicpath(String adpicpath) {
        this.adpicpath = adpicpath;
    }

    public Integer getAdpv() {
        return adpv;
    }

    public void setAdpv(Integer adpv) {
        this.adpv = adpv;
    }

    public Integer getCarouselposition() {
        return carouselposition;
    }

    public void setCarouselposition(Integer carouselposition) {
        this.carouselposition = carouselposition;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

