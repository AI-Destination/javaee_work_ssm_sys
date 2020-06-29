package cn.liuliang.javaeesys.dao;

import cn.liuliang.javaeesys.domain.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 列车操作dao接口
 * @author liuliang-刘亮
 * @date 2020/6/21 - 21:00
 */
public interface ITrainDao {
    /**
     * 添加列车
     * @param train 列车信息
     */
    void add(Train train);

    /**
     * 查询所有列车
     * @return 所有列车信息
     */
    List<Train> findAll();

    /**
     * 查询列车通过id
     * @param trainId 列车id
     * @return 列车信息
     */
    Train findOne(String trainId);

    /**
     * 根据列车id修改票数
     * @param trainId 列车id
     * @param i 扣减值或相加值
     */
    void modifyVotes(@Param("trainId") String trainId,@Param("i") int i);
}
