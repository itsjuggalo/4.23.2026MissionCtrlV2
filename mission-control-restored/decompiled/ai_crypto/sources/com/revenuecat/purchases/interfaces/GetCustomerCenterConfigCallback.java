package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;

/* JADX INFO: loaded from: classes2.dex */
public interface GetCustomerCenterConfigCallback {
    void onError(PurchasesError purchasesError);

    void onSuccess(CustomerCenterConfigData customerCenterConfigData);
}
