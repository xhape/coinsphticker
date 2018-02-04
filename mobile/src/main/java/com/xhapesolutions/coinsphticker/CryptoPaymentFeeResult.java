
package com.xhapesolutions.coinsphticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoPaymentFeeResult {

    @SerializedName("crypto-payment-fee")
    @Expose
    private CryptoPaymentFee cryptoPaymentFee;

    public CryptoPaymentFee getCryptoPaymentFee() {
        return cryptoPaymentFee;
    }

    public void setCryptoPaymentFee(CryptoPaymentFee cryptoPaymentFee) {
        this.cryptoPaymentFee = cryptoPaymentFee;
    }

}
