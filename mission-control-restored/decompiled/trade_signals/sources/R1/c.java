package R1;

import D3.m;
import io.flutter.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static String a(int i8) {
        switch (i8) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 12:
            default:
                return "unknown status code: " + i8;
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
            case 15:
                return "TIMEOUT";
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case Build.API_LEVELS.API_22 /* 22 */:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
