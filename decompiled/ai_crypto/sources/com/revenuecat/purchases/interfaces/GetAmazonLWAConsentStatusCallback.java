package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.PurchasesError;

/* JADX INFO: loaded from: classes2.dex */
public interface GetAmazonLWAConsentStatusCallback {
    void onError(PurchasesError purchasesError);

    void onSuccess(AmazonLWAConsentStatus amazonLWAConsentStatus);
}
