package t3;

import java.util.concurrent.locks.LockSupport;
import t3.AbstractC1817h0;

/* JADX INFO: renamed from: t3.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1819i0 extends AbstractC1815g0 {
    public abstract Thread s0();

    public void t0(long j4, AbstractC1817h0.c cVar) {
        Q.f14962i.D0(j4, cVar);
    }

    public final void u0() {
        Thread threadS0 = s0();
        if (Thread.currentThread() != threadS0) {
            AbstractC1806c.a();
            LockSupport.unpark(threadS0);
        }
    }
}
