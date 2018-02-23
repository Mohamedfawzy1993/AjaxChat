package Beans;

public class Message {

    private String ids;
    private String sender;
    private String msg;

    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return ids;
    }

    public void setId(String id) {
        this.ids = id;
    }
}
