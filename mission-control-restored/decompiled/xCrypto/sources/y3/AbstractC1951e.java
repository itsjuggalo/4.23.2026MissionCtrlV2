package y3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: y3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1951e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15978a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1951e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15979b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1951e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC1951e(AbstractC1951e abstractC1951e) {
        this._prev = abstractC1951e;
    }

    public final void b() {
        f15979b.lazySet(this, null);
    }

    public final AbstractC1951e c() {
        AbstractC1951e abstractC1951eG = g();
        while (abstractC1951eG != null && abstractC1951eG.h()) {
            abstractC1951eG = (AbstractC1951e) f15979b.get(abstractC1951eG);
        }
        return abstractC1951eG;
    }

    public final AbstractC1951e d() {
        AbstractC1951e abstractC1951eE;
        AbstractC1951e abstractC1951eE2 = e();
        kotlin.jvm.internal.r.c(abstractC1951eE2);
        while (abstractC1951eE2.h() && (abstractC1951eE = abstractC1951eE2.e()) != null) {
            abstractC1951eE2 = abstractC1951eE;
        }
        return abstractC1951eE2;
    }

    public final AbstractC1951e e() {
        Object objF = f();
        if (objF == AbstractC1950d.f15977a) {
            return null;
        }
        return (AbstractC1951e) objF;
    }

    public final Object f() {
        return f15978a.get(this);
    }

    public final AbstractC1951e g() {
        return (AbstractC1951e) f15979b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return androidx.concurrent.futures.b.a(f15978a, this, null, AbstractC1950d.f15977a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            AbstractC1951e abstractC1951eC = c();
            AbstractC1951e abstractC1951eD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15979b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1951eD);
            } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, abstractC1951eD, obj, ((AbstractC1951e) obj) == null ? null : abstractC1951eC));
            if (abstractC1951eC != null) {
                f15978a.set(abstractC1951eC, abstractC1951eD);
            }
            if (!abstractC1951eD.h() || abstractC1951eD.i()) {
                if (abstractC1951eC == null || !abstractC1951eC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(AbstractC1951e abstractC1951e) {
        return androidx.concurrent.futures.b.a(f15978a, this, null, abstractC1951e);
    }
}
