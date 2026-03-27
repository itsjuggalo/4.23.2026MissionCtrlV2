package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f9138a = 3715222306172636179L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9141d;

    public f(String str, String str2, String str3) {
        this.f9139b = str;
        this.f9140c = str2;
        this.f9141d = str3;
    }

    public String a() {
        return this.f9139b;
    }

    public String b() {
        return this.f9140c;
    }

    public String c() {
        return this.f9141d;
    }

    public f(String str, String str2, String str3, Throwable th) {
        super(th);
        this.f9139b = str;
        this.f9140c = str2;
        this.f9141d = str3;
    }
}
