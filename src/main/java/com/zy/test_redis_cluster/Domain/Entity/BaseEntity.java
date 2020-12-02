package com.zy.test_redis_cluster.Domain.Entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity  implements Serializable {

    private Long createBy;

    private Long lastUpateBy;

    private Date createTime;

    private Date lastUpdateTime;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getLastUpateBy() {
        return lastUpateBy;
    }

    public void setLastUpateBy(Long lastUpateBy) {
        this.lastUpateBy = lastUpateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
