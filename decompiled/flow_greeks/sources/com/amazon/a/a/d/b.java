package com.amazon.a.a.d;

import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4251a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4254d;

    public b(String str) {
        this(str, (String) null);
    }

    public final String a() {
        return this.f4252b;
    }

    public final String b() {
        return this.f4253c;
    }

    public final String c() {
        return this.f4254d;
    }

    public b(String str, String str2) {
        this(str, str2, (String) null);
    }

    private static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        Throwable thC = c(th);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b(th));
        sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb2.append(th.getMessage());
        if (th != thC) {
            sb2.append("/");
            sb2.append(b(thC));
            sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb2.append(thC.getMessage());
        }
        return sb2.toString();
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
        this.f4252b = str;
        this.f4253c = str2;
        this.f4254d = str3;
    }

    public b(String str, Throwable th) {
        this(str, b(th), th);
    }

    public b(String str, String str2, Throwable th) {
        this(str, str2, a(th));
    }
}
