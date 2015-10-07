package com.orvyl.sample.swf.checkout.activities.api.domain;

import java.util.Date;

/**
 * Created by vyl on 10/2/15.
 */
public class Receipt {
    private String referenceNo;
    private Date date;
    private Boolean success;
    private String description;

    public Receipt(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Receipt() {
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "referenceNo='" + referenceNo + '\'' +
                ", date=" + date +
                ", success=" + success +
                ", description='" + description + '\'' +
                '}';
    }
}
