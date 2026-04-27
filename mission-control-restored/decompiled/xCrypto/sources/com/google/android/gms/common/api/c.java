package com.google.android.gms.common.api;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static String a(int i4) {
        switch (i4) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return "unknown status code: " + i4;
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
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return "API_NOT_CONNECTED";
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case Build.API_LEVELS.API_21 /* 21 */:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case Build.API_LEVELS.API_22 /* 22 */:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
