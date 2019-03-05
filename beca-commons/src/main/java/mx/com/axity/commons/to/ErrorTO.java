package mx.com.axity.commons.to;

import java.io.Serializable;

public class ErrorTO implements Serializable{
    private Long code;
    private String message;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
