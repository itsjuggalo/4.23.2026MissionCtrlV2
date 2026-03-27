package d7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2304t;
import y.AbstractC2965b;

/* JADX INFO: renamed from: d7.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1654o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17063a = AtomicReferenceFieldUpdater.newUpdater(C1654o.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17064b = AtomicReferenceFieldUpdater.newUpdater(C1654o.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17065c = AtomicReferenceFieldUpdater.newUpdater(C1654o.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean b(C1654o c1654o, int i8) {
        C1654o c1654oM;
        do {
            c1654oM = m();
            if (c1654oM instanceof C1652m) {
                return (((C1652m) c1654oM).f17062d & i8) == 0 && c1654oM.b(c1654o, i8);
            }
        } while (!c1654oM.e(c1654o, this));
        return true;
    }

    public final boolean e(C1654o c1654o, C1654o c1654o2) {
        f17064b.set(c1654o, this);
        f17063a.set(c1654o, c1654o2);
        if (!AbstractC2965b.a(f17063a, this, c1654o2, c1654o)) {
            return false;
        }
        c1654o.j(c1654o2);
        return true;
    }

    public final boolean f(C1654o c1654o) {
        f17064b.set(c1654o, this);
        f17063a.set(c1654o, this);
        while (k() == this) {
            if (AbstractC2965b.a(f17063a, this, this, c1654o)) {
                c1654o.j(this);
                return true;
            }
        }
        return false;
    }

    public final void g(int i8) {
        b(new C1652m(i8), i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (y.AbstractC2965b.a(d7.C1654o.f17063a, r3, r2, ((d7.x) r4).f17081a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d7.C1654o h() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o()
            java.lang.Object r0 = r0.get(r7)
            d7.o r0 = (d7.C1654o) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            return r2
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o()
            boolean r0 = y.AbstractC2965b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.q()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof d7.x
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = n()
            d7.x r4 = (d7.x) r4
            d7.o r4 = r4.f17081a
            boolean r2 = y.AbstractC2965b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = o()
            java.lang.Object r2 = r4.get(r2)
            d7.o r2 = (d7.C1654o) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.AbstractC2304t.d(r4, r3)
            r3 = r4
            d7.o r3 = (d7.C1654o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.C1654o.h():d7.o");
    }

    public final C1654o i(C1654o c1654o) {
        while (c1654o.q()) {
            c1654o = (C1654o) f17064b.get(c1654o);
        }
        return c1654o;
    }

    public final void j(C1654o c1654o) {
        C1654o c1654o2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17064b;
        do {
            c1654o2 = (C1654o) atomicReferenceFieldUpdater.get(c1654o);
            if (k() != c1654o) {
                return;
            }
        } while (!AbstractC2965b.a(f17064b, c1654o, c1654o2, this));
        if (q()) {
            c1654o.h();
        }
    }

    public final Object k() {
        return f17063a.get(this);
    }

    public final C1654o l() {
        C1654o c1654o;
        Object objK = k();
        x xVar = objK instanceof x ? (x) objK : null;
        if (xVar != null && (c1654o = xVar.f17081a) != null) {
            return c1654o;
        }
        AbstractC2304t.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (C1654o) objK;
    }

    public final C1654o m() {
        C1654o c1654oH = h();
        return c1654oH == null ? i((C1654o) f17064b.get(this)) : c1654oH;
    }

    public boolean q() {
        return k() instanceof x;
    }

    public boolean r() {
        return s() == null;
    }

    public final C1654o s() {
        Object objK;
        C1654o c1654o;
        do {
            objK = k();
            if (objK instanceof x) {
                return ((x) objK).f17081a;
            }
            if (objK == this) {
                return (C1654o) objK;
            }
            AbstractC2304t.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            c1654o = (C1654o) objK;
        } while (!AbstractC2965b.a(f17063a, this, objK, c1654o.t()));
        c1654o.h();
        return null;
    }

    public final x t() {
        x xVar = (x) f17065c.get(this);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f17065c.set(this, xVar2);
        return xVar2;
    }

    public String toString() {
        return new kotlin.jvm.internal.E(this) { // from class: d7.o.a
            @Override // I5.n
            public Object get() {
                return Y6.P.a(this.receiver);
            }
        } + '@' + Y6.P.b(this);
    }
}
