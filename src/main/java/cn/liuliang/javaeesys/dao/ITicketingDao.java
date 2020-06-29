package cn.liuliang.javaeesys.dao;

import cn.liuliang.javaeesys.domain.Customer;

/**
 * 售票dao接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 13:04
 */
public interface ITicketingDao {


    /**
     * 添加购票人信息
     * @param customer 购票人信息
     */
    void addCustomer(Customer customer);

}
