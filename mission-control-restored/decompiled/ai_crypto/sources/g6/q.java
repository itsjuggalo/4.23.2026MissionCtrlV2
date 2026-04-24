package g6;

import b6.P;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import v.AbstractC2759b;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14313a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14314b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14315c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends AbstractC1642b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f14316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q f14317c;

        public a(q qVar) {
            this.f14316b = qVar;
        }

        @Override // g6.AbstractC1642b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, Object obj) {
            boolean z7 = obj == null;
            q qVar2 = z7 ? this.f14316b : this.f14317c;
            if (qVar2 != null && AbstractC2759b.a(q.f14313a, qVar, this, qVar2) && z7) {
                q qVar3 = this.f14316b;
                q qVar4 = this.f14317c;
                kotlin.jvm.internal.r.c(qVar4);
                qVar3.j(qVar4);
            }
        }
    }

    public final boolean g(q qVar) {
        f14314b.lazySet(qVar, this);
        f14313a.lazySet(qVar, this);
        while (k() == this) {
            if (AbstractC2759b.a(f14313a, this, this, qVar)) {
                qVar.j(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (v.AbstractC2759b.a(r4, r3, r2, ((g6.z) r5).f14333a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g6.q h(g6.y r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = g6.q.f14314b
            java.lang.Object r0 = r0.get(r8)
            g6.q r0 = (g6.q) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = g6.q.f14313a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = g6.q.f14314b
            boolean r0 = v.AbstractC2759b.a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.n()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof g6.y
            if (r6 == 0) goto L34
            g6.y r5 = (g6.y) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof g6.z
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            g6.z r5 = (g6.z) r5
            g6.q r5 = r5.f14333a
            boolean r2 = v.AbstractC2759b.a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = g6.q.f14314b
            java.lang.Object r2 = r4.get(r2)
            g6.q r2 = (g6.q) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.r.d(r5, r3)
            r3 = r5
            g6.q r3 = (g6.q) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.q.h(g6.y):g6.q");
    }

    public final q i(q qVar) {
        while (qVar.n()) {
            qVar = (q) f14314b.get(qVar);
        }
        return qVar;
    }

    public final void j(q qVar) {
        q qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14314b;
        do {
            qVar2 = (q) atomicReferenceFieldUpdater.get(qVar);
            if (k() != qVar) {
                return;
            }
        } while (!AbstractC2759b.a(f14314b, qVar, qVar2, this));
        if (n()) {
            qVar.h(null);
        }
    }

    public final Object k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14313a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final q l() {
        return p.b(k());
    }

    public final q m() {
        q qVarH = h(null);
        return qVarH == null ? i((q) f14314b.get(this)) : qVarH;
    }

    public boolean n() {
        return k() instanceof z;
    }

    public boolean o() {
        return p() == null;
    }

    public final q p() {
        Object objK;
        q qVar;
        do {
            objK = k();
            if (objK instanceof z) {
                return ((z) objK).f14333a;
            }
            if (objK == this) {
                return (q) objK;
            }
            kotlin.jvm.internal.r.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            qVar = (q) objK;
        } while (!AbstractC2759b.a(f14313a, this, objK, qVar.q()));
        qVar.h(null);
        return null;
    }

    public final z q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14315c;
        z zVar = (z) atomicReferenceFieldUpdater.get(this);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        atomicReferenceFieldUpdater.lazySet(this, zVar2);
        return zVar2;
    }

    public final int r(q qVar, q qVar2, a aVar) {
        f14314b.lazySet(qVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14313a;
        atomicReferenceFieldUpdater.lazySet(qVar, qVar2);
        aVar.f14317c = qVar2;
        if (AbstractC2759b.a(atomicReferenceFieldUpdater, this, qVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new kotlin.jvm.internal.z(this) { // from class: g6.q.b
            @Override // X5.h
            public Object get() {
                return P.a(this.receiver);
            }
        } + '@' + P.b(this);
    }
}
