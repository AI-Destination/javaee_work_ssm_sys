package cn.liuliang.javaeesys.service;

import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.vo.MessageVo;

/**
 * 列车操作业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 20:59
 */
public interface ITrainService {

    /**
     * 添加列车车次
     *
     * @param train 列车车次信息
     * @return
     */
    MessageVo add(Train train);

    /**
     * 获取所有列车信息
     *
     * @param per        标志，1：上一页，2：下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 分页数据
     */
    MessageVo getAll(Integer per, Integer pageNumber);
}
