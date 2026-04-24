package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1375n3 extends H0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f15464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f15465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f15466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f15467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f15468e;

    public C1375n3(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.f15464a = atomicReferenceFieldUpdater;
        this.f15465b = atomicReferenceFieldUpdater2;
        this.f15466c = atomicReferenceFieldUpdater3;
        this.f15467d = atomicReferenceFieldUpdater4;
        this.f15468e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final void a(L3 l32, L3 l33) {
        this.f15465b.lazySet(l32, l33);
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final void b(L3 l32, Thread thread) {
        this.f15464a.lazySet(l32, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean c(N3 n32, C1398s2 c1398s2, C1398s2 c1398s22) {
        return M2.a(this.f15467d, n32, c1398s2, c1398s22);
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean d(N3 n32, Object obj, Object obj2) {
        return M2.a(this.f15468e, n32, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean e(N3 n32, L3 l32, L3 l33) {
        return M2.a(this.f15466c, n32, l32, l33);
    }
}
