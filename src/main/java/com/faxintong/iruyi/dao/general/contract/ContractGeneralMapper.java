package com.faxintong.iruyi.dao.general.contract;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by hehj on 15-1-29.
 */
@OperateMyBatis
public interface ContractGeneralMapper {

    @Update("update contract set status=#{status},update_date=now() where id=#{contractId}")
    public void updateContractStatus(@Param("contractId") Long contractId, @Param("status") Integer status) throws Exception;

}
