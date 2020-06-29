package cn.liuliang.javaeesys.service;

import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.domain.Customer;
import cn.liuliang.javaeesys.vo.MessageVo;

/**
 * 售票业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 13:02
 */
public interface ITicketingService {

    /**
     * 查询列车车票
     *
     * @param condition  条件
     * @param per        标志，1：上一页，2：下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 结果
     */
    MessageVo queryTicket(Condition condition, Integer per, Integer pageNumber);

    /**
     * 查询列车信息
     *
     * @param trainId 列车id
     * @return 结果
     */
    MessageVo findTrainById(String trainId);

    /**
     * 购票
     *
     * @param customer 购票人信息
     * @return 购票结果
     */
    MessageVo buyTicket(Customer customer);

}
