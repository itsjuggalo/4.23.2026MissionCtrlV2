package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;

/* JADX INFO: loaded from: classes2.dex */
public interface ReceiveOfferingsCallback {
    void onError(PurchasesError purchasesError);

    void onReceived(Offerings offerings);
}
