package ng;

import java.util.concurrent.locks.LockSupport;
import ng.j1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k1 extends i1 {
    public abstract Thread q0();

    public void r0(long j10, j1.c cVar) {
        s0.f17181i.F0(j10, cVar);
    }

    public final void s0() {
        Thread threadQ0 = q0();
        if (Thread.currentThread() != threadQ0) {
            c.a();
            LockSupport.unpark(threadQ0);
        }
    }
}
