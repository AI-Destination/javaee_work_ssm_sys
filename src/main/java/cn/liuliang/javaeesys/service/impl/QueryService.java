package cn.liuliang.javaeesys.service.impl;

import cn.liuliang.javaeesys.dao.IQueryDao;
import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.service.IQueryService;
import cn.liuliang.javaeesys.utils.PagingUtils;
import cn.liuliang.javaeesys.utils.dataProcessingUtils;
import cn.liuliang.javaeesys.vo.MessageVo;
import cn.liuliang.javaeesys.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 综合查询业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 8:51
 */
@Service
public class QueryService implements IQueryService {

    @Autowired
    private IQueryDao iQueryDao;


    @Override
    public MessageVo findByCondition(Condition condition, Integer per, Integer pageNumber) {
        //条件补充
        if (condition.getTrainNumber() !=""){
            condition.setTrainType(condition.getTrainNumber().substring(0, 1));
            condition.setTrainMark(condition.getTrainNumber().substring(1));
        }
        MessageVo messageVo = new MessageVo(true, "查询成功！", null);
        try {
            //查询
            List<Train> trainList = iQueryDao.findByCondition(condition);
            //处理数据
            List<Train> trainList1 = dataProcessingUtils.TrainDataProcessing(trainList);
            //分页
            PageResult pageResult = PagingUtils.getPageResult(trainList1, per, pageNumber, 8);
            //设置结果
            messageVo.setObject(pageResult);
        } catch (Exception e) {
            //错误处理
            messageVo.setFlag(false);
            messageVo.setMessage("查询失败！");
            e.printStackTrace();
        }
        //返回数据
        return messageVo;
    }
}
