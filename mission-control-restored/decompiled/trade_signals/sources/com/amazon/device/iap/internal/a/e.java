package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f14424a = 7955687159702952249L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14426c;

    public e(String str, String str2) {
        this.f14425b = str;
        this.f14426c = str2;
    }

    public String a() {
        return this.f14425b;
    }

    public String b() {
        return this.f14426c;
    }

    public e(String str, String str2, Throwable th) {
        super(th);
        this.f14425b = str;
        this.f14426c = str2;
    }
}
