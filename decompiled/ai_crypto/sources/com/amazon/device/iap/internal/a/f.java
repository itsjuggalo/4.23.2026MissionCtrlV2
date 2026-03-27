package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f10323a = 3715222306172636179L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10326d;

    public f(String str, String str2, String str3) {
        this.f10324b = str;
        this.f10325c = str2;
        this.f10326d = str3;
    }

    public String a() {
        return this.f10324b;
    }

    public String b() {
        return this.f10325c;
    }

    public String c() {
        return this.f10326d;
    }

    public f(String str, String str2, String str3, Throwable th) {
        super(th);
        this.f10324b = str;
        this.f10325c = str2;
        this.f10326d = str3;
    }
}
