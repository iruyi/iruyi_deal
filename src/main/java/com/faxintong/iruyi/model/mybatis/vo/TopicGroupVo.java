package com.faxintong.iruyi.model.mybatis.vo;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/20.
 */
public class TopicGroupVo {
    private Long id;

    private String groupName;

    private Integer readerCount;

    private Integer fansCount;

    private Integer topicCount;

    private Integer isAtten;
    private List<TopicAllVo> topicAllVoList;

    private String bigImage;
    private String smallImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReaderCount() {
        return readerCount;
    }

    public void setReaderCount(Integer readerCount) {
        this.readerCount = readerCount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Integer getIsAtten() {
        return isAtten;
    }

    public void setIsAtten(Integer isAtten) {
        this.isAtten = isAtten;
    }

    public List<TopicAllVo> getTopicAllVoList() {
        return topicAllVoList;
    }

    public void setTopicAllVoList(List<TopicAllVo> topicAllVoList) {
        this.topicAllVoList = topicAllVoList;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }
}
