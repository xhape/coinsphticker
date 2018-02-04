package com.xhapesolutions.coinsphticker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

	private Timer timer;

	private Gson gson;
	private OkHttpClient client;

	private Market marketRate;
	private FeeByPriority feeByPriority;

	private TickerView buyPrice;
	private TickerView sellPrice;
	private TickerView feeLow;
	private TickerView feeNormal;
	private TickerView feeHigh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.timer = new Timer();

		this.gson = new Gson();
		this.client = new OkHttpClient.Builder().build();

		this.buyPrice = findViewById(R.id.buyPrice);
		this.sellPrice = findViewById(R.id.sellPrice);
		this.feeLow = findViewById(R.id.feeLow);
		this.feeNormal = findViewById(R.id.feeNormal);
		this.feeHigh = findViewById(R.id.feeHigh);

		this.buyPrice.setCharacterList(TickerUtils.getDefaultListForUSCurrency());
		this.sellPrice.setCharacterList(TickerUtils.getDefaultListForUSCurrency());

		this.feeLow.setCharacterList(TickerUtils.getDefaultNumberList());
		this.feeNormal.setCharacterList(TickerUtils.getDefaultNumberList());
		this.feeHigh.setCharacterList(TickerUtils.getDefaultNumberList());
	}

	@Override
	protected void onStart() {
		super.onStart();

		this.timer.schedule(new GetPriceTask(), 0, 30);
	}

	class GetPriceTask extends TimerTask {

		@Override
		public void run() {
			Call call = client.newCall(new Request.Builder().url("https://quote.coins.ph/v1/markets/BTC-PHP").build());

			try {
				Response response = call.execute();
				final ConversionRate conversionRate = gson.fromJson(response.body().string(), ConversionRate.class);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						marketRate = conversionRate.market;

						buyPrice.setText(String.format("Php %,d",  Integer.parseInt(marketRate.ask)), true);
						sellPrice.setText(String.format("Php %,d",  Integer.parseInt(marketRate.bid)), true);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}

			Call feeCall = client.newCall(new Request.Builder().url("https://api.coins.asia/v3/crypto-payments/fees/BTC/").build());

			try {
				Response response = feeCall.execute();
				final CryptoPaymentFeeResult fee = gson.fromJson(response.body().string(), CryptoPaymentFeeResult.class);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						feeByPriority = fee.getCryptoPaymentFee().getFeeByPriority();

						feeLow.setText(String.format("%,f BTC",  Double.parseDouble(feeByPriority.getLow().getFee())), true);
						feeNormal.setText(String.format("%,f BTC",  Double.parseDouble(feeByPriority.getNormal().getFee())), true);
						feeHigh.setText(String.format("%,f BTC",  Double.parseDouble(feeByPriority.getHigh().getFee())), true);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class ConversionRate {
		Market market;
	}

	private class Market {
		String bid;

		String ask;
	}
}
