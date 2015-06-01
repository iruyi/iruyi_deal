package com.faxintong.iruyi.service.active;

import com.faxintong.iruyi.model.mybatis.vo.ActiveVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface ActiveService {

    /**
     * 获取活动列表
     * @param pager
     * @return
     */
    public List<ActiveVo> getActiveList(Pager pager) throws Exception;

    /**
     * 搜索活动
     * @param pager
     * @param title
     * @param content
     * @return
     * @throws Exception
     */
    public List<ActiveVo> searchActive(Pager pager, String title, String content) throws Exception;

    /**
     * 获取活动详情
     * @param activeId
     * @return
     */
    public ActiveVo getActiveDetail(Long activeId) throws Exception;

    /**
     * 活动收藏
     * @param activeId
     * @param lawyerId
     * @throws Exception
     */
    public void activeStore(Long activeId, Long lawyerId) throws Exception;
}
