package cn.liuliang.javaeesys.controller;

import cn.liuliang.javaeesys.domain.User;
import cn.liuliang.javaeesys.service.ISysService;
import cn.liuliang.javaeesys.utils.MyCache;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统操作控制类
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 17:39
 */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class SysController {
    @Autowired
    private ISysService iSysService;

    @Autowired
    private MyCache myCache;

    /**
     * 登入
     *
     * @param user 用户信息
     * @return 登入结果
     */
    @PostMapping("/login")
    public MessageVo login(User user) {
        MessageVo messageVo = iSysService.findUserByUserNameAndPassWord(user);
        if (null != messageVo.getObject()) {
            myCache.add("user",messageVo.getObject());
        }
        return messageVo;
    }

    /**
     * 注销
     *
     * @return 注销结果
     */
    @GetMapping("/loginOut")
    public MessageVo loginOut() {
        myCache.remove("user");
        return new MessageVo(true, "注销成功，请重新登入！", "");
    }

    @GetMapping("/getUserName")
    public MessageVo getUserName(HttpServletRequest request) {
        User user = (User) myCache.get("user");
        MessageVo messageVo = null;
        if (null == user) {
            messageVo = new MessageVo(false, "请先登入", "");
        } else {
            messageVo = new MessageVo(true, "", user);
        }
        return messageVo;
    }

}
