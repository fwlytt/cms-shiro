package com.cms.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_works")
public class CmsWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 作品年代
     */
    @Column(name = "work_year")
    private String workYear;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片尺寸
     */
    @Column(name = "pic_size")
    private String picSize;

    /**
     * 图片地址
     */
    @Column(name = "pic_url")
    private String picUrl;

    private String banner;

    /**
     * 排序
     */
    private Integer rank;

    @Column(name = "banner_rank")
    private Integer bannerRank;

    /**
     * 是否显示首页；1是；0否
     */
    @Column(name = "home_show")
    private String homeShow;

    @Column(name = "create_time")
    private Date createTime;

    private String status;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取作品年代
     *
     * @return work_year - 作品年代
     */
    public String getWorkYear() {
        return workYear;
    }

    /**
     * 设置作品年代
     *
     * @param workYear 作品年代
     */
    public void setWorkYear(String workYear) {
        this.workYear = workYear == null ? null : workYear.trim();
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取图片尺寸
     *
     * @return pic_size - 图片尺寸
     */
    public String getPicSize() {
        return picSize;
    }

    /**
     * 设置图片尺寸
     *
     * @param picSize 图片尺寸
     */
    public void setPicSize(String picSize) {
        this.picSize = picSize == null ? null : picSize.trim();
    }

    /**
     * 获取图片地址
     *
     * @return pic_url - 图片地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片地址
     *
     * @param picUrl 图片地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取排序
     *
     * @return rank - 排序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排序
     *
     * @param rank 排序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取是否显示首页；1是；0否
     *
     * @return home_show - 是否显示首页；1是；0否
     */
    public String getHomeShow() {
        return homeShow;
    }

    /**
     * 设置是否显示首页；1是；0否
     *
     * @param homeShow 是否显示首页；1是；0否
     */
    public void setHomeShow(String homeShow) {
        this.homeShow = homeShow == null ? null : homeShow.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getBannerRank() {
        return bannerRank;
    }

    public void setBannerRank(Integer bannerRank) {
        this.bannerRank = bannerRank;
    }
}