package com.binblink.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * @Description 报文样例
 * @Author binblink
 * @Date 2020/12/30 11:13
 */
public class GenericDTO<T> {

    /**
     * 请求流水号
     */
    private String requestId;
    /**
     * 交易流水号
     */
    private String msgId;
    /**
     * 调用链唯一标识
     */
    private String traceId;

    /** 调用链Span唯一标识 */
    private String spanId;

    /** 当前Span的父ID */
    private String parentSpanId;
    /**
     * 记账日期
     */
    private LocalDate accDate;
    /**
     * 交易发起时间
     */
    private LocalDateTime startDateTime;

    /**
     * 交易结束时间
     */
    private LocalDateTime endDateTime;
    /**
     * 区域
     */
    private Locale locale;
    /**
     * 路径信息，用|隔开
     */
    private String routeInfo;
    /**
     * 登录用户ID
     */
    private String userId;


    private String clientIp;


    private String source;


    private String channel;


    private String business;


    private String uri;


    private String token;


    private String loginName;

    /**
     * 交易核算单元
     */
    private Long trBr;

    /**
     *  顺序号 - 用于表示当前交易在整个服务调用链中的顺序
     */
    private Integer seq;

    private T body;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getParentSpanId() {
        return parentSpanId;
    }

    public void setParentSpanId(String parentSpanId) {
        this.parentSpanId = parentSpanId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public LocalDate getAccDate() {
        return accDate;
    }

    public void setAccDate(LocalDate accDate) {
        this.accDate = accDate;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getRouteInfo() {
        return routeInfo;
    }

    public void setRouteInfo(String routeInfo) {
        this.routeInfo = routeInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
