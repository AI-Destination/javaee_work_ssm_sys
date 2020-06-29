package cn.liuliang.javaeesys.controller;

import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.service.ITrainService;
import cn.liuliang.javaeesys.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuliang-刘亮
 * @date 2020/6/21 - 15:48
 */
@CrossOrigin
@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private ITrainService iTrainService;

    /**
     * 添加列车
     *
     * @param train 列车信息
     * @return 返回信息对象
     */
    @PostMapping("/")
    public MessageVo addTrain(Train train) {
        return iTrainService.add(train);
    }

    /**
     * 分页获取所有列车信息
     *
     * @param per        标志，1：上一页，2：下一页，3或以上第一页
     * @param pageNumber 当前页
     * @return 返回信息对象
     */
    @GetMapping("/")
    public MessageVo getAll(@RequestParam(value = "per", required = false, defaultValue = "3") Integer per,
                            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber) {
        return iTrainService.getAll(per, pageNumber);
    }

}
