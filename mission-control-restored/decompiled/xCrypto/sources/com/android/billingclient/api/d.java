package com.android.billingclient.api;

import H0.AbstractC0305g0;
import com.google.android.gms.internal.play_billing.zze;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9435b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9437b = "";

        public /* synthetic */ a(AbstractC0305g0 abstractC0305g0) {
        }

        public d a() {
            d dVar = new d();
            dVar.f9434a = this.f9436a;
            dVar.f9435b = this.f9437b;
            return dVar;
        }

        public a b(String str) {
            this.f9437b = str;
            return this;
        }

        public a c(int i4) {
            this.f9436a = i4;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f9435b;
    }

    public int b() {
        return this.f9434a;
    }

    public String toString() {
        return "Response Code: " + zze.zzi(this.f9434a) + ", Debug Message: " + this.f9435b;
    }
}
