package cn.liuliang.javaeesys.service;

import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.vo.MessageVo;

/**
 * 综合查询业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 8:50
 */
public interface IQueryService {


    /**
     * 多条件综合查询
     *
     * @param condition  条件
     * @param per        标志，1：上一页，2：下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 结果
     */
    MessageVo findByCondition(Condition condition, Integer per, Integer pageNumber);

}
