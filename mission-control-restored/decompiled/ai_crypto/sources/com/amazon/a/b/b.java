package com.amazon.a.b;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f10045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10046e;

    public b(com.amazon.a.a.o.b.f fVar) {
        this.f10042a = a("checksum", fVar);
        this.f10043b = a("customerId", fVar);
        this.f10044c = a("deviceId", fVar);
        this.f10046e = a("packageName", fVar);
        this.f10045d = b("expiration", fVar);
    }

    private String a(String str, com.amazon.a.a.o.b.f fVar) throws com.amazon.a.a.o.b.a.b {
        String strA = fVar.a(str);
        if (com.amazon.a.a.o.e.a(strA)) {
            throw com.amazon.a.a.o.b.a.b.a(str);
        }
        return strA;
    }

    private Date b(String str, com.amazon.a.a.o.b.f fVar) throws com.amazon.a.a.o.b.a.b {
        String strA = a(str, fVar);
        try {
            return new Date(Long.parseLong(strA));
        } catch (NumberFormatException unused) {
            throw com.amazon.a.a.o.b.a.b.a(str, strA);
        }
    }

    public String c() {
        return this.f10044c;
    }

    public Date d() {
        return this.f10045d;
    }

    public String e() {
        return this.f10046e;
    }

    public String a() {
        return this.f10042a;
    }

    public String b() {
        return this.f10043b;
    }
}
