package sg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20412a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20413b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20414c = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(o oVar, int i10) {
        o oVarL;
        do {
            oVarL = l();
            if (oVarL instanceof m) {
                return (((m) oVarL).f20409d & i10) == 0 && oVarL.c(oVar, i10);
            }
        } while (!oVarL.d(oVar, this));
        return true;
    }

    public final boolean d(o oVar, o oVar2) {
        f20413b.set(oVar, this);
        f20412a.set(oVar, oVar2);
        if (!y.b.a(f20412a, this, oVar2, oVar)) {
            return false;
        }
        oVar.i(oVar2);
        return true;
    }

    public final boolean e(o oVar) {
        f20413b.set(oVar, this);
        f20412a.set(oVar, this);
        while (j() == this) {
            if (y.b.a(f20412a, this, this, oVar)) {
                oVar.i(this);
                return true;
            }
        }
        return false;
    }

    public final void f(int i10) {
        c(new m(i10), i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (y.b.a(sg.o.f20412a, r3, r2, ((sg.x) r4).f20434a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final sg.o g() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = n()
            java.lang.Object r0 = r0.get(r7)
            sg.o r0 = (sg.o) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            goto L25
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = n()
            boolean r0 = y.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.p()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof sg.x
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = m()
            sg.x r4 = (sg.x) r4
            sg.o r4 = r4.f20434a
            boolean r2 = y.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r2 = r4.get(r2)
            sg.o r2 = (sg.o) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.t.d(r4, r3)
            r3 = r4
            sg.o r3 = (sg.o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.o.g():sg.o");
    }

    public final o h(o oVar) {
        while (oVar.p()) {
            oVar = (o) f20413b.get(oVar);
        }
        return oVar;
    }

    public final void i(o oVar) {
        o oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20413b;
        do {
            oVar2 = (o) atomicReferenceFieldUpdater.get(oVar);
            if (j() != oVar) {
                return;
            }
        } while (!y.b.a(f20413b, oVar, oVar2, this));
        if (p()) {
            oVar.g();
        }
    }

    public final Object j() {
        return f20412a.get(this);
    }

    public final o k() {
        o oVar;
        Object objJ = j();
        x xVar = objJ instanceof x ? (x) objJ : null;
        if (xVar != null && (oVar = xVar.f20434a) != null) {
            return oVar;
        }
        kotlin.jvm.internal.t.d(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (o) objJ;
    }

    public final o l() {
        o oVarG = g();
        return oVarG == null ? h((o) f20413b.get(this)) : oVarG;
    }

    public boolean p() {
        return j() instanceof x;
    }

    public boolean q() {
        return r() == null;
    }

    public final o r() {
        Object objJ;
        o oVar;
        do {
            objJ = j();
            if (objJ instanceof x) {
                return ((x) objJ).f20434a;
            }
            if (objJ == this) {
                return (o) objJ;
            }
            kotlin.jvm.internal.t.d(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            oVar = (o) objJ;
        } while (!y.b.a(f20412a, this, objJ, oVar.s()));
        oVar.g();
        return null;
    }

    public final x s() {
        x xVar = (x) f20414c.get(this);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f20414c.set(this, xVar2);
        return xVar2;
    }

    public String toString() {
        return new kotlin.jvm.internal.e0(this) { // from class: sg.o.a
            @Override // wd.n
            public Object get() {
                return r0.a(this.receiver);
            }
        } + '@' + r0.b(this);
    }
}
