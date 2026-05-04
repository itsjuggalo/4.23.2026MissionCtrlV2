package com.google.firebase.firestore;

import d9.t;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6135c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends a {
        public b(t tVar) {
            super(tVar, "average");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends a {
        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            super(null, "count");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends a {
        public d(t tVar) {
            super(tVar, "sum");
        }
    }

    public static b a(String str) {
        return new b(t.b(str));
    }

    public static c b() {
        return new c();
    }

    public static d f(String str) {
        return new d(t.b(str));
    }

    public String c() {
        return this.f6135c;
    }

    public String d() {
        t tVar = this.f6133a;
        return tVar == null ? "" : tVar.toString();
    }

    public String e() {
        return this.f6134b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        t tVar = this.f6133a;
        return (tVar == null || aVar.f6133a == null) ? tVar == null && aVar.f6133a == null : this.f6134b.equals(aVar.e()) && d().equals(aVar.d());
    }

    public int hashCode() {
        return Objects.hash(e(), d());
    }

    public a(t tVar, String str) {
        String str2;
        this.f6133a = tVar;
        this.f6134b = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (tVar == null) {
            str2 = "";
        } else {
            str2 = "_" + tVar;
        }
        sb2.append(str2);
        this.f6135c = sb2.toString();
    }
}
