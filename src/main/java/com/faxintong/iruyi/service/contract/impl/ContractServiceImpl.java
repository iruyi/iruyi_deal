package com.faxintong.iruyi.service.contract.impl;

import com.faxintong.iruyi.dao.general.contract.ContractGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.contract.ContractMapper;
import com.faxintong.iruyi.model.mybatis.contract.Contract;
import com.faxintong.iruyi.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.faxintong.iruyi.utils.Constants.CONTRACT_COMMENTED;

/**
 * Created by hehj on 15-1-6.
 */
@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ContractGeneralMapper contractGeneralMapper;

    @Override
    public void signContract(Contract contract) throws Exception {
        contractMapper.insertSelective(contract);
    }

    @Override
    public void confirmContract(Long contractId) throws Exception {
        contractGeneralMapper.updateContractStatus(contractId, CONTRACT_COMMENTED);
    }

}
