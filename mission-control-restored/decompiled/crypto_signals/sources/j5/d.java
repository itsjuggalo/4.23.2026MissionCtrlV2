package j5;

import G4.l;
import a5.C;
import a5.C0307n;
import f5.t;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class d extends h implements a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7765g = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public d(boolean z6) {
        super(z6 ? 1 : 0);
        this.owner$volatile = z6 ? null : e.f7766a;
    }

    public final boolean c() {
        return Math.max(h.f7772f.get(this), 0) == 0;
    }

    public final Object d(K4.c cVar) {
        boolean zE = e();
        l lVar = l.f540a;
        if (!zE) {
            C0307n c0307nK = C.k(F1.h.z(cVar));
            try {
                a(new c(this, c0307nK));
                Object objQ = c0307nK.q();
                J4.a aVar = J4.a.f791a;
                if (objQ != aVar) {
                    objQ = lVar;
                }
                if (objQ == aVar) {
                    return objQ;
                }
            } catch (Throwable th) {
                c0307nK.x();
                throw th;
            }
        }
        return lVar;
    }

    public final boolean e() {
        int i;
        char c6;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h.f7772f;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 > 1) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
            } else {
                if (i6 <= 0) {
                    c6 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 - 1)) {
                    f7765g.set(this, null);
                    c6 = 0;
                    break;
                }
            }
        }
        if (c6 == 0) {
            return true;
        }
        if (c6 == 1) {
            return false;
        }
        if (c6 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    }

    public final void f(Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7765g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            t tVar = e.f7766a;
            if (obj2 != tVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, tVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        return "Mutex@" + C.j(this) + "[isLocked=" + c() + ",owner=" + f7765g.get(this) + ']';
    }
}
