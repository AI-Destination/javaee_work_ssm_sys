package cn.liuliang.javaeesys.utils;

import cn.liuliang.javaeesys.domain.Train;
import cn.liuliang.javaeesys.vo.RefundResultSet;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 数据处理
 *
 * @author liuliang-刘亮
 * @date 2020/6/22 - 9:14
 */
public class dataProcessingUtils {

    /**
     * 列车信息数据处理（多数据）
     *
     * @param trainList 原始列车信息
     * @return 处理后的列车信息
     */
    public static List<Train> TrainDataProcessing(List<Train> trainList) {
        //判断是否为空
        if (null != trainList) {
            //处理列车是否发车
            for (Train train : trainList) {
                train.setTrainNumber(train.getTrainType() + train.getTrainMark());
                if (System.currentTimeMillis() > train.getDepartureTime().getTime()) {
                    train.setDepartureTimeString("已发出");
                } else {
                    String string = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(train.getDepartureTime());
                    train.setDepartureTimeString(string);
                }
            }
        }
        return trainList;
    }

    /**
     * 列车信息数据处理（单数据）
     * @param train 原始列车信息
     * @return 处理后的数据
     */
    public static Train TrainDataProcessingOne(Train train) {
        //判断是否为空
        if (null != train) {
            train.setTrainNumber(train.getTrainType() + train.getTrainMark());
            if (System.currentTimeMillis() > train.getDepartureTime().getTime()) {
                train.setDepartureTimeString("已发出");
            } else {
                String string = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(train.getDepartureTime());
                train.setDepartureTimeString(string);
            }
        }
        return train;
    }

    public static List<RefundResultSet> TicketDataProcessing(List<RefundResultSet> refundResultSetList) {
        //判断是否为空
        if (null != refundResultSetList) {
            //处理列车是否发车
            for (RefundResultSet refundResultSet : refundResultSetList) {
                refundResultSet.setTrainNumber(refundResultSet.getTrainType() + refundResultSet.getTrainMark());
                if (System.currentTimeMillis() > refundResultSet.getDepartureTime().getTime()) {
                    refundResultSet.setDepartureTimeString("已发出");
                } else {
                    String string = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(refundResultSet.getDepartureTime());
                    refundResultSet.setDepartureTimeString(string);
                }
            }
        }
        return refundResultSetList;
    }

}
