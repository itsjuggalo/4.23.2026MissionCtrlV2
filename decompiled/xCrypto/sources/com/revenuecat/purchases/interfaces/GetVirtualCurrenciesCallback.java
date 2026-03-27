package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;

/* JADX INFO: loaded from: classes3.dex */
public interface GetVirtualCurrenciesCallback {
    void onError(PurchasesError purchasesError);

    void onReceived(VirtualCurrencies virtualCurrencies);
}
