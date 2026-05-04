package xc;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static void a(kh.b bVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = cVar.b();
            if (thB != null) {
                bVar.onError(thB);
            } else {
                bVar.onComplete();
            }
        }
    }

    public static void b(kh.b bVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (!cVar.a(th)) {
            yc.a.q(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(cVar.b());
        }
    }

    public static void c(kh.b bVar, Object obj, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = cVar.b();
                if (thB != null) {
                    bVar.onError(thB);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }
}
