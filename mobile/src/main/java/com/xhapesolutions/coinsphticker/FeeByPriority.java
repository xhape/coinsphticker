
package com.xhapesolutions.coinsphticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeeByPriority {

    @SerializedName("high")
    @Expose
    private Fee high;

    @SerializedName("low")
    @Expose
    private Fee low;

    @SerializedName("normal")
    @Expose
    private Fee normal;

    public Fee getHigh() {
        return high;
    }

    public void setHigh(Fee high) {
        this.high = high;
    }

    public Fee getLow() {
        return low;
    }

    public void setLow(Fee low) {
        this.low = low;
    }

    public Fee getNormal() {
        return normal;
    }

    public void setNormal(Fee normal) {
        this.normal = normal;
    }

}
