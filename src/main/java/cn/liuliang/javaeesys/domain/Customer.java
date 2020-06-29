package cn.liuliang.javaeesys.domain;

/**
 * 购票人信息
 *
 * @author liuliang-刘亮
 * @date 2020/6/18 - 14:25
 */
public class Customer {

    /**
     * id
     */
    private String customerId;
    /**
     * 购票人姓名
     */
    private String name;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 座位类型
     */
    private String seatType;
    /**
     * 列车id
     */
    private String trainId;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", seatType='" + seatType + '\'' +
                ", trainId=" + trainId +
                '}';
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
}
