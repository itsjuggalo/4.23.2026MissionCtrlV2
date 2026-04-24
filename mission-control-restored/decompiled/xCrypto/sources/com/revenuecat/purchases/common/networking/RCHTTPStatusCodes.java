package com.revenuecat.purchases.common.networking;

/* JADX INFO: loaded from: classes.dex */
public final class RCHTTPStatusCodes {
    public static final int BAD_REQUEST = 400;
    public static final int CREATED = 201;
    public static final int ERROR = 500;
    public static final int FORBIDDEN = 403;
    public static final RCHTTPStatusCodes INSTANCE = new RCHTTPStatusCodes();
    public static final int NOT_FOUND = 404;
    public static final int NOT_MODIFIED = 304;
    public static final int SUCCESS = 200;
    public static final int UNAUTHORIZED = 401;
    public static final int UNSUCCESSFUL = 300;

    private RCHTTPStatusCodes() {
    }

    public final boolean isServerError(int i4) {
        return i4 >= 500;
    }

    public final boolean isSuccessful(int i4) {
        return i4 < 400;
    }

    public final boolean isSynced(int i4) {
        if (isSuccessful(i4)) {
            return true;
        }
        return (isServerError(i4) || i4 == 404) ? false : true;
    }
}
