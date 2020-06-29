package cn.liuliang.javaeesys.service;

import cn.liuliang.javaeesys.domain.User;
import cn.liuliang.javaeesys.vo.MessageVo;

/**
 * 系统操作业务接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 16:57
 */
public interface ISysService {

    /**
     * 查询用户，通过账号密码
     * @param user 要查询的用户
     * @return 查询结果，空或是查询到的用户
     */
    MessageVo findUserByUserNameAndPassWord(User user);

}
