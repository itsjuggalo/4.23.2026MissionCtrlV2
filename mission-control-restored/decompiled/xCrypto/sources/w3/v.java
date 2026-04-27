package w3;

import W2.E;
import W2.p;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.C1832p;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends x3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15680a = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_state");
    private volatile Object _state;

    @Override // x3.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(t tVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15680a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, u.f15678a);
        return true;
    }

    public final Object e(Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        if (!androidx.concurrent.futures.b.a(f15680a, this, u.f15678a, c1832p)) {
            p.a aVar = W2.p.f5487b;
            c1832p.resumeWith(W2.p.b(E.f5463a));
        }
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : E.f5463a;
    }

    @Override // x3.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Z2.e[] b(t tVar) {
        f15680a.set(this, null);
        return x3.c.f15756a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15680a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == u.f15679b) {
                return;
            }
            if (obj == u.f15678a) {
                if (androidx.concurrent.futures.b.a(f15680a, this, obj, u.f15679b)) {
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f15680a, this, obj, u.f15678a)) {
                p.a aVar = W2.p.f5487b;
                ((C1832p) obj).resumeWith(W2.p.b(E.f5463a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f15680a.getAndSet(this, u.f15678a);
        kotlin.jvm.internal.r.c(andSet);
        return andSet == u.f15679b;
    }
}
