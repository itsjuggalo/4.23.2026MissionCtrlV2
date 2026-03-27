package com.android.billingclient.api;

import R0.s0;
import com.google.android.gms.internal.play_billing.V;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14671c;

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    public static class C0247a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14673b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f14674c = "";

        public /* synthetic */ C0247a(s0 s0Var) {
        }

        public a a() {
            a aVar = new a();
            aVar.f14669a = this.f14672a;
            aVar.f14670b = this.f14673b;
            aVar.f14671c = this.f14674c;
            return aVar;
        }

        public C0247a b(String str) {
            this.f14674c = str;
            return this;
        }

        public C0247a c(int i8) {
            this.f14673b = i8;
            return this;
        }

        public C0247a d(int i8) {
            this.f14672a = i8;
            return this;
        }
    }

    public static C0247a d() {
        return new C0247a(null);
    }

    public String a() {
        return this.f14671c;
    }

    public int b() {
        return this.f14670b;
    }

    public int c() {
        return this.f14669a;
    }

    public String toString() {
        return "Response Code: " + V.j(this.f14669a) + ", Debug Message: " + this.f14671c;
    }
}
