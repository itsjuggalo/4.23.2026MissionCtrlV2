package Y6;

import Y6.AbstractC1004f0;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: Y6.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1006g0 extends AbstractC1002e0 {
    public abstract Thread L0();

    public void M0(long j8, AbstractC1004f0.b bVar) {
        Q.f9641i.a1(j8, bVar);
    }

    public final void N0() {
        Thread threadL0 = L0();
        if (Thread.currentThread() != threadL0) {
            AbstractC0997c.a();
            LockSupport.unpark(threadL0);
        }
    }
}
