package com.faxintong.iruyi.utils;

import java.io.Serializable;

/**
 * Created by admin on 15-4-18.
 */
public class Pager implements Serializable {

    private Integer totalPage;     //总页数
    private Integer totalCount;    //总记录数
    private Integer currentPage;   //当前页
    private Integer pageSize = 10;      //每页的数量

    private Integer startCount;//开始条数


    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartCount(Integer pageSize, Integer currentPage) {
        if(currentPage <= 1){
            return 0;
        }else{
            return (currentPage-1) * pageSize;
        }
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }
}
