package com.faxintong.iruyi.model.mybatis.vo;

import com.faxintong.iruyi.model.mybatis.active.Active;

import java.util.List;

/**
 * Created by admin on 15-4-26.
 */
public class ActiveVo extends Active {

    /**
     * 点赞数
     */
    private Integer praiseCount;

    /**
     * 是否收藏
     */
    private Integer isCollect;

    /**
     * 关注的头像列表
     */
    private List<String> attentionPhotos;

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public List<String> getAttentionPhotos() {
        return attentionPhotos;
    }

    public void setAttentionPhotos(List<String> attentionPhotos) {
        this.attentionPhotos = attentionPhotos;
    }
}
