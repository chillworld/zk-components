package com.deslin;

import java.io.Serializable;


public class GenericNameValuePair implements Serializable {

    private static final long serialVersionUID = -1285983452674328922L;
    private String code;
    private String label;
    private String field3;
    private String field4;

    public GenericNameValuePair() {
    }

    public GenericNameValuePair(String p_code, String p_label) {
        setCode(p_code);
        setLabel(p_label);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }
}
