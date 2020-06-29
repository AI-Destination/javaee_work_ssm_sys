package cn.liuliang.javaeesys.controller;

import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.service.IQueryService;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 综合查询控制类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 8:45
 */
@CrossOrigin
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private IQueryService iQueryService;

    /**
     * 综合查询
     *
     * @param condition 查询条件
     * @return 结果对象
     */
    @PostMapping("/")
    public MessageVo query(Condition condition,
                           @RequestParam(value = "per", required = false, defaultValue = "3") Integer per,
                           @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber) {
        return iQueryService.findByCondition(condition, per, pageNumber);
    }

}
