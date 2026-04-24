package com.revenuecat.purchases.hybridcommon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/OnResultAny;", "T", "", "result", "Lo5/H;", "onReceived", "(Ljava/lang/Object;)V", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "errorContainer", "onError", "(Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;)V", "hybridcommon_release"}, k = 1, mv = {1, 8, 0})
public interface OnResultAny<T> {
    void onError(ErrorContainer errorContainer);

    void onReceived(T result);
}
