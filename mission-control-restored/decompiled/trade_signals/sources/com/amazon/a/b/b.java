package com.amazon.a.b;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f14156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14157e;

    public b(com.amazon.a.a.o.b.f fVar) {
        this.f14153a = a("checksum", fVar);
        this.f14154b = a("customerId", fVar);
        this.f14155c = a("deviceId", fVar);
        this.f14157e = a("packageName", fVar);
        this.f14156d = b("expiration", fVar);
    }

    public String a() {
        return this.f14153a;
    }

    public String b() {
        return this.f14154b;
    }

    public String c() {
        return this.f14155c;
    }

    public Date d() {
        return this.f14156d;
    }

    public String e() {
        return this.f14157e;
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
}
