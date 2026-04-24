package d7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2304t;
import y.AbstractC2965b;

/* JADX INFO: renamed from: d7.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1641b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17041a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1641b.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17042b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1641b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC1641b(AbstractC1641b abstractC1641b) {
        this._prev$volatile = abstractC1641b;
    }

    public final void c() {
        f17042b.set(this, null);
    }

    public final AbstractC1641b d() {
        AbstractC1641b abstractC1641bH = h();
        while (abstractC1641bH != null && abstractC1641bH.k()) {
            abstractC1641bH = (AbstractC1641b) f17042b.get(abstractC1641bH);
        }
        return abstractC1641bH;
    }

    public final AbstractC1641b e() {
        AbstractC1641b abstractC1641bF = f();
        AbstractC2304t.c(abstractC1641bF);
        while (abstractC1641bF.k()) {
            AbstractC1641b abstractC1641bF2 = abstractC1641bF.f();
            if (abstractC1641bF2 == null) {
                return abstractC1641bF;
            }
            abstractC1641bF = abstractC1641bF2;
        }
        return abstractC1641bF;
    }

    public final AbstractC1641b f() {
        Object objG = g();
        if (objG == AbstractC1640a.f17040a) {
            return null;
        }
        return (AbstractC1641b) objG;
    }

    public final Object g() {
        return f17041a.get(this);
    }

    public final AbstractC1641b h() {
        return (AbstractC1641b) f17042b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return AbstractC2965b.a(f17041a, this, null, AbstractC1640a.f17040a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            AbstractC1641b abstractC1641bD = d();
            AbstractC1641b abstractC1641bE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17042b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1641bE);
            } while (!AbstractC2965b.a(atomicReferenceFieldUpdater, abstractC1641bE, obj, ((AbstractC1641b) obj) == null ? null : abstractC1641bD));
            if (abstractC1641bD != null) {
                f17041a.set(abstractC1641bD, abstractC1641bE);
            }
            if (!abstractC1641bE.k() || abstractC1641bE.l()) {
                if (abstractC1641bD == null || !abstractC1641bD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(AbstractC1641b abstractC1641b) {
        return AbstractC2965b.a(f17041a, this, null, abstractC1641b);
    }
}
