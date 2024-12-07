package project.logistics.constant;

public enum StatusMessagesEnum {
    STATUS_SUCCESS("SUCCESS"),
    STATUS_FAILED("FAILED");

    private final String msg;

    StatusMessagesEnum(String msg){
        this.msg=msg;
    }

    public String msg() {
        return msg;
    }
}
