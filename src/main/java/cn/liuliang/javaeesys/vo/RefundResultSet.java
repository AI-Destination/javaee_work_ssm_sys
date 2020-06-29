package cn.liuliang.javaeesys.vo;

import java.util.Date;

/**
 * 退票结果集
 *
 * @author liuliang-刘亮
 * @date 2020/6/20 - 13:59
 */
public class RefundResultSet {
    //列车id
    private String customerId;
    private String trainId;
    private String name;
    private String idCard;
    private String trainType;
    private String trainMark;
    private String trainNumber;
    private Date departureTime;
    private String departureTimeString;
    private String departureTimeStr;
    private String originStation;
    private String destination;
    private String seatType;

    @Override
    public String toString() {
        return "RefundResultSet{" +
                "customerId='" + customerId + '\'' +
                ", trainId='" + trainId + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", trainType='" + trainType + '\'' +
                ", trainMark='" + trainMark + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeString='" + departureTimeString + '\'' +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", originStation='" + originStation + '\'' +
                ", destination='" + destination + '\'' +
                ", seatType='" + seatType + '\'' +
                '}';
    }

    public String getDepartureTimeString() {
        return departureTimeString;
    }

    public void setDepartureTimeString(String departureTimeString) {
        this.departureTimeString = departureTimeString;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getDepartureTimeStr() {
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
