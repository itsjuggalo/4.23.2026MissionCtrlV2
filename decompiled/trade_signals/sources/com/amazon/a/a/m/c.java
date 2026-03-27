package com.amazon.a.a.m;

import com.amazon.a.a.k.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13876a = "DATA_AUTHENTICATION_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13877b = "APPLICATION_LICENSE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13878c = "LICENSE_FAILURE_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13879d = "LICENSE_FAILURE_RAW_EXCEPTION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13880e = "TEST_MODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13881f = "PACKAGE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13882g = "COMMAND";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f13883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f13884i = new b();

    public <T> T a(String str) {
        return (T) this.f13884i.b(str);
    }

    public boolean b(String str) {
        return this.f13884i.a(str);
    }

    public void c(String str) {
        this.f13884i.c(str);
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f13883h.b(this.f13884i);
    }

    public String toString() {
        return this.f13884i.toString();
    }

    public <T> void a(String str, a aVar) {
        this.f13884i.a(str, aVar);
    }

    public <T> void a(String str, T t8) {
        this.f13884i.a(str, t8);
    }
}
