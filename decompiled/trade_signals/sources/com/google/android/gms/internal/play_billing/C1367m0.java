package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1367m0 extends AbstractC1362l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15451a = AtomicReferenceFieldUpdater.newUpdater(C1382p0.class, Thread.class, "a");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15452b = AtomicReferenceFieldUpdater.newUpdater(C1382p0.class, C1382p0.class, "b");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15453c = AtomicReferenceFieldUpdater.newUpdater(AbstractC1387q0.class, C1382p0.class, "c");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15454d = AtomicReferenceFieldUpdater.newUpdater(AbstractC1387q0.class, C1347i0.class, "b");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15455e = AtomicReferenceFieldUpdater.newUpdater(AbstractC1387q0.class, Object.class, "a");

    public /* synthetic */ C1367m0(AbstractC1411v0 abstractC1411v0) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1347i0 a(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0) {
        return (C1347i0) f15454d.getAndSet(abstractC1387q0, c1347i0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1382p0 b(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0) {
        return (C1382p0) f15453c.getAndSet(abstractC1387q0, c1382p0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void c(C1382p0 c1382p0, C1382p0 c1382p02) {
        f15452b.lazySet(c1382p0, c1382p02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void d(C1382p0 c1382p0, Thread thread) {
        f15451a.lazySet(c1382p0, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean e(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0, C1347i0 c1347i02) {
        return AbstractC1391r0.a(f15454d, abstractC1387q0, c1347i0, c1347i02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean f(AbstractC1387q0 abstractC1387q0, Object obj, Object obj2) {
        return AbstractC1391r0.a(f15455e, abstractC1387q0, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean g(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0, C1382p0 c1382p02) {
        return AbstractC1391r0.a(f15453c, abstractC1387q0, c1382p0, c1382p02);
    }
}
