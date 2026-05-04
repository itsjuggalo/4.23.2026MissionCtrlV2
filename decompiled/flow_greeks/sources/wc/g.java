package wc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum g implements kh.c {
    CANCELLED;

    public static boolean a(AtomicReference atomicReference) {
        kh.c cVar;
        kh.c cVar2 = (kh.c) atomicReference.get();
        g gVar = CANCELLED;
        if (cVar2 == gVar || (cVar = (kh.c) atomicReference.getAndSet(gVar)) == gVar) {
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar.cancel();
        return true;
    }

    public static void b(AtomicReference atomicReference, AtomicLong atomicLong, long j10) {
        kh.c cVar = (kh.c) atomicReference.get();
        if (cVar != null) {
            cVar.request(j10);
            return;
        }
        if (l(j10)) {
            xc.d.a(atomicLong, j10);
            kh.c cVar2 = (kh.c) atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean c(AtomicReference atomicReference, AtomicLong atomicLong, kh.c cVar) {
        if (!k(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.request(andSet);
        return true;
    }

    public static void h(long j10) {
        yc.a.q(new gc.e("More produced than requested: " + j10));
    }

    public static void i() {
        yc.a.q(new gc.e("Subscription already set!"));
    }

    public static boolean k(AtomicReference atomicReference, kh.c cVar) {
        kc.b.d(cVar, "s is null");
        if (com.amazon.a.a.l.d.a(atomicReference, null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        i();
        return false;
    }

    public static boolean l(long j10) {
        if (j10 > 0) {
            return true;
        }
        yc.a.q(new IllegalArgumentException("n > 0 required but it was " + j10));
        return false;
    }

    public static boolean m(kh.c cVar, kh.c cVar2) {
        if (cVar2 == null) {
            yc.a.q(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        i();
        return false;
    }

    @Override // kh.c
    public void cancel() {
    }

    @Override // kh.c
    public void request(long j10) {
    }
}
