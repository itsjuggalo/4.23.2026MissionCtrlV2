package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f10313a = 7955687159702952249L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10315c;

    public e(String str, String str2) {
        this.f10314b = str;
        this.f10315c = str2;
    }

    public String a() {
        return this.f10314b;
    }

    public String b() {
        return this.f10315c;
    }

    public e(String str, String str2, Throwable th) {
        super(th);
        this.f10314b = str;
        this.f10315c = str2;
    }
}
