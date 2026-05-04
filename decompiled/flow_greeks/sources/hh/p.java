package hh;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11502a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11503b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f11504c = new o(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference[] f11506e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f11505d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference();
        }
        f11506e = atomicReferenceArr;
    }

    public static final void b(o segment) {
        kotlin.jvm.internal.t.f(segment, "segment");
        if (segment.f11500f != null || segment.f11501g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f11498d) {
            return;
        }
        AtomicReference atomicReferenceA = f11502a.a();
        o oVar = f11504c;
        o oVar2 = (o) atomicReferenceA.getAndSet(oVar);
        if (oVar2 == oVar) {
            return;
        }
        int i10 = oVar2 != null ? oVar2.f11497c : 0;
        if (i10 >= f11503b) {
            atomicReferenceA.set(oVar2);
            return;
        }
        segment.f11500f = oVar2;
        segment.f11496b = 0;
        segment.f11497c = i10 + 8192;
        atomicReferenceA.set(segment);
    }

    public static final o c() {
        AtomicReference atomicReferenceA = f11502a.a();
        o oVar = f11504c;
        o oVar2 = (o) atomicReferenceA.getAndSet(oVar);
        if (oVar2 == oVar) {
            return new o();
        }
        if (oVar2 == null) {
            atomicReferenceA.set(null);
            return new o();
        }
        atomicReferenceA.set(oVar2.f11500f);
        oVar2.f11500f = null;
        oVar2.f11497c = 0;
        return oVar2;
    }

    public final AtomicReference a() {
        return f11506e[(int) (Thread.currentThread().getId() & (((long) f11505d) - 1))];
    }
}
