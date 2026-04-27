package com.revenuecat.purchases.hybridcommon;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface OnResult {
    void onError(ErrorContainer errorContainer);

    void onReceived(Map<String, ?> map);
}
