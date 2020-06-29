package cn.liuliang.javaeesys.service;

import cn.liuliang.javaeesys.vo.MessageVo;

/**
 * 退票业务接口类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 16:38
 */
public interface IReturnATicketService {

    /**
     * 查询所有购票记录通过身份证号码
     *
     * @param idCard     身份证号码
     * @param per        标志，1：上一页，2下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 结果
     */
    MessageVo findAllTicketByIdCard(String idCard, Integer per, Integer pageNumber);

    /**
     * 退票
     * @param trainId 列车id
     * @param customerId 购票信息id
     * @return 结果
     */
    MessageVo returnATicket(String trainId, String customerId);

}
