package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class StorageException extends FirebaseException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;
    public static final int ERROR_CANCELED = -13040;
    public static final int ERROR_INVALID_CHECKSUM = -13031;
    public static final int ERROR_NOT_AUTHENTICATED = -13020;
    public static final int ERROR_NOT_AUTHORIZED = -13021;
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;
    public static final int ERROR_QUOTA_EXCEEDED = -13013;
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
    public static final int ERROR_UNKNOWN = -13000;
    private static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageException";
    private Throwable cause;
    private final int errorCode;
    private final int httpResultCode;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public StorageException(int i4, Throwable th, int i5) {
        super(getErrorMessageForCode(i4));
        this.cause = th;
        this.errorCode = i4;
        this.httpResultCode = i5;
        Log.e(TAG, "StorageException has occurred.\n" + getErrorMessageForCode(i4) + "\n Code: " + i4 + " HttpResult: " + i5);
        Throwable th2 = this.cause;
        if (th2 != null) {
            Log.e(TAG, th2.getMessage(), this.cause);
        }
    }

    private static int calculateErrorCode(Status status) {
        return status.n() ? ERROR_CANCELED : status.equals(Status.f9656i) ? ERROR_RETRY_LIMIT_EXCEEDED : ERROR_UNKNOWN;
    }

    public static StorageException fromErrorStatus(Status status) {
        AbstractC0940s.k(status);
        AbstractC0940s.a(!status.o());
        return new StorageException(calculateErrorCode(status), null, 0);
    }

    public static StorageException fromException(Throwable th) {
        return fromExceptionAndHttpCode(th, 0);
    }

    public static StorageException fromExceptionAndHttpCode(Throwable th, int i4) {
        if (th instanceof StorageException) {
            return (StorageException) th;
        }
        if (isResultSuccess(i4) && th == null) {
            return null;
        }
        return new StorageException(calculateErrorCode(th, i4), th, i4);
    }

    public static String getErrorMessageForCode(int i4) {
        if (i4 == -13040) {
            return "The operation was cancelled.";
        }
        if (i4 == -13031) {
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        if (i4 == -13030) {
            return "The operation retry limit has been exceeded.";
        }
        if (i4 == -13021) {
            return "User does not have permission to access this object.";
        }
        if (i4 == -13020) {
            return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
        }
        switch (i4) {
            case ERROR_QUOTA_EXCEEDED /* -13013 */:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case ERROR_PROJECT_NOT_FOUND /* -13012 */:
                return "Project does not exist.";
            case ERROR_BUCKET_NOT_FOUND /* -13011 */:
                return "Bucket does not exist.";
            case ERROR_OBJECT_NOT_FOUND /* -13010 */:
                return "Object does not exist at location.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    private static boolean isResultSuccess(int i4) {
        if (i4 != 0) {
            return i4 >= 200 && i4 < 300;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        Throwable th = this.cause;
        if (th == this) {
            return null;
        }
        return th;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getHttpResultCode() {
        return this.httpResultCode;
    }

    public boolean getIsRecoverableException() {
        return getErrorCode() == -13030;
    }

    private static int calculateErrorCode(Throwable th, int i4) {
        return th instanceof CancelException ? ERROR_CANCELED : i4 != -2 ? i4 != 401 ? i4 != 409 ? i4 != 403 ? i4 != 404 ? ERROR_UNKNOWN : ERROR_OBJECT_NOT_FOUND : ERROR_NOT_AUTHORIZED : ERROR_INVALID_CHECKSUM : ERROR_NOT_AUTHENTICATED : ERROR_RETRY_LIMIT_EXCEEDED;
    }
}
