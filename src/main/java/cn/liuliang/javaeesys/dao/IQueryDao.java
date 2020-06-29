package cn.liuliang.javaeesys.dao;

import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.domain.Train;

import java.util.List;

/**
 * 综合查询dao
 * @author liuliang-刘亮
 * @date 2020/6/22 - 8:51
 */
public interface IQueryDao {

    List<Train> findByCondition(Condition condition);
}
