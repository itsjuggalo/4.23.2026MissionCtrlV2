package S2;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.AbstractC2328l;
import l2.InterfaceC2319c;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f7543a = G.c("awaitEvenIfOnMainThread task continuation executor");

    public static Object b(AbstractC2328l abstractC2328l) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        abstractC2328l.h(f7543a, new InterfaceC2319c() { // from class: S2.f0
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l2) {
                return g0.d(countDownLatch, abstractC2328l2);
            }
        });
        countDownLatch.await(Looper.getMainLooper() == Looper.myLooper() ? 3000L : 4000L, TimeUnit.MILLISECONDS);
        if (abstractC2328l.o()) {
            return abstractC2328l.k();
        }
        if (abstractC2328l.m()) {
            throw new CancellationException("Task is already canceled");
        }
        if (abstractC2328l.n()) {
            throw new IllegalStateException(abstractC2328l.j());
        }
        throw new TimeoutException();
    }

    public static boolean c(CountDownLatch countDownLatch, long j8, TimeUnit timeUnit) {
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j8);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z7) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ Object d(CountDownLatch countDownLatch, AbstractC2328l abstractC2328l) {
        countDownLatch.countDown();
        return null;
    }
}
