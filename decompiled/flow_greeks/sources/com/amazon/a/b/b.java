package com.amazon.a.b;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f4654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4655e;

    public b(com.amazon.a.a.o.b.f fVar) {
        this.f4651a = a("checksum", fVar);
        this.f4652b = a("customerId", fVar);
        this.f4653c = a("deviceId", fVar);
        this.f4655e = a("packageName", fVar);
        this.f4654d = b("expiration", fVar);
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
        return this.f4653c;
    }

    public Date d() {
        return this.f4654d;
    }

    public String e() {
        return this.f4655e;
    }

    public String a() {
        return this.f4651a;
    }

    public String b() {
        return this.f4652b;
    }
}
