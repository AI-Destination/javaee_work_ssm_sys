package cn.liuliang.javaeesys.utils;

import cn.liuliang.javaeesys.vo.PageResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 *
 * @author liuliang-刘亮
 * @date 2020/6/19 - 20:41
 */
public class PagingUtils {

    /**
     * 分页工具
     *
     * @param objectList 数据
     * @param per        标志，1：上一页，2：下一页 ， 3或以上第一页
     * @param pageNumber 当前页面
     * @param number     每页数目
     * @return 返回分页数据
     */
    public static PageResult getPageResult(List<?> objectList, Integer per, Integer pageNumber, Integer number) {
        List<Object> newTrainList = new ArrayList<>();
        //总条数
        int total = objectList.size();
        //总页数
        int pages = total / number;
        if (total % number != 0) {
            pages += 1;
        }
        //当前页
        if (1 == per) {
            //上一页
            if (pageNumber <= 1) {
                pageNumber = 1;
            } else {
                pageNumber -= 1;
            }
        } else if (2 == per) {
            //下一页
            if (pageNumber >= pages) {
                pageNumber = pages;
            } else {
                pageNumber += 1;
            }
        } else {
            pageNumber = 1;
        }
        //根据页码或取number条数据
        for (int i = 0; i < objectList.size(); i++) {
            if ((i + 1) > ((pageNumber - 1) * number) && (i + 1) <= (pageNumber * number)) {
                newTrainList.add(objectList.get(i));
            }
        }
        //封装分页对象
        PageResult pageResult = new PageResult();
        pageResult.setTotal(total);
        pageResult.setPages(pages);
        pageResult.setPageNum(pageNumber);
        pageResult.setObjectList(newTrainList);
        //返回数据
        return pageResult;
    }

}
