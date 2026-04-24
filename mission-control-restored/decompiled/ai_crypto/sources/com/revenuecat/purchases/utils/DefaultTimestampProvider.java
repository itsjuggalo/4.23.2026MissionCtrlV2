package com.revenuecat.purchases.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultTimestampProvider implements TimestampProvider {
    @Override // com.revenuecat.purchases.utils.TimestampProvider
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
