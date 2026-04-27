package com.revenuecat.purchases.hybridcommon;

/* JADX INFO: loaded from: classes3.dex */
public interface OnResultAny<T> {
    void onError(ErrorContainer errorContainer);

    void onReceived(T t4);
}
