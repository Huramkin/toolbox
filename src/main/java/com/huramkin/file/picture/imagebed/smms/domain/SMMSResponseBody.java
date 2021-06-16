package com.huramkin.file.picture.imagebed.smms.domain;

import java.util.Arrays;

public class SMMSResponseBody {
    private Boolean success;
    private String code;
    private String message;
    private SMMSRespFieldData data;
    private String RequestId;

    public SMMSResponseBody() {
    }

    public SMMSResponseBody(Boolean success, String code, String message, SMMSRespFieldData data, String requestId) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        RequestId = requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SMMSRespFieldData getData() {
        return data;
    }

    public void setData(SMMSRespFieldData data) {
        this.data = data;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    @Override
    public String toString() {
        return "SMMSResponseBody{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", RequestId='" + RequestId + '\'' +
                '}';
    }
}
