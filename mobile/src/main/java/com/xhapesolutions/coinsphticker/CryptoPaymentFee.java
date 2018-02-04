
package com.xhapesolutions.coinsphticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoPaymentFee {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("expires_in_seconds")
    @Expose
    private Integer expiresInSeconds;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("fee_by_priority")
    @Expose
    private FeeByPriority feeByPriority;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(Integer expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public FeeByPriority getFeeByPriority() {
        return feeByPriority;
    }

    public void setFeeByPriority(FeeByPriority feeByPriority) {
        this.feeByPriority = feeByPriority;
    }

}
