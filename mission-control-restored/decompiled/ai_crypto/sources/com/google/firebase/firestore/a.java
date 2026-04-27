package com.google.firebase.firestore;

import A3.C0419t;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0419t f12111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12113c;

    public static class b extends a {
        public b(C0419t c0419t) {
            super(c0419t, "average");
        }
    }

    public static class c extends a {
        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            super(null, "count");
        }
    }

    public static class d extends a {
        public d(C0419t c0419t) {
            super(c0419t, "sum");
        }
    }

    public static b a(String str) {
        return new b(C0419t.b(str));
    }

    public static c b() {
        return new c();
    }

    public static d f(String str) {
        return new d(C0419t.b(str));
    }

    public String c() {
        return this.f12113c;
    }

    public String d() {
        C0419t c0419t = this.f12111a;
        return c0419t == null ? "" : c0419t.toString();
    }

    public String e() {
        return this.f12112b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        C0419t c0419t = this.f12111a;
        return (c0419t == null || aVar.f12111a == null) ? c0419t == null && aVar.f12111a == null : this.f12112b.equals(aVar.e()) && d().equals(aVar.d());
    }

    public int hashCode() {
        return Objects.hash(e(), d());
    }

    public a(C0419t c0419t, String str) {
        String str2;
        this.f12111a = c0419t;
        this.f12112b = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (c0419t == null) {
            str2 = "";
        } else {
            str2 = "_" + c0419t;
        }
        sb.append(str2);
        this.f12113c = sb.toString();
    }
}
