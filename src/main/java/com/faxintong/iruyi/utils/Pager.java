package com.faxintong.iruyi.utils;

import java.io.Serializable;

/**
 * Created by admin on 15-4-18.
 */
public class Pager implements Serializable {

    private int totalPage;     //总页数
    private int totalCount;    //总记录数
    private int currentPage;   //当前页
    private int pageSize = 10;      //每页的数量

    private int startCount;//开始条数

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartCount(int pageSize, int currentPage) {
        if(currentPage <= 1){
            return 0;
        }else{
            return (currentPage-1) * pageSize;
        }
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }
}
