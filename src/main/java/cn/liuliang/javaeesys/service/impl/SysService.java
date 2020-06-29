package cn.liuliang.javaeesys.service.impl;

import cn.liuliang.javaeesys.dao.ISysDao;
import cn.liuliang.javaeesys.domain.User;
import cn.liuliang.javaeesys.service.ISysService;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统操作业务就扣实现类
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 16:58
 */
@Service
public class SysService implements ISysService {

    @Autowired
    private ISysDao iSysDao;


    /**
     * 查询用户，通过账号密码
     *
     * @param user 要查询的用户
     * @return 查询结果，空或是查询到的用户
     */
    @Override
    public MessageVo findUserByUserNameAndPassWord(User user) {
        User lodUser = iSysDao.findUserByUserNameAndPassWord(user);
        MessageVo messageVo = null;
        messageVo = new MessageVo(true, "登入成功！", lodUser);
        if (null == lodUser) {
            messageVo = new MessageVo(false, "用户名或密码错误", null);
        }
        return messageVo;
    }
}
