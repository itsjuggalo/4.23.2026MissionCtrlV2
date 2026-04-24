package u5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f10499a = new z(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f10501c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f10500b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f10501c = atomicReferenceArr;
    }

    public static final void a(z segment) {
        kotlin.jvm.internal.j.e(segment, "segment");
        if (segment.f10562f != null || segment.f10563g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f10561d) {
            return;
        }
        AtomicReference atomicReference = f10501c[(int) (Thread.currentThread().getId() & (((long) f10500b) - 1))];
        z zVar = f10499a;
        z zVar2 = (z) atomicReference.getAndSet(zVar);
        if (zVar2 == zVar) {
            return;
        }
        int i = zVar2 != null ? zVar2.f10560c : 0;
        if (i >= 65536) {
            atomicReference.set(zVar2);
            return;
        }
        segment.f10562f = zVar2;
        segment.f10559b = 0;
        segment.f10560c = i + 8192;
        atomicReference.set(segment);
    }

    public static final z b() {
        AtomicReference atomicReference = f10501c[(int) (Thread.currentThread().getId() & (((long) f10500b) - 1))];
        z zVar = f10499a;
        z zVar2 = (z) atomicReference.getAndSet(zVar);
        if (zVar2 == zVar) {
            return new z();
        }
        if (zVar2 == null) {
            atomicReference.set(null);
            return new z();
        }
        atomicReference.set(zVar2.f10562f);
        zVar2.f10562f = null;
        zVar2.f10560c = 0;
        return zVar2;
    }
}
