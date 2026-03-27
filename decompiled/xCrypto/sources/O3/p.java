package O3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f3354a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3355b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f3356c = new o(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference[] f3358e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f3357d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i4 = 0; i4 < iHighestOneBit; i4++) {
            atomicReferenceArr[i4] = new AtomicReference();
        }
        f3358e = atomicReferenceArr;
    }

    public static final void b(o segment) {
        kotlin.jvm.internal.r.f(segment, "segment");
        if (segment.f3352f != null || segment.f3353g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f3350d) {
            return;
        }
        AtomicReference atomicReferenceA = f3354a.a();
        o oVar = f3356c;
        o oVar2 = (o) atomicReferenceA.getAndSet(oVar);
        if (oVar2 == oVar) {
            return;
        }
        int i4 = oVar2 != null ? oVar2.f3349c : 0;
        if (i4 >= f3355b) {
            atomicReferenceA.set(oVar2);
            return;
        }
        segment.f3352f = oVar2;
        segment.f3348b = 0;
        segment.f3349c = i4 + UserMetadata.MAX_INTERNAL_KEY_SIZE;
        atomicReferenceA.set(segment);
    }

    public static final o c() {
        AtomicReference atomicReferenceA = f3354a.a();
        o oVar = f3356c;
        o oVar2 = (o) atomicReferenceA.getAndSet(oVar);
        if (oVar2 == oVar) {
            return new o();
        }
        if (oVar2 == null) {
            atomicReferenceA.set(null);
            return new o();
        }
        atomicReferenceA.set(oVar2.f3352f);
        oVar2.f3352f = null;
        oVar2.f3349c = 0;
        return oVar2;
    }

    public final AtomicReference a() {
        return f3358e[(int) (Thread.currentThread().getId() & (((long) f3357d) - 1))];
    }
}
