package io.flutter.plugins.firebase.database;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FlutterFirebaseDatabaseException extends Exception {
    private static final String MODULE = "firebase_database";
    public static final String UNKNOWN_ERROR_CODE = "unknown";
    public static final String UNKNOWN_ERROR_MESSAGE = "An unknown error occurred";
    private final Map<String, Object> additionalData;
    private final String code;
    private final String message;

    public FlutterFirebaseDatabaseException(String str, String str2, Map<String, Object> map) {
        this.code = str;
        this.message = str2;
        this.additionalData = map == null ? new HashMap<>() : map;
        this.additionalData.put(Constants.ERROR_CODE, str);
        this.additionalData.put(Constants.ERROR_MESSAGE, str2);
    }

    public static FlutterFirebaseDatabaseException fromDatabaseError(c3.c cVar) {
        String str;
        String str2;
        int iF = cVar.f();
        if (iF == -25) {
            str = "write-cancelled";
            str2 = "The write was canceled by the user.";
        } else if (iF == -24) {
            str = "network-error";
            str2 = "The operation could not be performed due to a network error.";
        } else if (iF == -4) {
            str = "disconnected";
            str2 = "The operation had to be aborted due to a network disconnect.";
        } else if (iF == -3) {
            str = "permission-denied";
            str2 = "Client doesn't have permission to access the desired data.";
        } else if (iF == -2) {
            str = "failure";
            str2 = "The server indicated that this operation failed.";
        } else if (iF != -1) {
            switch (iF) {
                case -10:
                    str = "unavailable";
                    str2 = "The service is unavailable.";
                    break;
                case -9:
                    str = "overridden-by-set";
                    str2 = "The transaction was overridden by a subsequent set.";
                    break;
                case -8:
                    str = "max-retries";
                    str2 = "The transaction had too many retries.";
                    break;
                case -7:
                    str = "invalid-token";
                    str2 = "The supplied auth token was invalid.";
                    break;
                case -6:
                    str = "expired-token";
                    str2 = "The supplied auth token has expired.";
                    break;
                default:
                    str2 = UNKNOWN_ERROR_MESSAGE;
                    str = UNKNOWN_ERROR_CODE;
                    break;
            }
        } else {
            str = "data-stale";
            str2 = "The transaction needs to be run again with current data.";
        }
        if (str.equals(UNKNOWN_ERROR_CODE)) {
            return unknown(cVar.h());
        }
        HashMap map = new HashMap();
        map.put(Constants.ERROR_DETAILS, cVar.g());
        return new FlutterFirebaseDatabaseException(str, str2, map);
    }

    public static FlutterFirebaseDatabaseException fromDatabaseException(c3.d dVar) {
        return fromDatabaseError(c3.c.b(dVar));
    }

    public static FlutterFirebaseDatabaseException fromException(Exception exc) {
        return exc == null ? unknown() : unknown(exc.getMessage());
    }

    public static FlutterFirebaseDatabaseException unknown() {
        return unknown(null);
    }

    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public static FlutterFirebaseDatabaseException unknown(String str) {
        String str2;
        HashMap map = new HashMap();
        if (str == null) {
            str = UNKNOWN_ERROR_MESSAGE;
        }
        if (str.contains("Index not defined, add \".indexOn\"")) {
            str = str.replaceFirst("java.lang.Exception: ", "");
            str2 = "index-not-defined";
        } else if (str.contains("Permission denied") || str.contains("Client doesn't have permission")) {
            str2 = "permission-denied";
            str = "Client doesn't have permission to access the desired data.";
        } else {
            str2 = UNKNOWN_ERROR_CODE;
        }
        return new FlutterFirebaseDatabaseException(str2, str, map);
    }
}
