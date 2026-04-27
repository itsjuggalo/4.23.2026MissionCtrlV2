package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: com.google.firebase.storage.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1228n extends Q2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f12461c;

    public C1228n(int i7, Throwable th, int i8) {
        super(g(i7));
        this.f12461c = th;
        this.f12459a = i7;
        this.f12460b = i8;
        Log.e("StorageException", "StorageException has occurred.\n" + g(i7) + "\n Code: " + i7 + " HttpResult: " + i8);
        Throwable th2 = this.f12461c;
        if (th2 != null) {
            Log.e("StorageException", th2.getMessage(), this.f12461c);
        }
    }

    public static int a(Status status) {
        if (status.E()) {
            return -13040;
        }
        return status.equals(Status.f10841i) ? -13030 : -13000;
    }

    public static int b(Throwable th, int i7) {
        if (th instanceof C1215a) {
            return -13040;
        }
        if (i7 == -2) {
            return -13030;
        }
        if (i7 == 401) {
            return -13020;
        }
        if (i7 == 409) {
            return -13031;
        }
        if (i7 != 403) {
            return i7 != 404 ? -13000 : -13010;
        }
        return -13021;
    }

    public static C1228n c(Status status) {
        AbstractC1207s.k(status);
        AbstractC1207s.a(!status.F());
        return new C1228n(a(status), null, 0);
    }

    public static C1228n d(Throwable th) {
        return e(th, 0);
    }

    public static C1228n e(Throwable th, int i7) {
        if (th instanceof C1228n) {
            return (C1228n) th;
        }
        if (h(i7) && th == null) {
            return null;
        }
        return new C1228n(b(th, i7), th, i7);
    }

    public static String g(int i7) {
        if (i7 == -13040) {
            return "The operation was cancelled.";
        }
        if (i7 == -13031) {
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        if (i7 == -13030) {
            return "The operation retry limit has been exceeded.";
        }
        if (i7 == -13021) {
            return "User does not have permission to access this object.";
        }
        if (i7 == -13020) {
            return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
        }
        switch (i7) {
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

    public static boolean h(int i7) {
        return i7 == 0 || (i7 >= 200 && i7 < 300);
    }

    public int f() {
        return this.f12459a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        Throwable th = this.f12461c;
        if (th == this) {
            return null;
        }
        return th;
    }
}
