package cn.liuliang.javaeesys.dao;

import cn.liuliang.javaeesys.vo.RefundResultSet;

import java.util.List;

/**
 * 退票dao接口类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 16:40
 */
public interface IReturnATicketDao {

    /**
     * 根据身份证号码查询购票记录
     * @param idCard 身份证号码
     * @return 购票记录
     */
    List<RefundResultSet> findAllTicketByIdCard(String idCard);

    /**
     * 删除购票信息
     * @param customerId 购票id
     */
    void deleteCustomerById(String customerId);
}
