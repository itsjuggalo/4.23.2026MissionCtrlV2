package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import d3.q1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5140c;

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0091a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5142b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5143c = "";

        public /* synthetic */ C0091a(q1 q1Var) {
        }

        public a a() {
            a aVar = new a();
            aVar.f5138a = this.f5141a;
            aVar.f5139b = this.f5142b;
            aVar.f5140c = this.f5143c;
            return aVar;
        }

        public C0091a b(String str) {
            this.f5143c = str;
            return this;
        }

        public C0091a c(int i10) {
            this.f5142b = i10;
            return this;
        }

        public C0091a d(int i10) {
            this.f5141a = i10;
            return this;
        }
    }

    public static C0091a d() {
        return new C0091a(null);
    }

    public String a() {
        return this.f5140c;
    }

    public int b() {
        return this.f5139b;
    }

    public int c() {
        return this.f5138a;
    }

    public String toString() {
        return "Response Code: " + zzc.zzk(this.f5138a) + ", Debug Message: " + this.f5140c;
    }
}
