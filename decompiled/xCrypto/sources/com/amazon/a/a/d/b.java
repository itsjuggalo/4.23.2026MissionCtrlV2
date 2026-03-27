package com.amazon.a.a.d;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f8439a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8442d;

    public b(String str) {
        this(str, (String) null);
    }

    public final String a() {
        return this.f8440b;
    }

    public final String b() {
        return this.f8441c;
    }

    public final String c() {
        return this.f8442d;
    }

    public b(String str, String str2) {
        this(str, str2, (String) null);
    }

    private static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        Throwable thC = c(th);
        StringBuilder sb = new StringBuilder();
        sb.append(b(th));
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(th.getMessage());
        if (th != thC) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(b(thC));
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(thC.getMessage());
        }
        return sb.toString();
    }

    private static String b(Throwable th) {
        return th.getClass().getName();
    }

    private static Throwable c(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public b(String str, String str2, String str3) {
        super(str + ": " + str2 + ": " + str3);
        this.f8440b = str;
        this.f8441c = str2;
        this.f8442d = str3;
    }

    public b(String str, Throwable th) {
        this(str, b(th), th);
    }

    public b(String str, String str2, Throwable th) {
        this(str, str2, a(th));
    }
}
