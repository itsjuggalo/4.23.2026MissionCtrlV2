package b6;

import b6.AbstractC1072h0;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: b6.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1074i0 extends AbstractC1070g0 {
    public abstract Thread N0();

    public void O0(long j7, AbstractC1072h0.c cVar) {
        Q.f9020i.Y0(j7, cVar);
    }

    public final void P0() {
        Thread threadN0 = N0();
        if (Thread.currentThread() != threadN0) {
            AbstractC1061c.a();
            LockSupport.unpark(threadN0);
        }
    }
}
