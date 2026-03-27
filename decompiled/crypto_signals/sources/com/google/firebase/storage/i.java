package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Z1.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f5567b;

    public i(int i, int i6, Throwable th) {
        super(c(i));
        this.f5567b = th;
        this.f5566a = i;
        Log.e("StorageException", "StorageException has occurred.\n" + c(i) + "\n Code: " + i + " HttpResult: " + i6);
        if (th != null) {
            Log.e("StorageException", th.getMessage(), th);
        }
    }

    public static i a(Status status) {
        I.b(!status.m());
        return new i(status.f5062a == 16 ? -13040 : status.equals(Status.f5060l) ? -13030 : -13000, 0, null);
    }

    public static i b(int i, Throwable th) {
        if (th instanceof i) {
            return (i) th;
        }
        if ((i == 0 || (i >= 200 && i < 300)) && th == null) {
            return null;
        }
        return new i(th instanceof C0448a ? -13040 : i != -2 ? i != 401 ? i != 409 ? i != 403 ? i != 404 ? -13000 : -13010 : -13021 : -13031 : -13020 : -13030, i, th);
    }

    public static String c(int i) {
        if (i == -13040) {
            return "The operation was cancelled.";
        }
        if (i == -13031) {
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        if (i == -13030) {
            return "The operation retry limit has been exceeded.";
        }
        if (i == -13021) {
            return "User does not have permission to access this object.";
        }
        if (i == -13020) {
            return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
        }
        switch (i) {
            case -13013:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case -13012:
                return "Project does not exist.";
            case -13011:
                return "Bucket does not exist.";
            case -13010:
                return "Object does not exist at location.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        Throwable th = this.f5567b;
        if (th == this) {
            return null;
        }
        return th;
    }
}
