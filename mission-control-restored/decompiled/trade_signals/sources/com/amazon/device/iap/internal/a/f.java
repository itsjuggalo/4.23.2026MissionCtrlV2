package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f14434a = 3715222306172636179L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14437d;

    public f(String str, String str2, String str3) {
        this.f14435b = str;
        this.f14436c = str2;
        this.f14437d = str3;
    }

    public String a() {
        return this.f14435b;
    }

    public String b() {
        return this.f14436c;
    }

    public String c() {
        return this.f14437d;
    }

    public f(String str, String str2, String str3, Throwable th) {
        super(th);
        this.f14435b = str;
        this.f14436c = str2;
        this.f14437d = str3;
    }
}
