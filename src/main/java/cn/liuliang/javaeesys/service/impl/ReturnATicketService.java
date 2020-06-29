package cn.liuliang.javaeesys.service.impl;

import cn.liuliang.javaeesys.dao.IReturnATicketDao;
import cn.liuliang.javaeesys.dao.ITrainDao;
import cn.liuliang.javaeesys.service.IReturnATicketService;
import cn.liuliang.javaeesys.utils.PagingUtils;
import cn.liuliang.javaeesys.utils.dataProcessingUtils;
import cn.liuliang.javaeesys.vo.MessageVo;
import cn.liuliang.javaeesys.vo.PageResult;
import cn.liuliang.javaeesys.vo.RefundResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 退票业务接口实现类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 16:39
 */
@Service
public class ReturnATicketService implements IReturnATicketService {
    @Autowired
    private IReturnATicketDao iReturnATicketDao;
    @Autowired
    private ITrainDao iTrainDao;

    @Override
    public MessageVo findAllTicketByIdCard(String idCard, Integer per, Integer pageNumber) {
        MessageVo messageVo = new MessageVo(true, "查询成功！", null);
        List<RefundResultSet> refundResultSetList = null;
        try {
            refundResultSetList = iReturnATicketDao.findAllTicketByIdCard(idCard);
        } catch (Exception e) {
            //错误处理
            messageVo.setFlag(false);
            messageVo.setMessage("查询失败！");
            e.printStackTrace();
        }
        List<RefundResultSet> refundResultSets = null;
        if (refundResultSetList != null) {
            refundResultSets = dataProcessingUtils.TicketDataProcessing(refundResultSetList);
        }
        //数据封装
        PageResult pageResult = PagingUtils.getPageResult(refundResultSets, per, pageNumber, 8);
        messageVo.setObject(pageResult);
        return messageVo;
    }

    @Transactional
    @Override
    public MessageVo returnATicket(String trainId, String customerId) {
        MessageVo messageVo = new MessageVo(true, "退票成功！", null);
        try {
            //删除购票信息
            iReturnATicketDao.deleteCustomerById(customerId);
            //给列车加票
            iTrainDao.modifyVotes(trainId,1);
        } catch (Exception e) {
            //错误处理
            messageVo.setFlag(false);
            messageVo.setMessage("退票失败！");
            e.printStackTrace();
        }
        return messageVo;
    }
}
