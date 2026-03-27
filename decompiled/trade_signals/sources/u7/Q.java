package u7;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Q f23602a = new Q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23603b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final P f23604c = new P(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f23605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference[] f23606e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f23605d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i8 = 0; i8 < iHighestOneBit; i8++) {
            atomicReferenceArr[i8] = new AtomicReference();
        }
        f23606e = atomicReferenceArr;
    }

    public static final void b(P segment) {
        AbstractC2304t.f(segment, "segment");
        if (segment.f23600f != null || segment.f23601g != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f23598d) {
            return;
        }
        AtomicReference atomicReferenceA = f23602a.a();
        P p8 = f23604c;
        P p9 = (P) atomicReferenceA.getAndSet(p8);
        if (p9 == p8) {
            return;
        }
        int i8 = p9 != null ? p9.f23597c : 0;
        if (i8 >= f23603b) {
            atomicReferenceA.set(p9);
            return;
        }
        segment.f23600f = p9;
        segment.f23596b = 0;
        segment.f23597c = i8 + 8192;
        atomicReferenceA.set(segment);
    }

    public static final P c() {
        AtomicReference atomicReferenceA = f23602a.a();
        P p8 = f23604c;
        P p9 = (P) atomicReferenceA.getAndSet(p8);
        if (p9 == p8) {
            return new P();
        }
        if (p9 == null) {
            atomicReferenceA.set(null);
            return new P();
        }
        atomicReferenceA.set(p9.f23600f);
        p9.f23600f = null;
        p9.f23597c = 0;
        return p9;
    }

    public final AtomicReference a() {
        return f23606e[(int) (Thread.currentThread().getId() & (((long) f23605d) - 1))];
    }
}
