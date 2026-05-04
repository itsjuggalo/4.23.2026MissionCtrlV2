package pg;

import cd.h0;
import cd.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.c3;
import sg.a0;
import sg.b0;
import sg.c0;
import sg.p0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18631d = AtomicLongFieldUpdater.newUpdater(e.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18632e = AtomicLongFieldUpdater.newUpdater(e.class, "receivers$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18633f = AtomicLongFieldUpdater.newUpdater(e.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18634g = AtomicLongFieldUpdater.newUpdater(e.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18635h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18636i = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18637j = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18638k = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18639l = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f18641b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.p f18642c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements i, c3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f18643a = f.f18661p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ng.p f18644b;

        public a() {
        }

        @Override // pg.i
        public Object a(gd.e eVar) throws Throwable {
            m mVarP;
            boolean zG = true;
            if (this.f18643a == f.f18661p || this.f18643a == f.z()) {
                e eVar2 = e.this;
                m mVar = (m) e.Y().get(eVar2);
                while (!eVar2.m0()) {
                    long andIncrement = e.Z().getAndIncrement(eVar2);
                    int i10 = f.f18647b;
                    long j10 = andIncrement / ((long) i10);
                    int i11 = (int) (andIncrement % ((long) i10));
                    if (mVar.f20378c != j10) {
                        mVarP = eVar2.P(j10, mVar);
                        if (mVarP == null) {
                            continue;
                        }
                    } else {
                        mVarP = mVar;
                    }
                    Object objV0 = eVar2.V0(mVarP, i11, andIncrement, null);
                    if (objV0 == f.f18658m) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objV0 == f.f18660o) {
                        if (andIncrement < eVar2.e0()) {
                            mVarP.c();
                        }
                        mVar = mVarP;
                    } else {
                        if (objV0 == f.f18659n) {
                            return f(mVarP, i11, andIncrement, eVar);
                        }
                        mVarP.c();
                        this.f18643a = objV0;
                    }
                }
                zG = g();
            }
            return id.b.a(zG);
        }

        @Override // ng.c3
        public void b(a0 a0Var, int i10) {
            ng.p pVar = this.f18644b;
            if (pVar != null) {
                pVar.b(a0Var, i10);
            }
        }

        public final Object f(m mVar, int i10, long j10, gd.e eVar) throws Throwable {
            Boolean boolA;
            pd.k kVar;
            m mVarP;
            e eVar2 = e.this;
            ng.p pVarB = ng.r.b(hd.b.c(eVar));
            try {
                this.f18644b = pVarB;
                try {
                    Object objV0 = eVar2.V0(mVar, i10, j10, this);
                    if (objV0 == f.f18658m) {
                        eVar2.F0(this, mVar, i10);
                    } else {
                        pd.p pVarB2 = null;
                        if (objV0 == f.f18660o) {
                            if (j10 < eVar2.e0()) {
                                mVar.c();
                            }
                            m mVar2 = (m) e.Y().get(eVar2);
                            while (true) {
                                if (eVar2.m0()) {
                                    h();
                                    break;
                                }
                                long andIncrement = e.Z().getAndIncrement(eVar2);
                                int i11 = f.f18647b;
                                long j11 = andIncrement / ((long) i11);
                                int i12 = (int) (andIncrement % ((long) i11));
                                if (mVar2.f20378c != j11) {
                                    mVarP = eVar2.P(j11, mVar2);
                                    if (mVarP == null) {
                                    }
                                } else {
                                    mVarP = mVar2;
                                }
                                objV0 = eVar2.V0(mVarP, i12, andIncrement, this);
                                if (objV0 == f.f18658m) {
                                    eVar2.F0(this, mVarP, i12);
                                    break;
                                }
                                if (objV0 == f.f18660o) {
                                    if (andIncrement < eVar2.e0()) {
                                        mVarP.c();
                                    }
                                    mVar2 = mVarP;
                                } else {
                                    if (objV0 == f.f18659n) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    mVarP.c();
                                    this.f18643a = objV0;
                                    this.f18644b = null;
                                    boolA = id.b.a(true);
                                    kVar = eVar2.f18641b;
                                    if (kVar != null) {
                                    }
                                }
                            }
                            pVarB.c(boolA, pVarB2);
                        } else {
                            mVar.c();
                            this.f18643a = objV0;
                            this.f18644b = null;
                            boolA = id.b.a(true);
                            kVar = eVar2.f18641b;
                            if (kVar != null) {
                                pVarB2 = eVar2.B(kVar, objV0);
                            }
                            pVarB.c(boolA, pVarB2);
                        }
                    }
                    Object objY = pVarB.y();
                    if (objY == hd.c.f()) {
                        id.h.c(eVar);
                    }
                    return objY;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    pVarB.M();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final boolean g() throws Throwable {
            this.f18643a = f.z();
            Throwable thU = e.this.U();
            if (thU == null) {
                return false;
            }
            throw c0.a(thU);
        }

        public final void h() {
            ng.p pVar = this.f18644b;
            kotlin.jvm.internal.t.c(pVar);
            this.f18644b = null;
            this.f18643a = f.z();
            Throwable thU = e.this.U();
            if (thU == null) {
                r.a aVar = cd.r.f3870b;
                pVar.resumeWith(cd.r.b(Boolean.FALSE));
            } else {
                r.a aVar2 = cd.r.f3870b;
                pVar.resumeWith(cd.r.b(cd.s.a(thU)));
            }
        }

        public final boolean i(Object obj) {
            ng.p pVar = this.f18644b;
            kotlin.jvm.internal.t.c(pVar);
            this.f18644b = null;
            this.f18643a = obj;
            Boolean bool = Boolean.TRUE;
            e eVar = e.this;
            pd.k kVar = eVar.f18641b;
            return f.B(pVar, bool, kVar != null ? eVar.B(kVar, obj) : null);
        }

        public final void j() {
            ng.p pVar = this.f18644b;
            kotlin.jvm.internal.t.c(pVar);
            this.f18644b = null;
            this.f18643a = f.z();
            Throwable thU = e.this.U();
            if (thU == null) {
                r.a aVar = cd.r.f3870b;
                pVar.resumeWith(cd.r.b(Boolean.FALSE));
            } else {
                r.a aVar2 = cd.r.f3870b;
                pVar.resumeWith(cd.r.b(cd.s.a(thU)));
            }
        }

        @Override // pg.i
        public Object next() throws Throwable {
            Object obj = this.f18643a;
            if (obj == f.f18661p) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.f18643a = f.f18661p;
            if (obj != f.z()) {
                return obj;
            }
            throw c0.a(e.this.X());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.p {
        public b(Object obj) {
            super(3, obj, e.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // pd.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws IllegalAccessException, InvocationTargetException {
            o((Throwable) obj, obj2, (gd.i) obj3);
            return h0.f3852a;
        }

        public final void o(Throwable th, Object obj, gd.i iVar) throws IllegalAccessException, InvocationTargetException {
            ((e) this.receiver).w0(th, obj, iVar);
        }
    }

    public e(int i10, pd.k kVar) {
        this.f18640a = i10;
        this.f18641b = kVar;
        if (i10 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = f.A(i10);
        this.completedExpandBuffersAndPauseFlag$volatile = S();
        m mVar = new m(0L, null, this, 3);
        this.sendSegment$volatile = mVar;
        this.receiveSegment$volatile = mVar;
        if (q0()) {
            mVar = f.f18646a;
            kotlin.jvm.internal.t.d(mVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = mVar;
        this.f18642c = kVar != null ? new pd.p() { // from class: pg.b
            @Override // pd.p
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                e eVar = this.f18626a;
                android.support.v4.media.session.b.a(obj);
                return e.D0(eVar, null, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = f.f18664s;
    }

    public static final h0 D(pd.k kVar, Object obj, Throwable th, Object obj2, gd.i iVar) throws IllegalAccessException, InvocationTargetException {
        sg.w.a(kVar, obj, iVar);
        return h0.f3852a;
    }

    public static final pd.p D0(final e eVar, final vg.e eVar2, Object obj, final Object obj2) {
        return new pd.p(obj2, eVar, eVar2) { // from class: pg.d

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f18629a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f18630b;

            @Override // pd.p
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return e.E0(this.f18629a, this.f18630b, null, (Throwable) obj3, obj4, (gd.i) obj5);
            }
        };
    }

    public static final h0 E0(Object obj, e eVar, vg.e eVar2, Throwable th, Object obj2, gd.i iVar) throws IllegalAccessException, InvocationTargetException {
        if (obj != f.z()) {
            sg.w.a(eVar.f18641b, obj, eVar2.getContext());
        }
        return h0.f3852a;
    }

    public static /* synthetic */ Object H0(e eVar, gd.e eVar2) throws Throwable {
        m mVar;
        m mVar2 = (m) Y().get(eVar);
        while (!eVar.m0()) {
            long andIncrement = Z().getAndIncrement(eVar);
            int i10 = f.f18647b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (mVar2.f20378c != j10) {
                m mVarP = eVar.P(j10, mVar2);
                if (mVarP == null) {
                    continue;
                } else {
                    mVar = mVarP;
                }
            } else {
                mVar = mVar2;
            }
            e eVar3 = eVar;
            Object objV0 = eVar3.V0(mVar, i11, andIncrement, null);
            if (objV0 == f.f18658m) {
                throw new IllegalStateException("unexpected");
            }
            if (objV0 != f.f18660o) {
                if (objV0 == f.f18659n) {
                    return eVar3.I0(mVar, i11, andIncrement, eVar2);
                }
                mVar.c();
                return objV0;
            }
            if (andIncrement < eVar3.e0()) {
                mVar.c();
            }
            eVar = eVar3;
            mVar2 = mVar;
        }
        throw c0.a(eVar.X());
    }

    public static /* synthetic */ Object N0(e eVar, Object obj, gd.e eVar2) throws IllegalAccessException, InvocationTargetException {
        m mVar;
        m mVar2 = (m) c0().get(eVar);
        while (true) {
            long andIncrement = d0().getAndIncrement(eVar);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zO0 = eVar.o0(andIncrement);
            int i10 = f.f18647b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (mVar2.f20378c != j11) {
                m mVarQ = eVar.Q(j11, mVar2);
                if (mVarQ != null) {
                    mVar = mVarQ;
                } else if (zO0) {
                    Object objZ0 = eVar.z0(obj, eVar2);
                    if (objZ0 == hd.c.f()) {
                        return objZ0;
                    }
                }
            } else {
                mVar = mVar2;
            }
            e eVar3 = eVar;
            Object obj2 = obj;
            int iX0 = eVar3.X0(mVar, i11, obj2, j10, null, zO0);
            if (iX0 == 0) {
                mVar.c();
                break;
            }
            if (iX0 == 1) {
                break;
            }
            if (iX0 != 2) {
                if (iX0 == 3) {
                    Object objO0 = eVar3.O0(mVar, i11, obj2, j10, eVar2);
                    if (objO0 == hd.c.f()) {
                        return objO0;
                    }
                } else if (iX0 != 4) {
                    if (iX0 == 5) {
                        mVar.c();
                    }
                    eVar = eVar3;
                    mVar2 = mVar;
                    obj = obj2;
                } else {
                    if (j10 < eVar3.a0()) {
                        mVar.c();
                    }
                    Object objZ02 = eVar3.z0(obj2, eVar2);
                    if (objZ02 == hd.c.f()) {
                        return objZ02;
                    }
                }
            } else if (zO0) {
                mVar.t();
                Object objZ03 = eVar3.z0(obj2, eVar2);
                if (objZ03 == hd.c.f()) {
                    return objZ03;
                }
            }
        }
        return h0.f3852a;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater Y() {
        return f18636i;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater Z() {
        return f18632e;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater c0() {
        return f18635h;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater d0() {
        return f18631d;
    }

    public static /* synthetic */ void i0(e eVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        eVar.h0(j10);
    }

    public final void A0(Object obj, ng.n nVar) throws IllegalAccessException, InvocationTargetException {
        pd.k kVar = this.f18641b;
        if (kVar != null) {
            sg.w.a(kVar, obj, nVar.getContext());
        }
        Throwable thB0 = b0();
        r.a aVar = cd.r.f3870b;
        nVar.resumeWith(cd.r.b(cd.s.a(thB0)));
    }

    public final pd.p B(final pd.k kVar, final Object obj) {
        return new pd.p() { // from class: pg.c
            @Override // pd.p
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return e.D(kVar, obj, (Throwable) obj2, obj3, (gd.i) obj4);
            }
        };
    }

    public final wd.h C(pd.k kVar) {
        return new b(this);
    }

    public final boolean E(long j10) {
        return j10 < S() || j10 < a0() + ((long) this.f18640a);
    }

    public boolean F(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return I(th, true);
    }

    public final void F0(c3 c3Var, m mVar, int i10) {
        C0();
        c3Var.b(mVar, i10);
    }

    public final void G(m mVar, long j10) {
        Object objB = sg.j.b(null, 1, null);
        loop0: while (mVar != null) {
            for (int i10 = f.f18647b - 1; -1 < i10; i10--) {
                if ((mVar.f20378c * ((long) f.f18647b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object objB2 = mVar.B(i10);
                    if (objB2 != null && objB2 != f.f18650e) {
                        if (!(objB2 instanceof y)) {
                            if (!(objB2 instanceof c3)) {
                                break;
                            }
                            if (mVar.v(i10, objB2, f.z())) {
                                objB = sg.j.c(objB, objB2);
                                mVar.C(i10, true);
                                break;
                            }
                        } else {
                            if (mVar.v(i10, objB2, f.z())) {
                                objB = sg.j.c(objB, ((y) objB2).f18686a);
                                mVar.C(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (mVar.v(i10, objB2, f.z())) {
                            mVar.t();
                            break;
                        }
                    }
                }
            }
            mVar = (m) mVar.h();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                K0((c3) objB);
                return;
            }
            kotlin.jvm.internal.t.d(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                K0((c3) arrayList.get(size));
            }
        }
    }

    public final void G0(c3 c3Var, m mVar, int i10) {
        c3Var.b(mVar, i10 + f.f18647b);
    }

    public final m H() {
        Object obj = f18637j.get(this);
        m mVar = (m) f18635h.get(this);
        if (mVar.f20378c > ((m) obj).f20378c) {
            obj = mVar;
        }
        m mVar2 = (m) f18636i.get(this);
        if (mVar2.f20378c > ((m) obj).f20378c) {
            obj = mVar2;
        }
        return (m) sg.a.b((sg.b) obj);
    }

    public boolean I(Throwable th, boolean z10) {
        if (z10) {
            s0();
        }
        boolean zA = y.b.a(f18638k, this, f.f18664s, th);
        if (z10) {
            t0();
        } else {
            u0();
        }
        L();
        x0();
        if (zA) {
            j0();
        }
        return zA;
    }

    public final Object I0(m mVar, int i10, long j10, gd.e eVar) {
        m mVar2;
        ng.p pVarB = ng.r.b(hd.b.c(eVar));
        try {
            Object objV0 = V0(mVar, i10, j10, pVarB);
            if (objV0 == f.f18658m) {
                F0(pVarB, mVar, i10);
            } else {
                wd.h hVarC = null;
                hVarC = null;
                if (objV0 == f.f18660o) {
                    if (j10 < e0()) {
                        mVar.c();
                    }
                    m mVar3 = (m) Y().get(this);
                    while (true) {
                        if (m0()) {
                            y0(pVarB);
                            break;
                        }
                        long andIncrement = Z().getAndIncrement(this);
                        int i11 = f.f18647b;
                        long j11 = andIncrement / ((long) i11);
                        int i12 = (int) (andIncrement % ((long) i11));
                        if (mVar3.f20378c != j11) {
                            m mVarP = P(j11, mVar3);
                            if (mVarP != null) {
                                mVar2 = mVarP;
                            }
                        } else {
                            mVar2 = mVar3;
                        }
                        objV0 = V0(mVar2, i12, andIncrement, pVarB);
                        m mVar4 = mVar2;
                        if (objV0 == f.f18658m) {
                            ng.p pVar = pVarB != null ? pVarB : null;
                            if (pVar != null) {
                                F0(pVar, mVar4, i12);
                            }
                        } else if (objV0 == f.f18660o) {
                            if (andIncrement < e0()) {
                                mVar4.c();
                            }
                            mVar3 = mVar4;
                        } else {
                            if (objV0 == f.f18659n) {
                                throw new IllegalStateException("unexpected");
                            }
                            mVar4.c();
                            pd.k kVar = this.f18641b;
                            if (kVar != null) {
                                hVarC = C(kVar);
                            }
                        }
                    }
                } else {
                    mVar.c();
                    pd.k kVar2 = this.f18641b;
                    if (kVar2 != null) {
                        hVarC = C(kVar2);
                    }
                }
                pVarB.c(objV0, (pd.p) hVarC);
            }
            Object objY = pVarB.y();
            if (objY == hd.c.f()) {
                id.h.c(eVar);
            }
            return objY;
        } catch (Throwable th) {
            pVarB.M();
            throw th;
        }
    }

    public final void J(long j10) throws IllegalAccessException, InvocationTargetException {
        J0(K(j10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (pg.m) r12.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J0(pg.m r12) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.e.J0(pg.m):void");
    }

    public final m K(long j10) {
        m mVarH = H();
        if (p0()) {
            long jR0 = r0(mVarH);
            if (jR0 != -1) {
                M(jR0);
            }
        }
        G(mVarH, j10);
        return mVarH;
    }

    public final void K0(c3 c3Var) {
        M0(c3Var, true);
    }

    public final void L() {
        n();
    }

    public final void L0(c3 c3Var) {
        M0(c3Var, false);
    }

    public final void M(long j10) {
        m mVarP;
        p0 p0VarC;
        m mVar = (m) f18636i.get(this);
        while (true) {
            long j11 = f18632e.get(this);
            if (j10 < Math.max(((long) this.f18640a) + j11, S())) {
                return;
            }
            if (f18632e.compareAndSet(this, j11, 1 + j11)) {
                int i10 = f.f18647b;
                long j12 = j11 / ((long) i10);
                int i11 = (int) (j11 % ((long) i10));
                if (mVar.f20378c != j12) {
                    mVarP = P(j12, mVar);
                    if (mVarP == null) {
                        continue;
                    }
                } else {
                    mVarP = mVar;
                }
                Object objV0 = V0(mVarP, i11, j11, null);
                if (objV0 != f.f18660o) {
                    mVarP.c();
                    pd.k kVar = this.f18641b;
                    if (kVar != null && (p0VarC = sg.w.c(kVar, objV0, null, 2, null)) != null) {
                        throw p0VarC;
                    }
                } else if (j11 < e0()) {
                    mVarP.c();
                }
                mVar = mVarP;
            }
        }
    }

    public final void M0(c3 c3Var, boolean z10) {
        if (c3Var instanceof ng.n) {
            gd.e eVar = (gd.e) c3Var;
            r.a aVar = cd.r.f3870b;
            eVar.resumeWith(cd.r.b(cd.s.a(z10 ? X() : b0())));
        } else {
            if (c3Var instanceof a) {
                ((a) c3Var).j();
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + c3Var).toString());
        }
    }

    public final void N() {
        if (q0()) {
            return;
        }
        m mVar = (m) f18637j.get(this);
        while (true) {
            long andIncrement = f18633f.getAndIncrement(this);
            int i10 = f.f18647b;
            long j10 = andIncrement / ((long) i10);
            if (e0() <= andIncrement) {
                if (mVar.f20378c < j10 && mVar.f() != null) {
                    v0(j10, mVar);
                }
                i0(this, 0L, 1, null);
                return;
            }
            if (mVar.f20378c != j10) {
                m mVarO = O(j10, mVar, andIncrement);
                if (mVarO == null) {
                    continue;
                } else {
                    mVar = mVarO;
                }
            }
            if (T0(mVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                i0(this, 0L, 1, null);
                return;
            }
            i0(this, 0L, 1, null);
        }
    }

    public final m O(long j10, m mVar, long j11) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18637j;
        pd.o oVar = (pd.o) f.y();
        loop0: while (true) {
            objC = sg.a.c(mVar, j10, oVar);
            if (!b0.c(objC)) {
                a0 a0VarB = b0.b(objC);
                while (true) {
                    a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
                    if (a0Var.f20378c >= a0VarB.f20378c) {
                        break loop0;
                    }
                    if (!a0VarB.u()) {
                        break;
                    }
                    if (y.b.a(atomicReferenceFieldUpdater, this, a0Var, a0VarB)) {
                        if (a0Var.p()) {
                            a0Var.n();
                        }
                    } else if (a0VarB.p()) {
                        a0VarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (b0.c(objC)) {
            L();
            v0(j10, mVar);
            i0(this, 0L, 1, null);
            return null;
        }
        m mVar2 = (m) b0.b(objC);
        if (mVar2.f20378c <= j10) {
            return mVar2;
        }
        long j12 = mVar2.f20378c;
        int i10 = f.f18647b;
        if (f18633f.compareAndSet(this, j11 + 1, j12 * ((long) i10))) {
            h0((mVar2.f20378c * ((long) i10)) - j11);
        } else {
            i0(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O0(pg.m r17, int r18, java.lang.Object r19, long r20, gd.e r22) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.e.O0(pg.m, int, java.lang.Object, long, gd.e):java.lang.Object");
    }

    public final m P(long j10, m mVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18636i;
        pd.o oVar = (pd.o) f.y();
        loop0: while (true) {
            objC = sg.a.c(mVar, j10, oVar);
            if (!b0.c(objC)) {
                a0 a0VarB = b0.b(objC);
                while (true) {
                    a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
                    if (a0Var.f20378c >= a0VarB.f20378c) {
                        break loop0;
                    }
                    if (!a0VarB.u()) {
                        break;
                    }
                    if (y.b.a(atomicReferenceFieldUpdater, this, a0Var, a0VarB)) {
                        if (a0Var.p()) {
                            a0Var.n();
                        }
                    } else if (a0VarB.p()) {
                        a0VarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (b0.c(objC)) {
            L();
            if (mVar.f20378c * ((long) f.f18647b) < e0()) {
                mVar.c();
            }
            return null;
        }
        m mVar2 = (m) b0.b(objC);
        if (!q0() && j10 <= S() / ((long) f.f18647b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f18637j;
            while (true) {
                a0 a0Var2 = (a0) atomicReferenceFieldUpdater2.get(this);
                if (a0Var2.f20378c >= mVar2.f20378c || !mVar2.u()) {
                    break;
                }
                if (y.b.a(atomicReferenceFieldUpdater2, this, a0Var2, mVar2)) {
                    if (a0Var2.p()) {
                        a0Var2.n();
                    }
                } else if (mVar2.p()) {
                    mVar2.n();
                }
            }
        }
        long j11 = mVar2.f20378c;
        if (j11 <= j10) {
            return mVar2;
        }
        int i10 = f.f18647b;
        Z0(j11 * ((long) i10));
        if (mVar2.f20378c * ((long) i10) < e0()) {
            mVar2.c();
        }
        return null;
    }

    public final boolean P0(long j10) {
        if (o0(j10)) {
            return false;
        }
        return !E(j10 & 1152921504606846975L);
    }

    public final m Q(long j10, m mVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18635h;
        pd.o oVar = (pd.o) f.y();
        loop0: while (true) {
            objC = sg.a.c(mVar, j10, oVar);
            if (!b0.c(objC)) {
                a0 a0VarB = b0.b(objC);
                while (true) {
                    a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
                    if (a0Var.f20378c >= a0VarB.f20378c) {
                        break loop0;
                    }
                    if (!a0VarB.u()) {
                        break;
                    }
                    if (y.b.a(atomicReferenceFieldUpdater, this, a0Var, a0VarB)) {
                        if (a0Var.p()) {
                            a0Var.n();
                        }
                    } else if (a0VarB.p()) {
                        a0VarB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (b0.c(objC)) {
            L();
            if (mVar.f20378c * ((long) f.f18647b) < a0()) {
                mVar.c();
            }
            return null;
        }
        m mVar2 = (m) b0.b(objC);
        long j11 = mVar2.f20378c;
        if (j11 <= j10) {
            return mVar2;
        }
        int i10 = f.f18647b;
        a1(j11 * ((long) i10));
        if (mVar2.f20378c * ((long) i10) < a0()) {
            mVar2.c();
        }
        return null;
    }

    public final boolean Q0(Object obj, Object obj2) {
        if (obj instanceof a) {
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        }
        if (obj instanceof ng.n) {
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            ng.n nVar = (ng.n) obj;
            pd.k kVar = this.f18641b;
            return f.B(nVar, obj2, (pd.p) (kVar != null ? C(kVar) : null));
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean R0(Object obj, m mVar, int i10) {
        if (obj instanceof ng.n) {
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return f.C((ng.n) obj, h0.f3852a, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final long S() {
        return f18633f.get(this);
    }

    public final Object S0(Object obj) {
        m mVarQ;
        int i10;
        e eVar;
        Object obj2 = f.f18649d;
        m mVar = (m) c0().get(this);
        while (true) {
            long andIncrement = d0().getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zO0 = o0(andIncrement);
            int i11 = f.f18647b;
            long j11 = j10 / ((long) i11);
            int i12 = (int) (j10 % ((long) i11));
            if (mVar.f20378c != j11) {
                mVarQ = Q(j11, mVar);
                if (mVarQ != null) {
                    eVar = this;
                    i10 = i12;
                } else if (zO0) {
                    return k.f18669b.a(b0());
                }
            } else {
                mVarQ = mVar;
                i10 = i12;
                eVar = this;
            }
            Object obj3 = obj;
            int iX0 = eVar.X0(mVarQ, i10, obj3, j10, obj2, zO0);
            mVar = mVarQ;
            if (iX0 == 0) {
                mVar.c();
                return k.f18669b.c(h0.f3852a);
            }
            if (iX0 == 1) {
                return k.f18669b.c(h0.f3852a);
            }
            if (iX0 == 2) {
                if (zO0) {
                    mVar.t();
                    return k.f18669b.a(b0());
                }
                c3 c3Var = obj2 instanceof c3 ? (c3) obj2 : null;
                if (c3Var != null) {
                    G0(c3Var, mVar, i10);
                }
                M((mVar.f20378c * ((long) i11)) + ((long) i10));
                return k.f18669b.c(h0.f3852a);
            }
            if (iX0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iX0 == 4) {
                if (j10 < a0()) {
                    mVar.c();
                }
                return k.f18669b.a(b0());
            }
            if (iX0 == 5) {
                mVar.c();
            }
            obj = obj3;
        }
    }

    public final boolean T0(m mVar, int i10, long j10) {
        Object objB = mVar.B(i10);
        if (!(objB instanceof c3) || j10 < f18632e.get(this) || !mVar.v(i10, objB, f.f18652g)) {
            return U0(mVar, i10, j10);
        }
        if (R0(objB, mVar, i10)) {
            mVar.F(i10, f.f18649d);
            return true;
        }
        mVar.F(i10, f.f18655j);
        mVar.C(i10, false);
        return false;
    }

    public final Throwable U() {
        return (Throwable) f18638k.get(this);
    }

    public final boolean U0(m mVar, int i10, long j10) {
        while (true) {
            Object objB = mVar.B(i10);
            if (objB instanceof c3) {
                if (j10 < f18632e.get(this)) {
                    if (mVar.v(i10, objB, new y((c3) objB))) {
                        return true;
                    }
                } else if (mVar.v(i10, objB, f.f18652g)) {
                    if (R0(objB, mVar, i10)) {
                        mVar.F(i10, f.f18649d);
                        return true;
                    }
                    mVar.F(i10, f.f18655j);
                    mVar.C(i10, false);
                    return false;
                }
            } else {
                if (objB == f.f18655j) {
                    return false;
                }
                if (objB == null) {
                    if (mVar.v(i10, objB, f.f18650e)) {
                        return true;
                    }
                } else {
                    if (objB == f.f18649d || objB == f.f18653h || objB == f.f18654i || objB == f.f18656k || objB == f.z()) {
                        return true;
                    }
                    if (objB != f.f18651f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objB).toString());
                    }
                }
            }
        }
    }

    public final Object V0(m mVar, int i10, long j10, Object obj) {
        Object objB = mVar.B(i10);
        if (objB == null) {
            if (j10 >= (f18631d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return f.f18659n;
                }
                if (mVar.v(i10, objB, obj)) {
                    N();
                    return f.f18658m;
                }
            }
        } else if (objB == f.f18649d && mVar.v(i10, objB, f.f18654i)) {
            N();
            return mVar.D(i10);
        }
        return W0(mVar, i10, j10, obj);
    }

    public final Object W0(m mVar, int i10, long j10, Object obj) {
        while (true) {
            Object objB = mVar.B(i10);
            if (objB == null || objB == f.f18650e) {
                if (j10 < (f18631d.get(this) & 1152921504606846975L)) {
                    if (mVar.v(i10, objB, f.f18653h)) {
                        N();
                        return f.f18660o;
                    }
                } else {
                    if (obj == null) {
                        return f.f18659n;
                    }
                    if (mVar.v(i10, objB, obj)) {
                        N();
                        return f.f18658m;
                    }
                }
            } else {
                if (objB != f.f18649d) {
                    if (objB != f.f18655j && objB != f.f18653h) {
                        if (objB == f.z()) {
                            N();
                            return f.f18660o;
                        }
                        if (objB != f.f18652g && mVar.v(i10, objB, f.f18651f)) {
                            boolean z10 = objB instanceof y;
                            if (z10) {
                                objB = ((y) objB).f18686a;
                            }
                            if (R0(objB, mVar, i10)) {
                                mVar.F(i10, f.f18654i);
                                N();
                                return mVar.D(i10);
                            }
                            mVar.F(i10, f.f18655j);
                            mVar.C(i10, false);
                            if (z10) {
                                N();
                            }
                            return f.f18660o;
                        }
                    }
                    return f.f18660o;
                }
                if (mVar.v(i10, objB, f.f18654i)) {
                    N();
                    return mVar.D(i10);
                }
            }
        }
    }

    public final Throwable X() {
        Throwable thU = U();
        return thU == null ? new q("Channel was closed") : thU;
    }

    public final int X0(m mVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        mVar.G(i10, obj);
        if (z10) {
            return Y0(mVar, i10, obj, j10, obj2, z10);
        }
        Object objB = mVar.B(i10);
        if (objB == null) {
            if (E(j10)) {
                if (mVar.v(i10, null, f.f18649d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (mVar.v(i10, null, obj2)) {
                    return 2;
                }
            }
        } else if (objB instanceof c3) {
            mVar.w(i10);
            if (Q0(objB, obj)) {
                mVar.F(i10, f.f18654i);
                B0();
                return 0;
            }
            if (mVar.x(i10, f.f18656k) == f.f18656k) {
                return 5;
            }
            mVar.C(i10, true);
            return 5;
        }
        return Y0(mVar, i10, obj, j10, obj2, z10);
    }

    public final int Y0(m mVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        while (true) {
            Object objB = mVar.B(i10);
            if (objB == null) {
                if (!E(j10) || z10) {
                    if (z10) {
                        if (mVar.v(i10, null, f.f18655j)) {
                            mVar.C(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (mVar.v(i10, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.v(i10, null, f.f18649d)) {
                    return 1;
                }
            } else {
                if (objB != f.f18650e) {
                    if (objB == f.f18656k) {
                        mVar.w(i10);
                        return 5;
                    }
                    if (objB == f.f18653h) {
                        mVar.w(i10);
                        return 5;
                    }
                    if (objB == f.z()) {
                        mVar.w(i10);
                        L();
                        return 4;
                    }
                    mVar.w(i10);
                    if (objB instanceof y) {
                        objB = ((y) objB).f18686a;
                    }
                    if (Q0(objB, obj)) {
                        mVar.F(i10, f.f18654i);
                        B0();
                        return 0;
                    }
                    if (mVar.x(i10, f.f18656k) != f.f18656k) {
                        mVar.C(i10, true);
                    }
                    return 5;
                }
                if (mVar.v(i10, objB, f.f18649d)) {
                    return 1;
                }
            }
        }
    }

    public final void Z0(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18632e;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
            long j12 = j10;
            if (f18632e.compareAndSet(this, j11, j12)) {
                return;
            } else {
                j10 = j12;
            }
        }
    }

    @Override // pg.w
    public Object a(gd.e eVar) {
        return H0(this, eVar);
    }

    public final long a0() {
        return f18632e.get(this);
    }

    public final void a1(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18631d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = 1152921504606846975L & j11;
            if (j12 >= j10) {
                return;
            }
        } while (!f18631d.compareAndSet(this, j11, f.w(j12, (int) (j11 >> 60))));
    }

    @Override // pg.w
    public Object b() {
        m mVarP;
        long j10 = f18632e.get(this);
        long j11 = f18631d.get(this);
        if (n0(j11)) {
            return k.f18669b.a(U());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return k.f18669b.b();
        }
        Object obj = f.f18656k;
        m mVar = (m) Y().get(this);
        while (!m0()) {
            long andIncrement = Z().getAndIncrement(this);
            int i10 = f.f18647b;
            long j12 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (mVar.f20378c != j12) {
                mVarP = P(j12, mVar);
                if (mVarP == null) {
                    continue;
                }
            } else {
                mVarP = mVar;
            }
            Object objV0 = V0(mVarP, i11, andIncrement, obj);
            if (objV0 == f.f18658m) {
                c3 c3Var = obj instanceof c3 ? (c3) obj : null;
                if (c3Var != null) {
                    F0(c3Var, mVarP, i11);
                }
                b1(andIncrement);
                mVarP.t();
                return k.f18669b.b();
            }
            if (objV0 != f.f18660o) {
                if (objV0 == f.f18659n) {
                    throw new IllegalStateException("unexpected");
                }
                mVarP.c();
                return k.f18669b.c(objV0);
            }
            if (andIncrement < e0()) {
                mVarP.c();
            }
            mVar = mVarP;
        }
        return k.f18669b.a(U());
    }

    public final Throwable b0() {
        Throwable thU = U();
        return thU == null ? new r("Channel was closed") : thU;
    }

    public final void b1(long j10) {
        e eVar = this;
        if (eVar.q0()) {
            return;
        }
        while (eVar.S() <= j10) {
            eVar = this;
        }
        int i10 = f.f18648c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jS = eVar.S();
            if (jS == (4611686018427387903L & f18634g.get(eVar)) && jS == eVar.S()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18634g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(eVar);
            if (atomicLongFieldUpdater.compareAndSet(eVar, j11, f.v(j11 & 4611686018427387903L, true))) {
                break;
            } else {
                eVar = this;
            }
        }
        while (true) {
            long jS2 = eVar.S();
            long j12 = f18634g.get(eVar);
            long j13 = j12 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j12) != 0;
            if (jS2 == j13 && jS2 == eVar.S()) {
                break;
            }
            if (z10) {
                eVar = this;
            } else {
                eVar = this;
                f18634g.compareAndSet(eVar, j12, f.v(j13, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f18634g;
        while (true) {
            long j14 = atomicLongFieldUpdater2.get(eVar);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(eVar, j14, f.v(j14 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            eVar = this;
        }
    }

    @Override // pg.w
    public final void cancel(CancellationException cancellationException) {
        F(cancellationException);
    }

    @Override // pg.x
    public boolean d(Throwable th) {
        return I(th, false);
    }

    public final long e0() {
        return f18631d.get(this) & 1152921504606846975L;
    }

    public final boolean g0() {
        while (true) {
            m mVarP = (m) f18636i.get(this);
            long jA0 = a0();
            if (e0() <= jA0) {
                return false;
            }
            int i10 = f.f18647b;
            long j10 = jA0 / ((long) i10);
            if (mVarP.f20378c == j10 || (mVarP = P(j10, mVarP)) != null) {
                mVarP.c();
                if (k0(mVarP, (int) (jA0 % ((long) i10)), jA0)) {
                    return true;
                }
                f18632e.compareAndSet(this, jA0, 1 + jA0);
            } else if (((m) f18636i.get(this)).f20378c < j10) {
                return false;
            }
        }
    }

    public final void h0(long j10) {
        if ((f18634g.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            while ((f18634g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    @Override // pg.x
    public Object i(Object obj, gd.e eVar) {
        return N0(this, obj, eVar);
    }

    @Override // pg.w
    public i iterator() {
        return new a();
    }

    public final void j0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18639l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!y.b.a(atomicReferenceFieldUpdater, this, obj, obj == null ? f.f18662q : f.f18663r));
        if (obj == null) {
            return;
        }
        ((pd.k) obj).invoke(U());
    }

    public final boolean k0(m mVar, int i10, long j10) {
        Object objB;
        do {
            objB = mVar.B(i10);
            if (objB != null && objB != f.f18650e) {
                if (objB == f.f18649d) {
                    return true;
                }
                if (objB == f.f18655j || objB == f.z() || objB == f.f18654i || objB == f.f18653h) {
                    return false;
                }
                if (objB == f.f18652g) {
                    return true;
                }
                return objB != f.f18651f && j10 == a0();
            }
        } while (!mVar.v(i10, objB, f.f18653h));
        N();
        return false;
    }

    @Override // pg.x
    public Object l(Object obj) {
        Object obj2;
        int i10;
        m mVar;
        e eVar;
        if (P0(f18631d.get(this))) {
            return k.f18669b.b();
        }
        Object obj3 = f.f18655j;
        m mVar2 = (m) c0().get(this);
        while (true) {
            long andIncrement = d0().getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zO0 = o0(andIncrement);
            int i11 = f.f18647b;
            long j11 = j10 / ((long) i11);
            int i12 = (int) (j10 % ((long) i11));
            if (mVar2.f20378c != j11) {
                m mVarQ = Q(j11, mVar2);
                if (mVarQ != null) {
                    i10 = i12;
                    mVar = mVarQ;
                    eVar = this;
                    obj2 = obj;
                } else if (zO0) {
                    return k.f18669b.a(b0());
                }
            } else {
                obj2 = obj;
                i10 = i12;
                mVar = mVar2;
                eVar = this;
            }
            int iX0 = eVar.X0(mVar, i10, obj2, j10, obj3, zO0);
            mVar2 = mVar;
            if (iX0 == 0) {
                mVar2.c();
                return k.f18669b.c(h0.f3852a);
            }
            if (iX0 == 1) {
                return k.f18669b.c(h0.f3852a);
            }
            if (iX0 == 2) {
                if (zO0) {
                    mVar2.t();
                    return k.f18669b.a(b0());
                }
                c3 c3Var = obj3 instanceof c3 ? (c3) obj3 : null;
                if (c3Var != null) {
                    G0(c3Var, mVar2, i10);
                }
                mVar2.t();
                return k.f18669b.b();
            }
            if (iX0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iX0 == 4) {
                if (j10 < a0()) {
                    mVar2.c();
                }
                return k.f18669b.a(b0());
            }
            if (iX0 == 5) {
                mVar2.c();
            }
            obj = obj2;
        }
    }

    public final boolean l0(long j10, boolean z10) throws IllegalAccessException, InvocationTargetException {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            K(j10 & 1152921504606846975L);
            return (z10 && g0()) ? false : true;
        }
        if (i10 == 3) {
            J(j10 & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i10).toString());
    }

    @Override // pg.x
    public void m(pd.k kVar) {
        if (y.b.a(f18639l, this, null, kVar)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18639l;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != f.f18662q) {
                if (obj == f.f18663r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!y.b.a(f18639l, this, f.f18662q, f.f18663r));
        kVar.invoke(U());
    }

    public boolean m0() {
        return n0(f18631d.get(this));
    }

    @Override // pg.x
    public boolean n() {
        return o0(f18631d.get(this));
    }

    public final boolean n0(long j10) {
        return l0(j10, true);
    }

    public final boolean o0(long j10) {
        return l0(j10, false);
    }

    public boolean p0() {
        return false;
    }

    public final boolean q0() {
        long jS = S();
        return jS == 0 || jS == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (pg.m) r8.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long r0(pg.m r8) {
        /*
            r7 = this;
        L0:
            int r0 = pg.f.f18647b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f20378c
            int r5 = pg.f.f18647b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.a0()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.B(r0)
            if (r1 == 0) goto L2c
            sg.d0 r2 = pg.f.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            sg.d0 r2 = pg.f.f18649d
            if (r1 != r2) goto L39
            return r3
        L2c:
            sg.d0 r2 = pg.f.z()
            boolean r1 = r8.v(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.t()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            sg.b r8 = r8.h()
            pg.m r8 = (pg.m) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.e.r0(pg.m):long");
    }

    public final void s0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18631d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, f.w(1152921504606846975L & j10, 1)));
    }

    public final void t0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18631d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, f.w(1152921504606846975L & j10, 3)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b3, code lost:
    
        r16 = r7;
        r3 = (pg.m) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bc, code lost:
    
        if (r3 != null) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.e.toString():java.lang.String");
    }

    public final void u0() {
        long j10;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f18631d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = f.w(1152921504606846975L & j10, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = f.w(1152921504606846975L & j10, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jW));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v0(long r5, pg.m r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f20378c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            sg.b r0 = r7.f()
            pg.m r0 = (pg.m) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.k()
            if (r5 == 0) goto L22
            sg.b r5 = r7.f()
            pg.m r5 = (pg.m) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = T()
        L26:
            java.lang.Object r6 = r5.get(r4)
            sg.a0 r6 = (sg.a0) r6
            long r0 = r6.f20378c
            long r2 = r7.f20378c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            return
        L35:
            boolean r0 = r7.u()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = y.b.a(r5, r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r5 = r6.p()
            if (r5 == 0) goto L4b
            r6.n()
        L4b:
            return
        L4c:
            boolean r6 = r7.p()
            if (r6 == 0) goto L26
            r7.n()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.e.v0(long, pg.m):void");
    }

    public final void w0(Throwable th, Object obj, gd.i iVar) throws IllegalAccessException, InvocationTargetException {
        pd.k kVar = this.f18641b;
        kotlin.jvm.internal.t.c(kVar);
        sg.w.a(kVar, obj, iVar);
    }

    public final void y0(ng.n nVar) {
        r.a aVar = cd.r.f3870b;
        nVar.resumeWith(cd.r.b(cd.s.a(X())));
    }

    public final Object z0(Object obj, gd.e eVar) throws IllegalAccessException, InvocationTargetException {
        p0 p0VarC;
        ng.p pVar = new ng.p(hd.b.c(eVar), 1);
        pVar.E();
        pd.k kVar = this.f18641b;
        if (kVar == null || (p0VarC = sg.w.c(kVar, obj, null, 2, null)) == null) {
            Throwable thB0 = b0();
            r.a aVar = cd.r.f3870b;
            pVar.resumeWith(cd.r.b(cd.s.a(thB0)));
        } else {
            cd.e.a(p0VarC, b0());
            r.a aVar2 = cd.r.f3870b;
            pVar.resumeWith(cd.r.b(cd.s.a(p0VarC)));
        }
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : h0.f3852a;
    }

    public void B0() {
    }

    public void C0() {
    }

    public void x0() {
    }
}
