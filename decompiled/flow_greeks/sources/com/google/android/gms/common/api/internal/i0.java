package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m5.d f5583b;

    public /* synthetic */ i0(b bVar, m5.d dVar, byte[] bArr) {
        this.f5582a = bVar;
        this.f5583b = dVar;
    }

    public final /* synthetic */ b a() {
        return this.f5582a;
    }

    public final /* synthetic */ m5.d b() {
        return this.f5583b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            if (com.google.android.gms.common.internal.q.b(this.f5582a, i0Var.f5582a) && com.google.android.gms.common.internal.q.b(this.f5583b, i0Var.f5583b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f5582a, this.f5583b);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("key", this.f5582a).a("feature", this.f5583b).toString();
    }
}
