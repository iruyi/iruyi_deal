package com.faxintong.iruyi.dao.general.order;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by hehj on 15-1-18.
 */
@OperateMyBatis
public interface OrderGeneralMapper {

    @Update("update `order` set status=#{status},update_date=now() where id=#{orderId}")
    public void updateOrderStatus(@Param("orderId") Long orderId, @Param("status") Integer status) throws Exception;

}
