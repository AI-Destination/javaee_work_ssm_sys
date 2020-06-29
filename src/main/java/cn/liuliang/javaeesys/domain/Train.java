package cn.liuliang.javaeesys.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 列车信息
 *
 * @author liuliang-刘亮
 * @date 2020/6/18 - 14:18
 */
public class Train {
    /**
     * id
     */
    private String trainId;
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
     * 出发时间（2020-6-28 09:30）
     */
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date departureTime;
    private String departureTimeString;
    /**
     * 起点站
     */
    private String originStation;
    /**
     * 终点站
     */
    private String destination;
    /**
     * 行车时间
     */
    private Double travelTime;
    /**
     * 载客量
     */
    private Integer busload;
    /**
     * 余票
     */
    private Integer ticketsLeft;

    public String getDepartureTimeString() {
        return departureTimeString;
    }

    public void setDepartureTimeString(String departureTimeString) {
        this.departureTimeString = departureTimeString;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", trainType='" + trainType + '\'' +
                ", trainMark='" + trainMark + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", departureTime=" + departureTime +
                ", originStation='" + originStation + '\'' +
                ", destination='" + destination + '\'' +
                ", travelTime=" + travelTime +
                ", busload=" + busload +
                ", ticketsLeft=" + ticketsLeft +
                '}';
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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

    public Double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Double travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getBusload() {
        return busload;
    }

    public void setBusload(Integer busload) {
        this.busload = busload;
    }

    public Integer getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(Integer ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }
}
