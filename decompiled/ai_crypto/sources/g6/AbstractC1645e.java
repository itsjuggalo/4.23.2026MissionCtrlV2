package g6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import v.AbstractC2759b;

/* JADX INFO: renamed from: g6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1645e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14292a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1645e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14293b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1645e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC1645e(AbstractC1645e abstractC1645e) {
        this._prev = abstractC1645e;
    }

    public final void b() {
        f14293b.lazySet(this, null);
    }

    public final AbstractC1645e c() {
        AbstractC1645e abstractC1645eG = g();
        while (abstractC1645eG != null && abstractC1645eG.h()) {
            abstractC1645eG = (AbstractC1645e) f14293b.get(abstractC1645eG);
        }
        return abstractC1645eG;
    }

    public final AbstractC1645e d() {
        AbstractC1645e abstractC1645eE = e();
        kotlin.jvm.internal.r.c(abstractC1645eE);
        while (abstractC1645eE.h()) {
            AbstractC1645e abstractC1645eE2 = abstractC1645eE.e();
            if (abstractC1645eE2 == null) {
                return abstractC1645eE;
            }
            abstractC1645eE = abstractC1645eE2;
        }
        return abstractC1645eE;
    }

    public final AbstractC1645e e() {
        Object objF = f();
        if (objF == AbstractC1644d.f14291a) {
            return null;
        }
        return (AbstractC1645e) objF;
    }

    public final Object f() {
        return f14292a.get(this);
    }

    public final AbstractC1645e g() {
        return (AbstractC1645e) f14293b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return AbstractC2759b.a(f14292a, this, null, AbstractC1644d.f14291a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            AbstractC1645e abstractC1645eC = c();
            AbstractC1645e abstractC1645eD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14293b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1645eD);
            } while (!AbstractC2759b.a(atomicReferenceFieldUpdater, abstractC1645eD, obj, ((AbstractC1645e) obj) == null ? null : abstractC1645eC));
            if (abstractC1645eC != null) {
                f14292a.set(abstractC1645eC, abstractC1645eD);
            }
            if (!abstractC1645eD.h() || abstractC1645eD.i()) {
                if (abstractC1645eC == null || !abstractC1645eC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(AbstractC1645e abstractC1645e) {
        return AbstractC2759b.a(f14292a, this, null, abstractC1645e);
    }
}
