package cn.liuliang.javaeesys.controller;

import cn.liuliang.javaeesys.domain.Condition;
import cn.liuliang.javaeesys.domain.Customer;
import cn.liuliang.javaeesys.service.ITicketingService;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 售票控制类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 10:41
 */
@CrossOrigin
@RestController
@RequestMapping("/ticketing")
public class TicketingController {
    @Autowired
    private ITicketingService iTicketingService;

    /**
     * 查询列车票 ， 分页
     *
     * @param condition  条件
     * @param per        标志，1：上一页，2：下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 结果
     */
    @PostMapping("/")
    public MessageVo queryTicket(Condition condition,
                                 @RequestParam(value = "per", required = false, defaultValue = "3") Integer per,
                                 @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber
    ) {
        return iTicketingService.queryTicket(condition, per, pageNumber);
    }

    /**
     * 加载购票信息
     *
     * @param trainId 列车id
     * @return
     */
    @GetMapping("/")
    public MessageVo loadTicketInformation(String trainId) {
        return iTicketingService.findTrainById(trainId);
    }

    @PostMapping("/buy")
    public MessageVo buyTicket(Customer customer) {
        return iTicketingService.buyTicket(customer);
    }

}
