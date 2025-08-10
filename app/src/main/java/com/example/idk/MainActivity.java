package com.example.idk;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

// import com.example.idk.R; // R hatası olursa aç

public class MainActivity extends Activity {

    private InterstitialAd mInterstitialAd;
    private final String TAG = "MainActivity";

    

    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,
			"ca-app-pub-3940256099942544/1033173712", // Test ID
			adRequest,
			new InterstitialAdLoadCallback() {
				@Override
				public void onAdLoaded(InterstitialAd interstitialAd) {
					mInterstitialAd = interstitialAd;
					Log.d(TAG, "Reklam yüklendi.");
					showInterstitialAd();
				}

				@Override
				public void onAdFailedToLoad(LoadAdError adError) {
					Log.d(TAG, "Reklam yüklenemedi. Hata: " + adError.getMessage());
					mInterstitialAd = null;
				}
			});
    }

    private void showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
					@Override
					public void onAdDismissedFullScreenContent() {
						loadInterstitialAd();
					}

					@Override
					public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
						Log.d(TAG, "Reklam gösterilemedi. Hata: " + adError.getMessage());
					}

					@Override
					public void onAdShowedFullScreenContent() {
						mInterstitialAd = null;
					}
				});
            mInterstitialAd.show(MainActivity.this);
        } else {
            Log.d(TAG, "Reklam henüz hazır değil.");
        }
    }
}
