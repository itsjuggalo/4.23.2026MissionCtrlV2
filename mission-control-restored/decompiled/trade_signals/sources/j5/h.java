package j5;

import java.util.concurrent.atomic.AtomicInteger;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static void a(x7.b bVar, AtomicInteger atomicInteger, C2226c c2226c) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = c2226c.b();
            if (thB != null) {
                bVar.onError(thB);
            } else {
                bVar.a();
            }
        }
    }

    public static void b(x7.b bVar, Throwable th, AtomicInteger atomicInteger, C2226c c2226c) {
        if (!c2226c.a(th)) {
            AbstractC2283a.q(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(c2226c.b());
        }
    }

    public static void c(x7.b bVar, Object obj, AtomicInteger atomicInteger, C2226c c2226c) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.c(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = c2226c.b();
                if (thB != null) {
                    bVar.onError(thB);
                } else {
                    bVar.a();
                }
            }
        }
    }
}
