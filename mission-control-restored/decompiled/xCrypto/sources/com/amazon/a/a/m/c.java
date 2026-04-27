package com.amazon.a.a.m;

import com.amazon.a.a.k.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8580a = "DATA_AUTHENTICATION_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8581b = "APPLICATION_LICENSE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8582c = "LICENSE_FAILURE_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8583d = "LICENSE_FAILURE_RAW_EXCEPTION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8584e = "TEST_MODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8585f = "PACKAGE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8586g = "COMMAND";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f8587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f8588i = new b();

    public <T> void a(String str, a aVar) {
        this.f8588i.a(str, aVar);
    }

    public boolean b(String str) {
        return this.f8588i.a(str);
    }

    public void c(String str) {
        this.f8588i.c(str);
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f8587h.b(this.f8588i);
    }

    public String toString() {
        return this.f8588i.toString();
    }

    public <T> void a(String str, T t4) {
        this.f8588i.a(str, t4);
    }

    public <T> T a(String str) {
        return (T) this.f8588i.b(str);
    }
}
