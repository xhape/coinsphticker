
package com.xhapesolutions.coinsphticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fee {

    @SerializedName("processing_time_estimate")
    @Expose
    private String processingTimeEstimate;

    @SerializedName("fee")
    @Expose
    private String fee;

    @SerializedName("min_amount")
    @Expose
    private String minAmount;

    @SerializedName("name")
    @Expose
    private String name;

    public String getProcessingTimeEstimate() {
        return processingTimeEstimate;
    }

    public void setProcessingTimeEstimate(String processingTimeEstimate) {
        this.processingTimeEstimate = processingTimeEstimate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
