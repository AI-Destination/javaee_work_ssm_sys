package cn.liuliang.javaeesys.vo;

import java.util.List;

/**
 * 分页结果集对象
 * @author liuliang-刘亮
 * @date 2020/6/19 - 8:53
 */
public class PageResult<T> {

    private Integer total;
    private Integer pageNum;
    private Integer pages;
    private List<T> objectList;


    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", pageNum=" + pageNum +
                ", pages=" + pages +
                ", trainList=" + objectList +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }
}
