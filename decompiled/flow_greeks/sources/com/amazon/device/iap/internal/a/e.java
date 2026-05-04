package com.amazon.device.iap.internal.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4922a = 7955687159702952249L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4924c;

    public e(String str, String str2) {
        this.f4923b = str;
        this.f4924c = str2;
    }

    public String a() {
        return this.f4923b;
    }

    public String b() {
        return this.f4924c;
    }

    public e(String str, String str2, Throwable th) {
        super(th);
        this.f4923b = str;
        this.f4924c = str2;
    }
}
