package cn.liuliang.javaeesys.vo;

/**
 * 消息对象
 *
 * @author liuliang-刘亮
 * @date 2020/6/21 - 17:17
 */
public class MessageVo {
    private boolean flag;
    private String message;
    private Object object;
    public MessageVo() {
    }

    public MessageVo(boolean flag, String message , Object object) {
        this.flag = flag;
        this.message = message;
        this.object = object;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                '}';
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
