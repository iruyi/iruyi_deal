package com.faxintong.iruyi.model.common;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by hehongju on 2015/2/15.
 */
public class Page implements Serializable {

    /**
     * 每页的数量
     */
    @NotBlank
    private Integer pageSize;

    /**
     * 当前页数
     */
    @NotBlank
    private Integer currentSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Integer currentSize) {
        this.currentSize = currentSize;
    }
}
