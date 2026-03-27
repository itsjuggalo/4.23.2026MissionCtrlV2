package w6;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f25059a = new V();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25060b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f25061c = new U(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference[] f25063e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f25062d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i7 = 0; i7 < iHighestOneBit; i7++) {
            atomicReferenceArr[i7] = new AtomicReference();
        }
        f25063e = atomicReferenceArr;
    }

    public static final void b(U segment) {
        kotlin.jvm.internal.r.f(segment, "segment");
        if (segment.f25057f != null || segment.f25058g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f25055d) {
            return;
        }
        AtomicReference atomicReferenceA = f25059a.a();
        U u7 = f25061c;
        U u8 = (U) atomicReferenceA.getAndSet(u7);
        if (u8 == u7) {
            return;
        }
        int i7 = u8 != null ? u8.f25054c : 0;
        if (i7 >= f25060b) {
            atomicReferenceA.set(u8);
            return;
        }
        segment.f25057f = u8;
        segment.f25053b = 0;
        segment.f25054c = i7 + 8192;
        atomicReferenceA.set(segment);
    }

    public static final U c() {
        AtomicReference atomicReferenceA = f25059a.a();
        U u7 = f25061c;
        U u8 = (U) atomicReferenceA.getAndSet(u7);
        if (u8 == u7) {
            return new U();
        }
        if (u8 == null) {
            atomicReferenceA.set(null);
            return new U();
        }
        atomicReferenceA.set(u8.f25057f);
        u8.f25057f = null;
        u8.f25054c = 0;
        return u8;
    }

    public final AtomicReference a() {
        return f25063e[(int) (Thread.currentThread().getId() & (((long) f25062d) - 1))];
    }
}
