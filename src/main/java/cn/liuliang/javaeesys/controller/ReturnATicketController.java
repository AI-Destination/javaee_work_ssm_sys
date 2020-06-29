package cn.liuliang.javaeesys.controller;

import cn.liuliang.javaeesys.service.IReturnATicketService;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 退票控制器类
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 16:34
 */
@CrossOrigin
@RestController
@RequestMapping("/returnATicket")
public class ReturnATicketController {
    @Autowired
    private IReturnATicketService iReturnATicketService;


    /**
     * 根据客户身份证号码查购票记录
     *
     * @param idCard     身份证号码
     * @param per        标志，1：上一页，2下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 结果
     */
    @GetMapping("/")
    public MessageVo findCustomerByIdCard(String idCard,
                                          @RequestParam(value = "per", required = false, defaultValue = "3") Integer per,
                                          @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber) {
        return iReturnATicketService.findAllTicketByIdCard(idCard, per, pageNumber);
    }

    /**
     * 退票
     *
     * @param trainId    列车id
     * @param customerId 购票信息id
     * @return 结果
     */
    @GetMapping("/returnATicket")
    public MessageVo returnATicket(String trainId, String customerId) {
        return iReturnATicketService.returnATicket(trainId, customerId);
    }


}
