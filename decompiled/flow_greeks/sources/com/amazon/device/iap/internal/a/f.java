package com.amazon.device.iap.internal.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4932a = 3715222306172636179L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4935d;

    public f(String str, String str2, String str3) {
        this.f4933b = str;
        this.f4934c = str2;
        this.f4935d = str3;
    }

    public String a() {
        return this.f4933b;
    }

    public String b() {
        return this.f4934c;
    }

    public String c() {
        return this.f4935d;
    }

    public f(String str, String str2, String str3, Throwable th) {
        super(th);
        this.f4933b = str;
        this.f4934c = str2;
        this.f4935d = str3;
    }
}
