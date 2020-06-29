package cn.liuliang.javaeesys.service.impl;

import cn.liuliang.javaeesys.dao.ITrainDao;
import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.service.ITrainService;
import cn.liuliang.javaeesys.utils.PagingUtils;
import cn.liuliang.javaeesys.utils.dataProcessingUtils;
import cn.liuliang.javaeesys.vo.MessageVo;
import cn.liuliang.javaeesys.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * 列车操作业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 20:59
 */
@Component
public class TrainService implements ITrainService {
    @Autowired
    private ITrainDao iTrainDao;

    @Override
    public MessageVo add(Train train) {
        //处理数据
        //1，添加id
        train.setTrainId(UUID.randomUUID().toString().replaceAll("-", ""));
        train.setTrainNumber(train.getTrainType() + train.getTrainMark());
        train.setTicketsLeft(train.getBusload());
        train.setDepartureTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(train.getDepartureTime()));
        MessageVo messageVo = null;
        try {
            iTrainDao.add(train);
            messageVo = new MessageVo(true, "添加成功！", "");
        } catch (Exception e) {
            //错误处理
            messageVo = new MessageVo(true, "添加失败！", "");
            e.printStackTrace();
        }
        return messageVo;
    }

    @Override
    public MessageVo getAll(Integer per, Integer pageNumber) {
        MessageVo messageVo = new MessageVo(true, "查询成功！", null);
        List<Train> trainList = null;
        PageResult pageResult = null;
        try {
            trainList = iTrainDao.findAll();
        } catch (Exception e) {
            //错误处理
            messageVo.setFlag(false);
            messageVo.setMessage("查询失败！");
            e.printStackTrace();

        }
        //判断是否为空
        if (null != trainList) {
            //进行分页
            pageResult = PagingUtils.getPageResult(dataProcessingUtils.TrainDataProcessing(trainList), per, pageNumber, 10);
        }
        //设置返回数据
        messageVo.setObject(pageResult);
        return messageVo;
    }
}
