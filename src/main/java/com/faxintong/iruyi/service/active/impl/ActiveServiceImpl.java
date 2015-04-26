package com.faxintong.iruyi.service.active.impl;

import com.faxintong.iruyi.dao.general.ActiveGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.active.ActiveMapper;
import com.faxintong.iruyi.dao.mybatis.active.ActivePraiseMapper;
import com.faxintong.iruyi.dao.mybatis.active.ActiveStoreMapper;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.active.ActivePraiseExample;
import com.faxintong.iruyi.model.mybatis.active.ActiveStore;
import com.faxintong.iruyi.model.mybatis.active.ActiveStoreExample;
import com.faxintong.iruyi.model.mybatis.vo.ActiveVo;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.utils.Pager;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    private ActiveGeneralMapper activeGeneralMapper;

    @Autowired
    private ActiveMapper activeMapper;

    @Autowired
    private ActiveStoreMapper activeStoreMapper;

    @Autowired
    private ActivePraiseMapper activePraiseMapper;


    @Override
    public List<ActiveVo> getActiveList(Pager pager) throws Exception {
        List<Active> list = activeGeneralMapper.getActiveList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize());
        List<ActiveVo> activeVoList = new ArrayList<ActiveVo>();
        if(list != null && list.size() > 0){
            for(Active active : list){
                ActivePraiseExample example = new ActivePraiseExample();
                example.createCriteria().andActiveIdEqualTo(active.getId());
                Integer count = activePraiseMapper.countByExample(example);
                ActiveVo activeVo = new ActiveVo();
                activeVo.setPraiseCount(count);
                PropertyUtils.copyProperties(activeVo, active);
                activeVoList.add(activeVo);
            }
        }
        return activeVoList;
    }

    @Override
    public ActiveVo getActiveDetail(Long activeId) throws Exception {
        ActiveVo activeVo = new ActiveVo();
        Active active = activeMapper.selectByPrimaryKey(activeId);
        ActiveStoreExample example = new ActiveStoreExample();
        example.createCriteria().andActiveIdEqualTo(activeId);
        Integer count = activeStoreMapper.countByExample(example);
        if(count != null && count.intValue() > 0){
            activeVo.setIsCollect(1);//已关注
        }else{
            activeVo.setIsCollect(0);//未关注
        }
        List<String> photoList = activeGeneralMapper.getPhotoList(activeId);
        activeVo.setAttentionPhotos(photoList);
        BeanUtils.copyProperties(activeVo, active);
        return activeVo;
    }

    @Override
    public void activeStore(Long activeId, Long lawyerId) throws Exception {
        ActiveStore activeStore = new ActiveStore();
        activeStore.setLawyerId(lawyerId);
        activeStore.setActiveId(activeId);
        activeStoreMapper.insertSelective(activeStore);
    }
}
