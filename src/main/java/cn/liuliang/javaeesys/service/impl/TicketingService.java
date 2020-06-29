package cn.liuliang.javaeesys.service.impl;

import cn.liuliang.javaeesys.dao.IQueryDao;
import cn.liuliang.javaeesys.dao.ITicketingDao;
import cn.liuliang.javaeesys.dao.ITrainDao;
import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.domain.Customer;
import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.service.ITicketingService;
import cn.liuliang.javaeesys.utils.PagingUtils;
import cn.liuliang.javaeesys.utils.dataProcessingUtils;
import cn.liuliang.javaeesys.vo.MessageVo;
import cn.liuliang.javaeesys.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 售票业务接口实现类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 13:03
 */
@Service
public class TicketingService implements ITicketingService {
    @Autowired
    private ITicketingDao iTicketingDao;
    @Autowired
    private IQueryDao iQueryDao;
    @Autowired
    private ITrainDao iTrainDao;

    @Override
    public MessageVo queryTicket(Condition condition, Integer per, Integer pageNumber) {
        MessageVo messageVo = new MessageVo(true, "查询成功！", null);
        List<Train> trainList = null;
        try {
            trainList = iQueryDao.findByCondition(condition);
        } catch (Exception e) {
            messageVo.setFlag(false);
            messageVo.setMessage("查询失败！");
            //错误处理
            e.printStackTrace();
        }
        if (null != trainList) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(condition.getDepartureTime());
            List<Train> newTrainList = new ArrayList<>();
            for (Train train : trainList) {
                String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(train.getDepartureTime());
                if (format1.contains(format)) {
                    newTrainList.add(train);
                }
            }
            List<Train> trains = dataProcessingUtils.TrainDataProcessing(newTrainList);
            PageResult pageResult = PagingUtils.getPageResult(trains, per, pageNumber, 8);
            messageVo.setObject(pageResult);
        }
        return messageVo;
    }


    @Override
    public MessageVo findTrainById(String trainId) {
        MessageVo messageVo = new MessageVo(true, "查询成功！", null);
        Train train = null;
        try {
            train = iTrainDao.findOne(trainId);
            Train dataProcessingOne = dataProcessingUtils.TrainDataProcessingOne(train);
            messageVo.setObject(dataProcessingOne);
        } catch (Exception e) {
            //错误处理
            messageVo.setFlag(false);
            messageVo.setMessage("查询失败！");
            e.printStackTrace();
        }
        return messageVo;
    }

    @Transactional//添加事务
    @Override
    public MessageVo buyTicket(Customer customer) {
        MessageVo messageVo = new MessageVo(true, "购票成功！", null);
        //补充购票id
        customer.setCustomerId(UUID.randomUUID().toString().replaceAll("-", ""));
        try {
            //根据购票人所选的列车id扣减余票
            iTrainDao.modifyVotes(customer.getTrainId(), -1);
            //添加购票人信息
            iTicketingDao.addCustomer(customer);
        } catch (Exception e) {
            messageVo.setFlag(false);
            messageVo.setMessage("购票失败！");
            //错误处理
            e.printStackTrace();
        }
        //返回结果
        return messageVo;
    }

}
