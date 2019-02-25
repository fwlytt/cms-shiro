package com.cms.domain;

import java.util.Date;
import javax.persistence.*;

public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 作品id
     */
    @Column(name = "work_id")
    private Integer workId;

    /**
     * 排序
     */
    private Integer rank;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取作品id
     *
     * @return work_id - 作品id
     */
    public Integer getWorkId() {
        return workId;
    }

    /**
     * 设置作品id
     *
     * @param workId 作品id
     */
    public void setWorkId(Integer workId) {
        this.workId = workId;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}