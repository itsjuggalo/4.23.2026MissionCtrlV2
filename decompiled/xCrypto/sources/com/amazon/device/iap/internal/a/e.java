package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f9128a = 7955687159702952249L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9130c;

    public e(String str, String str2) {
        this.f9129b = str;
        this.f9130c = str2;
    }

    public String a() {
        return this.f9129b;
    }

    public String b() {
        return this.f9130c;
    }

    public e(String str, String str2, Throwable th) {
        super(th);
        this.f9129b = str;
        this.f9130c = str2;
    }
}
