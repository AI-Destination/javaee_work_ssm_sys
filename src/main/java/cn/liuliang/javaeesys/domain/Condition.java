package cn.liuliang.javaeesys.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 查询条件对象
 *
 * @author liuliang-刘亮
 * @date 2020/6/19 - 10:28
 */
public class Condition {

    /**
     * 列车类型（T，G，...）
     */
    private String trainType;
    /**
     * 列车号（001，002，...）
     */
    private String trainMark;
    /**
     * 车次 = 列车类型 + 列车号
     */
    private String trainNumber;
    /**
     * 起点站
     */
    private String originStation;
    /**
     * 终点站
     */
    private String destination;

    /**
     * 出发时间（2020-6-28 09:30）
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date departureTime;
    private String departureTimeString;

    @Override
    public String toString() {
        return "Condition{" +
                "trainType='" + trainType + '\'' +
                ", trainMark='" + trainMark + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", originStation='" + originStation + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeString='" + departureTimeString + '\'' +
                '}';
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeString() {
        return departureTimeString;
    }

    public void setDepartureTimeString(String departureTimeString) {
        this.departureTimeString = departureTimeString;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getTrainMark() {
        return trainMark;
    }

    public void setTrainMark(String trainMark) {
        this.trainMark = trainMark;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getOriginStation() {
        return originStation;
    }

    public void setOriginStation(String originStation) {
        this.originStation = originStation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
