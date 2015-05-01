package com.faxintong.iruyi.service.microview;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.microview.Microview;
import com.faxintong.iruyi.model.mybatis.vo.ViewVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface ViewService {

    /**
     * 获取微访谈话题列表
     * @param pager
     * @return
     *
     * @TODO  表缺少字段 结束时间，因此无法给出是否在直播标识，后台写死了1
     */
    public List<ViewVo> getViewList(Pager pager,Long lawyerId) throws Exception;

    /**
     * 查看微访谈详情
     * @param microViewId
     * @return
     */
    public ViewVo viewDetail(Long microViewId,Long lawyerId,Pager pager) throws Exception;

    /**
     * 关注微访谈
     * @param microViewId
     * @param lawyerId
     */
    public void viewAttention(Long microViewId, Long lawyerId) throws Exception;

    /**
     * 微访谈提问回答
     * @param lawyer
     * @param microViewId
     * @param content
     * @param type
     * @return
     */
    public void viewDiscuss(Lawyer lawyer, Long microViewId, String content, Integer type) throws Exception;

    /**
     * 访谈讨论点赞
     * @param discussId
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public void discussPraise(Long discussId, Long lawyerId) throws Exception;

}
