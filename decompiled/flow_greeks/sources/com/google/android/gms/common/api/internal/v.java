package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m5.d[] f5638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5640c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f5641a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public m5.d[] f5643c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5642b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5644d = 0;

        public /* synthetic */ a(byte[] bArr) {
        }

        public v a() {
            com.google.android.gms.common.internal.s.b(this.f5641a != null, "execute parameter required");
            return new b1(this, this.f5643c, this.f5642b, this.f5644d);
        }

        public a b(q qVar) {
            this.f5641a = qVar;
            return this;
        }

        public a c(boolean z10) {
            this.f5642b = z10;
            return this;
        }

        public a d(m5.d... dVarArr) {
            this.f5643c = dVarArr;
            return this;
        }

        public a e(int i10) {
            this.f5644d = i10;
            return this;
        }

        public final /* synthetic */ q f() {
            return this.f5641a;
        }
    }

    public v(m5.d[] dVarArr, boolean z10, int i10) {
        this.f5638a = dVarArr;
        boolean z11 = false;
        if (dVarArr != null && z10) {
            z11 = true;
        }
        this.f5639b = z11;
        this.f5640c = i10;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, TaskCompletionSource taskCompletionSource);

    public boolean c() {
        return this.f5639b;
    }

    public final m5.d[] d() {
        return this.f5638a;
    }

    public final int e() {
        return this.f5640c;
    }
}
