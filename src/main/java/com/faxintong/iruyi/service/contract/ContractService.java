package com.faxintong.iruyi.service.contract;

import com.faxintong.iruyi.model.mybatis.contract.Contract;

/**
 * Created by hehj on 15-1-6.
 */
public interface ContractService {

    /**
     * 签合同
     * @param contract
     * @throws Exception
     */
    public void signContract(Contract contract) throws Exception;

    /**
     * 确认签署合同的合法性
     * @param contractId
     * @throws Exception
     */
    public void confirmContract(Long contractId) throws Exception;
}
