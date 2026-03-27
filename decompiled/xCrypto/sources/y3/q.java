package y3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.P;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15999a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f16000b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f16001c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends AbstractC1948b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f16002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q f16003c;

        public a(q qVar) {
            this.f16002b = qVar;
        }

        @Override // y3.AbstractC1948b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, Object obj) {
            boolean z4 = obj == null;
            q qVar2 = z4 ? this.f16002b : this.f16003c;
            if (qVar2 != null && androidx.concurrent.futures.b.a(q.f15999a, qVar, this, qVar2) && z4) {
                q qVar3 = this.f16002b;
                q qVar4 = this.f16003c;
                kotlin.jvm.internal.r.c(qVar4);
                qVar3.h(qVar4);
            }
        }
    }

    public final boolean e(q qVar) {
        f16000b.lazySet(qVar, this);
        f15999a.lazySet(qVar, this);
        while (i() == this) {
            if (androidx.concurrent.futures.b.a(f15999a, this, this, qVar)) {
                qVar.h(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (androidx.concurrent.futures.b.a(r4, r3, r2, ((y3.z) r5).f16019a) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y3.q f(y3.y r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = y3.q.f16000b
            java.lang.Object r0 = r0.get(r8)
            y3.q r0 = (y3.q) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = y3.q.f15999a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L1f
            if (r0 != r2) goto L16
            goto L28
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = y3.q.f16000b
            boolean r0 = androidx.concurrent.futures.b.a(r1, r8, r0, r2)
            if (r0 != 0) goto L28
            goto L0
        L1f:
            boolean r6 = r8.l()
            if (r6 == 0) goto L26
            return r1
        L26:
            if (r5 != r9) goto L29
        L28:
            return r2
        L29:
            boolean r6 = r5 instanceof y3.y
            if (r6 == 0) goto L33
            y3.y r5 = (y3.y) r5
            r5.a(r2)
            goto L0
        L33:
            boolean r6 = r5 instanceof y3.z
            if (r6 == 0) goto L4f
            if (r3 == 0) goto L46
            y3.z r5 = (y3.z) r5
            y3.q r5 = r5.f16019a
            boolean r2 = androidx.concurrent.futures.b.a(r4, r3, r2, r5)
            if (r2 != 0) goto L44
            goto L0
        L44:
            r2 = r3
            goto La
        L46:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = y3.q.f16000b
            java.lang.Object r2 = r4.get(r2)
            y3.q r2 = (y3.q) r2
            goto Lb
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.r.d(r5, r3)
            r3 = r5
            y3.q r3 = (y3.q) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.q.f(y3.y):y3.q");
    }

    public final q g(q qVar) {
        while (qVar.l()) {
            qVar = (q) f16000b.get(qVar);
        }
        return qVar;
    }

    public final void h(q qVar) {
        q qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16000b;
        do {
            qVar2 = (q) atomicReferenceFieldUpdater.get(qVar);
            if (i() != qVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f16000b, qVar, qVar2, this));
        if (l()) {
            qVar.f(null);
        }
    }

    public final Object i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15999a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final q j() {
        return p.b(i());
    }

    public final q k() {
        q qVarF = f(null);
        return qVarF == null ? g((q) f16000b.get(this)) : qVarF;
    }

    public boolean l() {
        return i() instanceof z;
    }

    public boolean m() {
        return n() == null;
    }

    public final q n() {
        Object objI;
        q qVar;
        do {
            objI = i();
            if (objI instanceof z) {
                return ((z) objI).f16019a;
            }
            if (objI == this) {
                return (q) objI;
            }
            kotlin.jvm.internal.r.d(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            qVar = (q) objI;
        } while (!androidx.concurrent.futures.b.a(f15999a, this, objI, qVar.o()));
        qVar.f(null);
        return null;
    }

    public final z o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16001c;
        z zVar = (z) atomicReferenceFieldUpdater.get(this);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        atomicReferenceFieldUpdater.lazySet(this, zVar2);
        return zVar2;
    }

    public final int p(q qVar, q qVar2, a aVar) {
        f16000b.lazySet(qVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15999a;
        atomicReferenceFieldUpdater.lazySet(qVar, qVar2);
        aVar.f16003c = qVar2;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, qVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new kotlin.jvm.internal.z(this) { // from class: y3.q.b
            @Override // p3.i
            public Object get() {
                return P.a(this.receiver);
            }
        } + '@' + P.b(this);
    }
}
