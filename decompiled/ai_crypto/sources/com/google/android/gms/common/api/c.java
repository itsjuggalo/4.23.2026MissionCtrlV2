package com.google.android.gms.common.api;

import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static String a(int i7) {
        switch (i7) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case 11:
            case 12:
            default:
                return "unknown status code: " + i7;
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return "CANCELED";
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return "API_NOT_CONNECTED";
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
