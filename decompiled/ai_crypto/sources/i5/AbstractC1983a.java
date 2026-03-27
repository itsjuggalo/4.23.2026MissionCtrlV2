package i5;

import com.google.firebase.storage.C1228n;
import i5.F;

/* JADX INFO: renamed from: i5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1983a {
    public static String a(int i7) {
        if (i7 == -13040) {
            return "canceled";
        }
        if (i7 == -13031) {
            return "invalid-checksum";
        }
        if (i7 == -13030) {
            return "retry-limit-exceeded";
        }
        if (i7 == -13021) {
            return "unauthorized";
        }
        if (i7 == -13020) {
            return "unauthenticated";
        }
        switch (i7) {
            case -13013:
                return "quota-exceeded";
            case -13012:
                return "project-not-found";
            case -13011:
                return "bucket-not-found";
            case -13010:
                return "object-not-found";
            default:
                return "unknown";
        }
    }

    public static String b(int i7) {
        if (i7 == -13040) {
            return "User cancelled the operation.";
        }
        if (i7 == -13031) {
            return "File on the client does not match the checksum of the file received by the server.";
        }
        if (i7 == -13030) {
            return "The maximum time limit on an operation (upload, download, delete, etc.) has been exceeded.";
        }
        if (i7 == -13021) {
            return "User is not authorized to perform the desired action.";
        }
        if (i7 == -13020) {
            return "User is unauthenticated. Authenticate and try again.";
        }
        switch (i7) {
            case -13013:
                return "Quota on your Firebase Storage bucket has been exceeded.";
            case -13012:
                return "No project is configured for Firebase Storage.";
            case -13011:
                return "No bucket is configured for Firebase Storage.";
            case -13010:
                return "No object exists at the desired reference.";
            default:
                return "An unknown error occurred";
        }
    }

    public static F.c c(Exception exc) {
        String strA = "UNKNOWN";
        if (exc == null) {
            return new F.c("UNKNOWN", "An unknown error occurred", null);
        }
        String strB = "An unknown error occurred:" + exc.getMessage();
        if (exc instanceof C1228n) {
            int iF = ((C1228n) exc).f();
            strA = a(iF);
            strB = b(iF);
        }
        return new F.c(strA, strB, null);
    }
}
