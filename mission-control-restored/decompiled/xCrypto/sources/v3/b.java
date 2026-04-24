package v3;

import W2.AbstractC0737e;
import W2.p;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import b3.AbstractC0864b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.C1832p;
import t3.InterfaceC1830o;
import t3.b1;
import y3.AbstractC1950d;
import y3.AbstractC1951e;
import y3.AbstractC1958l;
import y3.C;
import y3.D;
import y3.E;
import y3.O;
import y3.x;

/* JADX INFO: loaded from: classes3.dex */
public class b implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15322d = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15323e = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15324f = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15325g = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15326h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15327i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15328j = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15329k = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15330l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.k f15332b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i3.p f15333c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public final class a implements f, b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15334a = c.f15355p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C1832p f15335b;

        public a() {
        }

        @Override // v3.f
        public Object a(Z2.e eVar) {
            b bVar = b.this;
            j jVar = (j) b.f15327i.get(bVar);
            while (!bVar.U()) {
                long andIncrement = b.f15323e.getAndIncrement(bVar);
                int i4 = c.f15341b;
                long j4 = andIncrement / ((long) i4);
                int i5 = (int) (andIncrement % ((long) i4));
                if (jVar.f15955c != j4) {
                    j jVarG = bVar.G(j4, jVar);
                    if (jVarG == null) {
                        continue;
                    } else {
                        jVar = jVarG;
                    }
                }
                Object objZ0 = bVar.z0(jVar, i5, andIncrement, null);
                if (objZ0 == c.f15352m) {
                    throw new IllegalStateException("unreachable");
                }
                if (objZ0 != c.f15354o) {
                    if (objZ0 == c.f15353n) {
                        return f(jVar, i5, andIncrement, eVar);
                    }
                    jVar.b();
                    this.f15334a = objZ0;
                    return AbstractC0864b.a(true);
                }
                if (andIncrement < bVar.N()) {
                    jVar.b();
                }
            }
            return AbstractC0864b.a(g());
        }

        @Override // t3.b1
        public void b(C c4, int i4) {
            C1832p c1832p = this.f15335b;
            if (c1832p != null) {
                c1832p.b(c4, i4);
            }
        }

        public final Object f(j jVar, int i4, long j4, Z2.e eVar) throws Throwable {
            Boolean boolA;
            j jVarG;
            b bVar = b.this;
            C1832p c1832pB = t3.r.b(AbstractC0786b.c(eVar));
            try {
                this.f15335b = c1832pB;
                try {
                    Object objZ0 = bVar.z0(jVar, i4, j4, this);
                    if (objZ0 == c.f15352m) {
                        bVar.k0(this, jVar, i4);
                    } else {
                        i3.k kVarA = null;
                        if (objZ0 == c.f15354o) {
                            if (j4 < bVar.N()) {
                                jVar.b();
                            }
                            j jVar2 = (j) b.f15327i.get(bVar);
                            while (true) {
                                if (bVar.U()) {
                                    h();
                                    break;
                                }
                                long andIncrement = b.f15323e.getAndIncrement(bVar);
                                int i5 = c.f15341b;
                                long j5 = andIncrement / ((long) i5);
                                int i6 = (int) (andIncrement % ((long) i5));
                                if (jVar2.f15955c != j5) {
                                    jVarG = bVar.G(j5, jVar2);
                                    if (jVarG == null) {
                                    }
                                } else {
                                    jVarG = jVar2;
                                }
                                Object objZ02 = bVar.z0(jVarG, i6, andIncrement, this);
                                if (objZ02 == c.f15352m) {
                                    bVar.k0(this, jVarG, i6);
                                    break;
                                }
                                if (objZ02 == c.f15354o) {
                                    if (andIncrement < bVar.N()) {
                                        jVarG.b();
                                    }
                                    jVar2 = jVarG;
                                } else {
                                    if (objZ02 == c.f15353n) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    jVarG.b();
                                    this.f15334a = objZ02;
                                    this.f15335b = null;
                                    boolA = AbstractC0864b.a(true);
                                    i3.k kVar = bVar.f15332b;
                                    if (kVar != null) {
                                        kVarA = x.a(kVar, objZ02, c1832pB.getContext());
                                    }
                                }
                            }
                        } else {
                            jVar.b();
                            this.f15334a = objZ0;
                            this.f15335b = null;
                            boolA = AbstractC0864b.a(true);
                            i3.k kVar2 = bVar.f15332b;
                            if (kVar2 != null) {
                                kVarA = x.a(kVar2, objZ0, c1832pB.getContext());
                            }
                        }
                        c1832pB.h(boolA, kVarA);
                    }
                    Object objX = c1832pB.x();
                    if (objX == AbstractC0787c.e()) {
                        b3.h.c(eVar);
                    }
                    return objX;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    c1832pB.I();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final boolean g() throws Throwable {
            this.f15334a = c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                return false;
            }
            throw E.a(thJ);
        }

        public final void h() {
            C1832p c1832p = this.f15335b;
            kotlin.jvm.internal.r.c(c1832p);
            this.f15335b = null;
            this.f15334a = c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                p.a aVar = W2.p.f5487b;
                c1832p.resumeWith(W2.p.b(Boolean.FALSE));
            } else {
                p.a aVar2 = W2.p.f5487b;
                c1832p.resumeWith(W2.p.b(W2.q.a(thJ)));
            }
        }

        public final boolean i(Object obj) {
            C1832p c1832p = this.f15335b;
            kotlin.jvm.internal.r.c(c1832p);
            this.f15335b = null;
            this.f15334a = obj;
            Boolean bool = Boolean.TRUE;
            i3.k kVar = b.this.f15332b;
            return c.B(c1832p, bool, kVar != null ? x.a(kVar, obj, c1832p.getContext()) : null);
        }

        public final void j() {
            C1832p c1832p = this.f15335b;
            kotlin.jvm.internal.r.c(c1832p);
            this.f15335b = null;
            this.f15334a = c.z();
            Throwable thJ = b.this.J();
            if (thJ == null) {
                p.a aVar = W2.p.f5487b;
                c1832p.resumeWith(W2.p.b(Boolean.FALSE));
            } else {
                p.a aVar2 = W2.p.f5487b;
                c1832p.resumeWith(W2.p.b(W2.q.a(thJ)));
            }
        }

        @Override // v3.f
        public Object next() throws Throwable {
            Object obj = this.f15334a;
            if (obj == c.f15355p) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.f15334a = c.f15355p;
            if (obj != c.z()) {
                return obj;
            }
            throw E.a(b.this.K());
        }
    }

    /* JADX INFO: renamed from: v3.b$b, reason: collision with other inner class name */
    public static final class C0247b extends kotlin.jvm.internal.s implements i3.p {

        /* JADX INFO: renamed from: v3.b$b$a */
        public static final class a extends kotlin.jvm.internal.s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f15338a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f15339b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, b bVar, B3.e eVar) {
                super(1);
                this.f15338a = obj;
                this.f15339b = bVar;
            }

            public final void a(Throwable th) {
                if (this.f15338a == c.z()) {
                    return;
                }
                i3.k kVar = this.f15339b.f15332b;
                throw null;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return W2.E.f5463a;
            }
        }

        public C0247b() {
            super(3);
        }

        public final i3.k a(B3.e eVar, Object obj, Object obj2) {
            return new a(obj2, b.this, eVar);
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj);
            return a(null, obj2, obj3);
        }
    }

    public b(int i4, i3.k kVar) {
        this.f15331a = i4;
        this.f15332b = kVar;
        if (i4 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i4 + ", should be >=0").toString());
        }
        this.bufferEnd = c.A(i4);
        this.completedExpandBuffersAndPauseFlag = I();
        j jVar = new j(0L, null, this, 3);
        this.sendSegment = jVar;
        this.receiveSegment = jVar;
        if (Y()) {
            jVar = c.f15340a;
            kotlin.jvm.internal.r.d(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = jVar;
        this.f15333c = kVar != null ? new C0247b() : null;
        this._closeCause = c.f15358s;
    }

    public static /* synthetic */ void Q(b bVar, long j4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i4 & 1) != 0) {
            j4 = 1;
        }
        bVar.P(j4);
    }

    public static /* synthetic */ Object m0(b bVar, Z2.e eVar) throws Throwable {
        j jVar;
        j jVar2 = (j) f15327i.get(bVar);
        while (!bVar.U()) {
            long andIncrement = f15323e.getAndIncrement(bVar);
            int i4 = c.f15341b;
            long j4 = andIncrement / ((long) i4);
            int i5 = (int) (andIncrement % ((long) i4));
            if (jVar2.f15955c != j4) {
                j jVarG = bVar.G(j4, jVar2);
                if (jVarG == null) {
                    continue;
                } else {
                    jVar = jVarG;
                }
            } else {
                jVar = jVar2;
            }
            b bVar2 = bVar;
            Object objZ0 = bVar2.z0(jVar, i5, andIncrement, null);
            if (objZ0 == c.f15352m) {
                throw new IllegalStateException("unexpected");
            }
            if (objZ0 != c.f15354o) {
                if (objZ0 == c.f15353n) {
                    return bVar2.n0(jVar, i5, andIncrement, eVar);
                }
                jVar.b();
                return objZ0;
            }
            if (andIncrement < bVar2.N()) {
                jVar.b();
            }
            bVar = bVar2;
            jVar2 = jVar;
        }
        throw E.a(bVar.K());
    }

    public static /* synthetic */ Object s0(b bVar, Object obj, Z2.e eVar) throws IllegalAccessException, InvocationTargetException {
        j jVar;
        j jVar2 = (j) f15326h.get(bVar);
        while (true) {
            long andIncrement = f15322d.getAndIncrement(bVar);
            long j4 = andIncrement & 1152921504606846975L;
            boolean zW = bVar.W(andIncrement);
            int i4 = c.f15341b;
            long j5 = j4 / ((long) i4);
            int i5 = (int) (j4 % ((long) i4));
            if (jVar2.f15955c != j5) {
                j jVarH = bVar.H(j5, jVar2);
                if (jVarH != null) {
                    jVar = jVarH;
                } else if (zW) {
                    Object objG0 = bVar.g0(obj, eVar);
                    if (objG0 == AbstractC0787c.e()) {
                        return objG0;
                    }
                }
            } else {
                jVar = jVar2;
            }
            b bVar2 = bVar;
            Object obj2 = obj;
            int iB0 = bVar2.B0(jVar, i5, obj2, j4, null, zW);
            if (iB0 == 0) {
                jVar.b();
                break;
            }
            if (iB0 == 1) {
                break;
            }
            if (iB0 != 2) {
                if (iB0 == 3) {
                    Object objT0 = bVar2.t0(jVar, i5, obj2, j4, eVar);
                    if (objT0 == AbstractC0787c.e()) {
                        return objT0;
                    }
                } else if (iB0 != 4) {
                    if (iB0 == 5) {
                        jVar.b();
                    }
                    bVar = bVar2;
                    jVar2 = jVar;
                    obj = obj2;
                } else {
                    if (j4 < bVar2.L()) {
                        jVar.b();
                    }
                    Object objG02 = bVar2.g0(obj2, eVar);
                    if (objG02 == AbstractC0787c.e()) {
                        return objG02;
                    }
                }
            } else if (zW) {
                jVar.p();
                Object objG03 = bVar2.g0(obj2, eVar);
                if (objG03 == AbstractC0787c.e()) {
                    return objG03;
                }
            }
        }
        return W2.E.f5463a;
    }

    public final void A(long j4) throws IllegalAccessException, InvocationTargetException {
        o0(B(j4));
    }

    public final Object A0(j jVar, int i4, long j4, Object obj) {
        while (true) {
            Object objW = jVar.w(i4);
            if (objW == null || objW == c.f15344e) {
                if (j4 < (f15322d.get(this) & 1152921504606846975L)) {
                    if (jVar.r(i4, objW, c.f15347h)) {
                        E();
                        return c.f15354o;
                    }
                } else {
                    if (obj == null) {
                        return c.f15353n;
                    }
                    if (jVar.r(i4, objW, obj)) {
                        E();
                        return c.f15352m;
                    }
                }
            } else {
                if (objW != c.f15343d) {
                    if (objW != c.f15349j && objW != c.f15347h) {
                        if (objW == c.z()) {
                            E();
                            return c.f15354o;
                        }
                        if (objW != c.f15346g && jVar.r(i4, objW, c.f15345f)) {
                            boolean z4 = objW instanceof v;
                            if (z4) {
                                objW = ((v) objW).f15381a;
                            }
                            if (w0(objW, jVar, i4)) {
                                jVar.A(i4, c.f15348i);
                                E();
                                return jVar.y(i4);
                            }
                            jVar.A(i4, c.f15349j);
                            jVar.x(i4, false);
                            if (z4) {
                                E();
                            }
                            return c.f15354o;
                        }
                    }
                    return c.f15354o;
                }
                if (jVar.r(i4, objW, c.f15348i)) {
                    E();
                    return jVar.y(i4);
                }
            }
        }
    }

    public final j B(long j4) {
        j jVarY = y();
        if (X()) {
            long jZ = Z(jVarY);
            if (jZ != -1) {
                D(jZ);
            }
        }
        x(jVarY, j4);
        return jVarY;
    }

    public final int B0(j jVar, int i4, Object obj, long j4, Object obj2, boolean z4) {
        jVar.B(i4, obj);
        if (z4) {
            return C0(jVar, i4, obj, j4, obj2, z4);
        }
        Object objW = jVar.w(i4);
        if (objW == null) {
            if (v(j4)) {
                if (jVar.r(i4, null, c.f15343d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (jVar.r(i4, null, obj2)) {
                    return 2;
                }
            }
        } else if (objW instanceof b1) {
            jVar.s(i4);
            if (v0(objW, obj)) {
                jVar.A(i4, c.f15348i);
                i0();
                return 0;
            }
            if (jVar.t(i4, c.f15350k) == c.f15350k) {
                return 5;
            }
            jVar.x(i4, true);
            return 5;
        }
        return C0(jVar, i4, obj, j4, obj2, z4);
    }

    public final void C() {
        n();
    }

    public final int C0(j jVar, int i4, Object obj, long j4, Object obj2, boolean z4) {
        while (true) {
            Object objW = jVar.w(i4);
            if (objW == null) {
                if (!v(j4) || z4) {
                    if (z4) {
                        if (jVar.r(i4, null, c.f15349j)) {
                            jVar.x(i4, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (jVar.r(i4, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (jVar.r(i4, null, c.f15343d)) {
                    return 1;
                }
            } else {
                if (objW != c.f15344e) {
                    if (objW == c.f15350k) {
                        jVar.s(i4);
                        return 5;
                    }
                    if (objW == c.f15347h) {
                        jVar.s(i4);
                        return 5;
                    }
                    if (objW == c.z()) {
                        jVar.s(i4);
                        C();
                        return 4;
                    }
                    jVar.s(i4);
                    if (objW instanceof v) {
                        objW = ((v) objW).f15381a;
                    }
                    if (v0(objW, obj)) {
                        jVar.A(i4, c.f15348i);
                        i0();
                        return 0;
                    }
                    if (jVar.t(i4, c.f15350k) != c.f15350k) {
                        jVar.x(i4, true);
                    }
                    return 5;
                }
                if (jVar.r(i4, objW, c.f15343d)) {
                    return 1;
                }
            }
        }
    }

    public final void D(long j4) {
        O oD;
        j jVar = (j) f15327i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f15323e;
            long j5 = atomicLongFieldUpdater.get(this);
            if (j4 < Math.max(((long) this.f15331a) + j5, I())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j5, 1 + j5)) {
                int i4 = c.f15341b;
                long j6 = j5 / ((long) i4);
                int i5 = (int) (j5 % ((long) i4));
                if (jVar.f15955c != j6) {
                    j jVarG = G(j6, jVar);
                    if (jVarG == null) {
                        continue;
                    } else {
                        jVar = jVarG;
                    }
                }
                j jVar2 = jVar;
                Object objZ0 = z0(jVar2, i5, j5, null);
                if (objZ0 != c.f15354o) {
                    jVar2.b();
                    i3.k kVar = this.f15332b;
                    if (kVar != null && (oD = x.d(kVar, objZ0, null, 2, null)) != null) {
                        throw oD;
                    }
                } else if (j5 < N()) {
                    jVar2.b();
                }
                jVar = jVar2;
            }
        }
    }

    public final void D0(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15323e;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if (j5 >= j4) {
                return;
            }
            long j6 = j4;
            if (f15323e.compareAndSet(this, j5, j6)) {
                return;
            } else {
                j4 = j6;
            }
        }
    }

    public final void E() {
        if (Y()) {
            return;
        }
        j jVar = (j) f15328j.get(this);
        while (true) {
            long andIncrement = f15324f.getAndIncrement(this);
            int i4 = c.f15341b;
            long j4 = andIncrement / ((long) i4);
            if (N() <= andIncrement) {
                if (jVar.f15955c < j4 && jVar.e() != null) {
                    d0(j4, jVar);
                }
                Q(this, 0L, 1, null);
                return;
            }
            if (jVar.f15955c != j4) {
                j jVarF = F(j4, jVar, andIncrement);
                if (jVarF == null) {
                    continue;
                } else {
                    jVar = jVarF;
                }
            }
            if (x0(jVar, (int) (andIncrement % ((long) i4)), andIncrement)) {
                Q(this, 0L, 1, null);
                return;
            }
            Q(this, 0L, 1, null);
        }
    }

    public final void E0(long j4) {
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15322d;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            j6 = 1152921504606846975L & j5;
            if (j6 >= j4) {
                return;
            }
        } while (!f15322d.compareAndSet(this, j5, c.w(j6, (int) (j5 >> 60))));
    }

    public final j F(long j4, j jVar, long j5) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15328j;
        i3.o oVar = (i3.o) c.y();
        loop0: while (true) {
            objC = AbstractC1950d.c(jVar, j4, oVar);
            if (!D.c(objC)) {
                C cB = D.b(objC);
                while (true) {
                    C c4 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c4.f15955c >= cB.f15955c) {
                        break loop0;
                    }
                    if (!cB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, c4, cB)) {
                        if (c4.m()) {
                            c4.k();
                        }
                    } else if (cB.m()) {
                        cB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (D.c(objC)) {
            C();
            d0(j4, jVar);
            Q(this, 0L, 1, null);
            return null;
        }
        j jVar2 = (j) D.b(objC);
        long j6 = jVar2.f15955c;
        if (j6 <= j4) {
            return jVar2;
        }
        int i4 = c.f15341b;
        if (f15324f.compareAndSet(this, j5 + 1, j6 * ((long) i4))) {
            P((jVar2.f15955c * ((long) i4)) - j5);
        } else {
            Q(this, 0L, 1, null);
        }
        return null;
    }

    public final void F0(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        b bVar = this;
        if (bVar.Y()) {
            return;
        }
        while (bVar.I() <= j4) {
            bVar = this;
        }
        int i4 = c.f15342c;
        for (int i5 = 0; i5 < i4; i5++) {
            long jI = bVar.I();
            if (jI == (4611686018427387903L & f15325g.get(bVar)) && jI == bVar.I()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f15325g;
        while (true) {
            long j5 = atomicLongFieldUpdater2.get(bVar);
            if (atomicLongFieldUpdater2.compareAndSet(bVar, j5, c.v(j5 & 4611686018427387903L, true))) {
                break;
            } else {
                bVar = this;
            }
        }
        while (true) {
            long jI2 = bVar.I();
            atomicLongFieldUpdater = f15325g;
            long j6 = atomicLongFieldUpdater.get(bVar);
            long j7 = j6 & 4611686018427387903L;
            boolean z4 = (4611686018427387904L & j6) != 0;
            if (jI2 == j7 && jI2 == bVar.I()) {
                break;
            }
            if (z4) {
                bVar = this;
            } else {
                bVar = this;
                atomicLongFieldUpdater.compareAndSet(bVar, j6, c.v(j7, true));
            }
        }
        while (true) {
            long j8 = atomicLongFieldUpdater.get(bVar);
            if (atomicLongFieldUpdater.compareAndSet(bVar, j8, c.v(j8 & 4611686018427387903L, false))) {
                return;
            } else {
                bVar = this;
            }
        }
    }

    public final j G(long j4, j jVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15327i;
        i3.o oVar = (i3.o) c.y();
        loop0: while (true) {
            objC = AbstractC1950d.c(jVar, j4, oVar);
            if (!D.c(objC)) {
                C cB = D.b(objC);
                while (true) {
                    C c4 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c4.f15955c >= cB.f15955c) {
                        break loop0;
                    }
                    if (!cB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, c4, cB)) {
                        if (c4.m()) {
                            c4.k();
                        }
                    } else if (cB.m()) {
                        cB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (D.c(objC)) {
            C();
            if (jVar.f15955c * ((long) c.f15341b) < N()) {
                jVar.b();
            }
            return null;
        }
        j jVar2 = (j) D.b(objC);
        if (!Y() && j4 <= I() / ((long) c.f15341b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15328j;
            while (true) {
                C c5 = (C) atomicReferenceFieldUpdater2.get(this);
                if (c5.f15955c >= jVar2.f15955c || !jVar2.q()) {
                    break;
                }
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater2, this, c5, jVar2)) {
                    if (c5.m()) {
                        c5.k();
                    }
                } else if (jVar2.m()) {
                    jVar2.k();
                }
            }
        }
        long j5 = jVar2.f15955c;
        if (j5 <= j4) {
            return jVar2;
        }
        int i4 = c.f15341b;
        D0(j5 * ((long) i4));
        if (jVar2.f15955c * ((long) i4) < N()) {
            jVar2.b();
        }
        return null;
    }

    public final j H(long j4, j jVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15326h;
        i3.o oVar = (i3.o) c.y();
        loop0: while (true) {
            objC = AbstractC1950d.c(jVar, j4, oVar);
            if (!D.c(objC)) {
                C cB = D.b(objC);
                while (true) {
                    C c4 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c4.f15955c >= cB.f15955c) {
                        break loop0;
                    }
                    if (!cB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, c4, cB)) {
                        if (c4.m()) {
                            c4.k();
                        }
                    } else if (cB.m()) {
                        cB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (D.c(objC)) {
            C();
            if (jVar.f15955c * ((long) c.f15341b) < L()) {
                jVar.b();
            }
            return null;
        }
        j jVar2 = (j) D.b(objC);
        long j5 = jVar2.f15955c;
        if (j5 <= j4) {
            return jVar2;
        }
        int i4 = c.f15341b;
        E0(j5 * ((long) i4));
        if (jVar2.f15955c * ((long) i4) < L()) {
            jVar2.b();
        }
        return null;
    }

    public final long I() {
        return f15324f.get(this);
    }

    public final Throwable J() {
        return (Throwable) f15329k.get(this);
    }

    public final Throwable K() {
        Throwable thJ = J();
        return thJ == null ? new n("Channel was closed") : thJ;
    }

    public final long L() {
        return f15323e.get(this);
    }

    public final Throwable M() {
        Throwable thJ = J();
        return thJ == null ? new o("Channel was closed") : thJ;
    }

    public final long N() {
        return f15322d.get(this) & 1152921504606846975L;
    }

    public final boolean O() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15327i;
            j jVarG = (j) atomicReferenceFieldUpdater.get(this);
            long jL = L();
            if (N() <= jL) {
                return false;
            }
            int i4 = c.f15341b;
            long j4 = jL / ((long) i4);
            if (jVarG.f15955c == j4 || (jVarG = G(j4, jVarG)) != null) {
                jVarG.b();
                if (S(jVarG, (int) (jL % ((long) i4)), jL)) {
                    return true;
                }
                f15323e.compareAndSet(this, jL, jL + 1);
            } else if (((j) atomicReferenceFieldUpdater.get(this)).f15955c < j4) {
                return false;
            }
        }
    }

    public final void P(long j4) {
        if ((f15325g.addAndGet(this, j4) & 4611686018427387904L) != 0) {
            while ((f15325g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void R() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15330l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, obj == null ? c.f15356q : c.f15357r));
        if (obj == null) {
            return;
        }
        ((i3.k) obj).invoke(J());
    }

    public final boolean S(j jVar, int i4, long j4) {
        Object objW;
        do {
            objW = jVar.w(i4);
            if (objW != null && objW != c.f15344e) {
                if (objW == c.f15343d) {
                    return true;
                }
                if (objW == c.f15349j || objW == c.z() || objW == c.f15348i || objW == c.f15347h) {
                    return false;
                }
                if (objW == c.f15346g) {
                    return true;
                }
                return objW != c.f15345f && j4 == L();
            }
        } while (!jVar.r(i4, objW, c.f15347h));
        E();
        return false;
    }

    public final boolean T(long j4, boolean z4) throws IllegalAccessException, InvocationTargetException {
        int i4 = (int) (j4 >> 60);
        if (i4 == 0 || i4 == 1) {
            return false;
        }
        if (i4 == 2) {
            B(j4 & 1152921504606846975L);
            return (z4 && O()) ? false : true;
        }
        if (i4 == 3) {
            A(j4 & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i4).toString());
    }

    public boolean U() {
        return V(f15322d.get(this));
    }

    public final boolean V(long j4) {
        return T(j4, true);
    }

    public final boolean W(long j4) {
        return T(j4, false);
    }

    public boolean X() {
        return false;
    }

    public final boolean Y() {
        long jI = I();
        return jI == 0 || jI == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (v3.j) r8.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long Z(v3.j r8) {
        /*
            r7 = this;
        L0:
            int r0 = v3.c.f15341b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f15955c
            int r5 = v3.c.f15341b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.L()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.w(r0)
            if (r1 == 0) goto L2c
            y3.F r2 = v3.c.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            y3.F r2 = v3.c.f15343d
            if (r1 != r2) goto L39
            return r3
        L2c:
            y3.F r2 = v3.c.z()
            boolean r1 = r8.r(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.p()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            y3.e r8 = r8.g()
            v3.j r8 = (v3.j) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.Z(v3.j):long");
    }

    @Override // v3.u
    public Object a(Object obj, Z2.e eVar) {
        return s0(this, obj, eVar);
    }

    public final void a0() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15322d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if (((int) (j4 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, c.w(1152921504606846975L & j4, 1)));
    }

    @Override // v3.u
    public void b(i3.k kVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15330l;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, kVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != c.f15356q) {
                if (obj == c.f15357r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f15330l, this, c.f15356q, c.f15357r));
        kVar.invoke(J());
    }

    public final void b0() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15322d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, c.w(1152921504606846975L & j4, 3)));
    }

    @Override // v3.t
    public Object c(Z2.e eVar) {
        return m0(this, eVar);
    }

    public final void c0() {
        long j4;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15322d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            int i4 = (int) (j4 >> 60);
            if (i4 == 0) {
                jW = c.w(1152921504606846975L & j4, 2);
            } else if (i4 != 1) {
                return;
            } else {
                jW = c.w(1152921504606846975L & j4, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, jW));
    }

    @Override // v3.t
    public final void cancel(CancellationException cancellationException) {
        w(cancellationException);
    }

    @Override // v3.t
    public Object d() {
        j jVarG;
        long j4 = f15323e.get(this);
        long j5 = f15322d.get(this);
        if (V(j5)) {
            return h.f15364b.a(J());
        }
        if (j4 >= (j5 & 1152921504606846975L)) {
            return h.f15364b.b();
        }
        Object obj = c.f15350k;
        j jVar = (j) f15327i.get(this);
        while (!U()) {
            long andIncrement = f15323e.getAndIncrement(this);
            int i4 = c.f15341b;
            long j6 = andIncrement / ((long) i4);
            int i5 = (int) (andIncrement % ((long) i4));
            if (jVar.f15955c != j6) {
                jVarG = G(j6, jVar);
                if (jVarG == null) {
                    continue;
                }
            } else {
                jVarG = jVar;
            }
            Object objZ0 = z0(jVarG, i5, andIncrement, obj);
            if (objZ0 == c.f15352m) {
                b1 b1Var = obj instanceof b1 ? (b1) obj : null;
                if (b1Var != null) {
                    k0(b1Var, jVarG, i5);
                }
                F0(andIncrement);
                jVarG.p();
                return h.f15364b.b();
            }
            if (objZ0 != c.f15354o) {
                if (objZ0 == c.f15353n) {
                    throw new IllegalStateException("unexpected");
                }
                jVarG.b();
                return h.f15364b.c(objZ0);
            }
            if (andIncrement < N()) {
                jVarG.b();
            }
            jVar = jVarG;
        }
        return h.f15364b.a(J());
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(long r5, v3.j r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f15955c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            y3.e r0 = r7.e()
            v3.j r0 = (v3.j) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.h()
            if (r5 == 0) goto L22
            y3.e r5 = r7.e()
            v3.j r5 = (v3.j) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = v3.b.f15328j
        L24:
            java.lang.Object r6 = r5.get(r4)
            y3.C r6 = (y3.C) r6
            long r0 = r6.f15955c
            long r2 = r7.f15955c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            return
        L33:
            boolean r0 = r7.q()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = androidx.concurrent.futures.b.a(r5, r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.m()
            if (r5 == 0) goto L49
            r6.k()
        L49:
            return
        L4a:
            boolean r6 = r7.m()
            if (r6 == 0) goto L24
            r7.k()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.d0(long, v3.j):void");
    }

    public final void f0(InterfaceC1830o interfaceC1830o) {
        p.a aVar = W2.p.f5487b;
        interfaceC1830o.resumeWith(W2.p.b(W2.q.a(K())));
    }

    public final Object g0(Object obj, Z2.e eVar) throws IllegalAccessException, InvocationTargetException {
        O oD;
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        i3.k kVar = this.f15332b;
        if (kVar == null || (oD = x.d(kVar, obj, null, 2, null)) == null) {
            Throwable thM = M();
            p.a aVar = W2.p.f5487b;
            c1832p.resumeWith(W2.p.b(W2.q.a(thM)));
        } else {
            AbstractC0737e.a(oD, M());
            p.a aVar2 = W2.p.f5487b;
            c1832p.resumeWith(W2.p.b(W2.q.a(oD)));
        }
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : W2.E.f5463a;
    }

    public final void h0(Object obj, InterfaceC1830o interfaceC1830o) throws IllegalAccessException, InvocationTargetException {
        i3.k kVar = this.f15332b;
        if (kVar != null) {
            x.b(kVar, obj, interfaceC1830o.getContext());
        }
        Throwable thM = M();
        p.a aVar = W2.p.f5487b;
        interfaceC1830o.resumeWith(W2.p.b(W2.q.a(thM)));
    }

    @Override // v3.t
    public f iterator() {
        return new a();
    }

    @Override // v3.u
    public boolean k(Throwable th) {
        return z(th, false);
    }

    public final void k0(b1 b1Var, j jVar, int i4) {
        j0();
        b1Var.b(jVar, i4);
    }

    public final void l0(b1 b1Var, j jVar, int i4) {
        b1Var.b(jVar, i4 + c.f15341b);
    }

    @Override // v3.u
    public Object m(Object obj) {
        Object obj2;
        int i4;
        j jVar;
        b bVar;
        if (u0(f15322d.get(this))) {
            return h.f15364b.b();
        }
        Object obj3 = c.f15349j;
        j jVar2 = (j) f15326h.get(this);
        while (true) {
            long andIncrement = f15322d.getAndIncrement(this);
            long j4 = andIncrement & 1152921504606846975L;
            boolean zW = W(andIncrement);
            int i5 = c.f15341b;
            long j5 = j4 / ((long) i5);
            int i6 = (int) (j4 % ((long) i5));
            if (jVar2.f15955c != j5) {
                j jVarH = H(j5, jVar2);
                if (jVarH != null) {
                    i4 = i6;
                    jVar = jVarH;
                    bVar = this;
                    obj2 = obj;
                } else if (zW) {
                    return h.f15364b.a(M());
                }
            } else {
                obj2 = obj;
                i4 = i6;
                jVar = jVar2;
                bVar = this;
            }
            int iB0 = bVar.B0(jVar, i4, obj2, j4, obj3, zW);
            jVar2 = jVar;
            if (iB0 == 0) {
                jVar2.b();
                return h.f15364b.c(W2.E.f5463a);
            }
            if (iB0 == 1) {
                return h.f15364b.c(W2.E.f5463a);
            }
            if (iB0 == 2) {
                if (zW) {
                    jVar2.p();
                    return h.f15364b.a(M());
                }
                b1 b1Var = obj3 instanceof b1 ? (b1) obj3 : null;
                if (b1Var != null) {
                    l0(b1Var, jVar2, i4);
                }
                jVar2.p();
                return h.f15364b.b();
            }
            if (iB0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iB0 == 4) {
                if (j4 < L()) {
                    jVar2.b();
                }
                return h.f15364b.a(M());
            }
            if (iB0 == 5) {
                jVar2.b();
            }
            obj = obj2;
        }
    }

    @Override // v3.u
    public boolean n() {
        return W(f15322d.get(this));
    }

    public final Object n0(j jVar, int i4, long j4, Z2.e eVar) {
        j jVar2;
        C1832p c1832pB = t3.r.b(AbstractC0786b.c(eVar));
        try {
            Object objZ0 = z0(jVar, i4, j4, c1832pB);
            if (objZ0 == c.f15352m) {
                k0(c1832pB, jVar, i4);
            } else {
                i3.k kVarA = null;
                kVarA = null;
                if (objZ0 == c.f15354o) {
                    if (j4 < N()) {
                        jVar.b();
                    }
                    j jVar3 = (j) f15327i.get(this);
                    while (true) {
                        if (U()) {
                            f0(c1832pB);
                            break;
                        }
                        long andIncrement = f15323e.getAndIncrement(this);
                        int i5 = c.f15341b;
                        long j5 = andIncrement / ((long) i5);
                        int i6 = (int) (andIncrement % ((long) i5));
                        if (jVar3.f15955c != j5) {
                            j jVarG = G(j5, jVar3);
                            if (jVarG != null) {
                                jVar2 = jVarG;
                            }
                        } else {
                            jVar2 = jVar3;
                        }
                        objZ0 = z0(jVar2, i6, andIncrement, c1832pB);
                        j jVar4 = jVar2;
                        if (objZ0 == c.f15352m) {
                            C1832p c1832p = c1832pB != null ? c1832pB : null;
                            if (c1832p != null) {
                                k0(c1832p, jVar4, i6);
                            }
                        } else if (objZ0 == c.f15354o) {
                            if (andIncrement < N()) {
                                jVar4.b();
                            }
                            jVar3 = jVar4;
                        } else {
                            if (objZ0 == c.f15353n) {
                                throw new IllegalStateException("unexpected");
                            }
                            jVar4.b();
                            i3.k kVar = this.f15332b;
                            if (kVar != null) {
                                kVarA = x.a(kVar, objZ0, c1832pB.getContext());
                            }
                        }
                    }
                } else {
                    jVar.b();
                    i3.k kVar2 = this.f15332b;
                    if (kVar2 != null) {
                        kVarA = x.a(kVar2, objZ0, c1832pB.getContext());
                    }
                }
                c1832pB.h(objZ0, kVarA);
            }
            Object objX = c1832pB.x();
            if (objX == AbstractC0787c.e()) {
                b3.h.c(eVar);
            }
            return objX;
        } catch (Throwable th) {
            c1832pB.I();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (v3.j) r12.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(v3.j r12) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.o0(v3.j):void");
    }

    public final void p0(b1 b1Var) {
        r0(b1Var, true);
    }

    public final void q0(b1 b1Var) {
        r0(b1Var, false);
    }

    public final void r0(b1 b1Var, boolean z4) {
        if (b1Var instanceof InterfaceC1830o) {
            Z2.e eVar = (Z2.e) b1Var;
            p.a aVar = W2.p.f5487b;
            eVar.resumeWith(W2.p.b(W2.q.a(z4 ? K() : M())));
        } else {
            if (b1Var instanceof a) {
                ((a) b1Var).j();
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + b1Var).toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t0(v3.j r17, int r18, java.lang.Object r19, long r20, Z2.e r22) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.t0(v3.j, int, java.lang.Object, long, Z2.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01bf, code lost:
    
        r16 = r7;
        r3 = (v3.j) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c8, code lost:
    
        if (r3 != null) goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.toString():java.lang.String");
    }

    public final boolean u0(long j4) {
        if (W(j4)) {
            return false;
        }
        return !v(j4 & 1152921504606846975L);
    }

    public final boolean v(long j4) {
        return j4 < I() || j4 < L() + ((long) this.f15331a);
    }

    public final boolean v0(Object obj, Object obj2) {
        if (obj instanceof a) {
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        }
        if (obj instanceof InterfaceC1830o) {
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC1830o interfaceC1830o = (InterfaceC1830o) obj;
            i3.k kVar = this.f15332b;
            return c.B(interfaceC1830o, obj2, kVar != null ? x.a(kVar, obj2, interfaceC1830o.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public boolean w(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return z(th, true);
    }

    public final boolean w0(Object obj, j jVar, int i4) {
        if (obj instanceof InterfaceC1830o) {
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return c.C((InterfaceC1830o) obj, W2.E.f5463a, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final void x(j jVar, long j4) {
        Object objB = AbstractC1958l.b(null, 1, null);
        loop0: while (jVar != null) {
            for (int i4 = c.f15341b - 1; -1 < i4; i4--) {
                if ((jVar.f15955c * ((long) c.f15341b)) + ((long) i4) < j4) {
                    break loop0;
                }
                while (true) {
                    Object objW = jVar.w(i4);
                    if (objW != null && objW != c.f15344e) {
                        if (!(objW instanceof v)) {
                            if (!(objW instanceof b1)) {
                                break;
                            }
                            if (jVar.r(i4, objW, c.z())) {
                                objB = AbstractC1958l.c(objB, objW);
                                jVar.x(i4, true);
                                break;
                            }
                        } else {
                            if (jVar.r(i4, objW, c.z())) {
                                objB = AbstractC1958l.c(objB, ((v) objW).f15381a);
                                jVar.x(i4, true);
                                break;
                            }
                        }
                    } else {
                        if (jVar.r(i4, objW, c.z())) {
                            jVar.p();
                            break;
                        }
                    }
                }
            }
            jVar = (j) jVar.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                p0((b1) objB);
                return;
            }
            kotlin.jvm.internal.r.d(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                p0((b1) arrayList.get(size));
            }
        }
    }

    public final boolean x0(j jVar, int i4, long j4) {
        Object objW = jVar.w(i4);
        if (!(objW instanceof b1) || j4 < f15323e.get(this) || !jVar.r(i4, objW, c.f15346g)) {
            return y0(jVar, i4, j4);
        }
        if (w0(objW, jVar, i4)) {
            jVar.A(i4, c.f15343d);
            return true;
        }
        jVar.A(i4, c.f15349j);
        jVar.x(i4, false);
        return false;
    }

    public final j y() {
        Object obj = f15328j.get(this);
        j jVar = (j) f15326h.get(this);
        if (jVar.f15955c > ((j) obj).f15955c) {
            obj = jVar;
        }
        j jVar2 = (j) f15327i.get(this);
        if (jVar2.f15955c > ((j) obj).f15955c) {
            obj = jVar2;
        }
        return (j) AbstractC1950d.b((AbstractC1951e) obj);
    }

    public final boolean y0(j jVar, int i4, long j4) {
        while (true) {
            Object objW = jVar.w(i4);
            if (objW instanceof b1) {
                if (j4 < f15323e.get(this)) {
                    if (jVar.r(i4, objW, new v((b1) objW))) {
                        return true;
                    }
                } else if (jVar.r(i4, objW, c.f15346g)) {
                    if (w0(objW, jVar, i4)) {
                        jVar.A(i4, c.f15343d);
                        return true;
                    }
                    jVar.A(i4, c.f15349j);
                    jVar.x(i4, false);
                    return false;
                }
            } else {
                if (objW == c.f15349j) {
                    return false;
                }
                if (objW == null) {
                    if (jVar.r(i4, objW, c.f15344e)) {
                        return true;
                    }
                } else {
                    if (objW == c.f15343d || objW == c.f15347h || objW == c.f15348i || objW == c.f15350k || objW == c.z()) {
                        return true;
                    }
                    if (objW != c.f15345f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objW).toString());
                    }
                }
            }
        }
    }

    public boolean z(Throwable th, boolean z4) {
        if (z4) {
            a0();
        }
        boolean zA = androidx.concurrent.futures.b.a(f15329k, this, c.f15358s, th);
        if (z4) {
            b0();
        } else {
            c0();
        }
        C();
        e0();
        if (zA) {
            R();
        }
        return zA;
    }

    public final Object z0(j jVar, int i4, long j4, Object obj) {
        Object objW = jVar.w(i4);
        if (objW == null) {
            if (j4 >= (f15322d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return c.f15353n;
                }
                if (jVar.r(i4, objW, obj)) {
                    E();
                    return c.f15352m;
                }
            }
        } else if (objW == c.f15343d && jVar.r(i4, objW, c.f15348i)) {
            E();
            return jVar.y(i4);
        }
        return A0(jVar, i4, j4, obj);
    }

    public void e0() {
    }

    public void i0() {
    }

    public void j0() {
    }
}
