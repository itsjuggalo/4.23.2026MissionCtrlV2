package com.revenuecat.purchases.utils;

/* JADX INFO: loaded from: classes3.dex */
public interface UrlConnectionFactory {

    public static final class DefaultImpls {
    }

    static /* synthetic */ UrlConnection createConnection$default(UrlConnectionFactory urlConnectionFactory, String str, String str2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConnection");
        }
        if ((i4 & 2) != 0) {
            str2 = "GET";
        }
        return urlConnectionFactory.createConnection(str, str2);
    }

    UrlConnection createConnection(String str, String str2);
}
