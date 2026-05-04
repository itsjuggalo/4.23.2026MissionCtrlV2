package com.amazon.a.a.m;

import com.amazon.a.a.k.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4392a = "DATA_AUTHENTICATION_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4393b = "APPLICATION_LICENSE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4394c = "LICENSE_FAILURE_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4395d = "LICENSE_FAILURE_RAW_EXCEPTION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4396e = "TEST_MODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4397f = "PACKAGE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4398g = "COMMAND";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f4399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f4400i = new b();

    public <T> void a(String str, a aVar) {
        this.f4400i.a(str, aVar);
    }

    public boolean b(String str) {
        return this.f4400i.a(str);
    }

    public void c(String str) {
        this.f4400i.c(str);
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f4399h.b(this.f4400i);
    }

    public String toString() {
        return this.f4400i.toString();
    }

    public <T> void a(String str, T t10) {
        this.f4400i.a(str, t10);
    }

    public <T> T a(String str) {
        return (T) this.f4400i.b(str);
    }
}
