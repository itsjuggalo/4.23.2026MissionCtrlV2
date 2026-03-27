package com.amazon.a.a.m;

import com.amazon.a.a.k.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9765a = "DATA_AUTHENTICATION_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9766b = "APPLICATION_LICENSE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9767c = "LICENSE_FAILURE_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9768d = "LICENSE_FAILURE_RAW_EXCEPTION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9769e = "TEST_MODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9770f = "PACKAGE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9771g = "COMMAND";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f9772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f9773i = new b();

    public <T> void a(String str, a aVar) {
        this.f9773i.a(str, aVar);
    }

    public boolean b(String str) {
        return this.f9773i.a(str);
    }

    public void c(String str) {
        this.f9773i.c(str);
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f9772h.b(this.f9773i);
    }

    public String toString() {
        return this.f9773i.toString();
    }

    public <T> void a(String str, T t7) {
        this.f9773i.a(str, t7);
    }

    public <T> T a(String str) {
        return (T) this.f9773i.b(str);
    }
}
