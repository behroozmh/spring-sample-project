package ir.behi.phonebook.exception;

public class ServiceException extends RuntimeException {
    private String key;
    private String code;
    private Integer status;

    public ServiceException(){

    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(String message, String key, String code) {
        super(message);
        this.key = key;
        this.code = code;
    }

    public ServiceException(String message, String key, String code,Integer status) {
        super(message);
        this.key = key;
        this.code = code;
        this.status = status;
    }

    public ServiceException( String key, String code) {
        this.key = key;
        this.code = code;
    }

    public ServiceException( String key, String code,Integer status) {
        this.key = key;
        this.code = code;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
