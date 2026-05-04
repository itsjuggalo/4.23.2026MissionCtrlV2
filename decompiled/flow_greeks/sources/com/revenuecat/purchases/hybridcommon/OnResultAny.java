package com.revenuecat.purchases.hybridcommon;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/OnResultAny;", "T", "", "result", "Lcd/h0;", "onReceived", "(Ljava/lang/Object;)V", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "errorContainer", "onError", "(Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;)V", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OnResultAny<T> {
    void onError(ErrorContainer errorContainer);

    void onReceived(T result);
}
