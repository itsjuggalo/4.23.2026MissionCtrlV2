package i5;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: i5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC1933g implements x7.c {
    CANCELLED;

    public static boolean a(AtomicReference atomicReference) {
        x7.c cVar;
        x7.c cVar2 = (x7.c) atomicReference.get();
        EnumC1933g enumC1933g = CANCELLED;
        if (cVar2 == enumC1933g || (cVar = (x7.c) atomicReference.getAndSet(enumC1933g)) == enumC1933g) {
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar.cancel();
        return true;
    }

    public static void b(AtomicReference atomicReference, AtomicLong atomicLong, long j8) {
        x7.c cVar = (x7.c) atomicReference.get();
        if (cVar != null) {
            cVar.i(j8);
            return;
        }
        if (n(j8)) {
            j5.d.a(atomicLong, j8);
            x7.c cVar2 = (x7.c) atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.i(andSet);
                }
            }
        }
    }

    public static boolean g(AtomicReference atomicReference, AtomicLong atomicLong, x7.c cVar) {
        if (!m(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.i(andSet);
        return true;
    }

    public static void k(long j8) {
        AbstractC2283a.q(new T4.e("More produced than requested: " + j8));
    }

    public static void l() {
        AbstractC2283a.q(new T4.e("Subscription already set!"));
    }

    public static boolean m(AtomicReference atomicReference, x7.c cVar) {
        X4.b.d(cVar, "s is null");
        if (com.amazon.a.a.l.d.a(atomicReference, null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        l();
        return false;
    }

    public static boolean n(long j8) {
        if (j8 > 0) {
            return true;
        }
        AbstractC2283a.q(new IllegalArgumentException("n > 0 required but it was " + j8));
        return false;
    }

    public static boolean q(x7.c cVar, x7.c cVar2) {
        if (cVar2 == null) {
            AbstractC2283a.q(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        l();
        return false;
    }

    @Override // x7.c
    public void cancel() {
    }

    @Override // x7.c
    public void i(long j8) {
    }
}
