package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.networking.HTTPResult;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BackendHelperKt {
    public static final boolean isSuccessful(HTTPResult hTTPResult) {
        r.f(hTTPResult, "<this>");
        return hTTPResult.getResponseCode() < 300;
    }
}
