package com.cdxyj.reputation.util;

import java.io.Serializable;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
public class AjaxResultPo implements Serializable {
    private static final long serialVersionUID = -4148768233386711389L;
    private boolean success;
    private String msg;
    private long total = -1;
    private Object rows;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public AjaxResultPo() {
    }

    public static AjaxResultPo failed(Exception e) {
        return new AjaxResultPo(false, e.getMessage());
    }

    public static AjaxResultPo failure(String message) {
        return new AjaxResultPo(false, message);
    }

    public AjaxResultPo(boolean success, String meassage) {
        super();
        this.success = success;
        this.msg = meassage;
    }
}
