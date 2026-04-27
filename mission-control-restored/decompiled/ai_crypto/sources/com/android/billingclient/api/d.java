package com.android.billingclient.api;

import Y0.AbstractC0726g0;
import com.google.android.gms.internal.play_billing.zze;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10620b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10622b = "";

        public /* synthetic */ a(AbstractC0726g0 abstractC0726g0) {
        }

        public d a() {
            d dVar = new d();
            dVar.f10619a = this.f10621a;
            dVar.f10620b = this.f10622b;
            return dVar;
        }

        public a b(String str) {
            this.f10622b = str;
            return this;
        }

        public a c(int i7) {
            this.f10621a = i7;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f10620b;
    }

    public int b() {
        return this.f10619a;
    }

    public String toString() {
        return "Response Code: " + zze.zzi(this.f10619a) + ", Debug Message: " + this.f10620b;
    }
}
