package com.amazon.a.b;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f8860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8861e;

    public b(com.amazon.a.a.o.b.f fVar) {
        this.f8857a = a("checksum", fVar);
        this.f8858b = a("customerId", fVar);
        this.f8859c = a("deviceId", fVar);
        this.f8861e = a("packageName", fVar);
        this.f8860d = b("expiration", fVar);
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
        return this.f8859c;
    }

    public Date d() {
        return this.f8860d;
    }

    public String e() {
        return this.f8861e;
    }

    public String a() {
        return this.f8857a;
    }

    public String b() {
        return this.f8858b;
    }
}
