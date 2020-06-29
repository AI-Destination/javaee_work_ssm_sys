package cn.liuliang.javaeesys.dao;

import cn.liuliang.javaeesys.domain.User;

/**
 * 系统相关操作dao接口
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 16:41
 */
public interface ISysDao {

    /**
     * 查询用户，通过账号密码
     * @param user 要查询的用户
     * @return 查询结果，空或是查询到的用户
     */
    User findUserByUserNameAndPassWord(User user);

}
