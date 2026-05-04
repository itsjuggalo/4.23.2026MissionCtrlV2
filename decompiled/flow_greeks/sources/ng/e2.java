package ng;

import gd.i;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.y1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e2 implements y1, w, n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17094a = AtomicReferenceFieldUpdater.newUpdater(e2.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17095b = AtomicReferenceFieldUpdater.newUpdater(e2.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e2 f17096i;

        public a(gd.e eVar, e2 e2Var) {
            super(eVar, 1);
            this.f17096i = e2Var;
        }

        @Override // ng.p
        public String K() {
            return "AwaitContinuation";
        }

        @Override // ng.p
        public Throwable w(y1 y1Var) {
            Throwable thE;
            Object objZ = this.f17096i.Z();
            return (!(objZ instanceof c) || (thE = ((c) objZ).e()) == null) ? objZ instanceof c0 ? ((c0) objZ).f17078a : y1Var.getCancellationException() : thE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends d2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e2 f17097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f17098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final v f17099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f17100h;

        public b(e2 e2Var, c cVar, v vVar, Object obj) {
            this.f17097e = e2Var;
            this.f17098f = cVar;
            this.f17099g = vVar;
            this.f17100h = obj;
        }

        @Override // ng.d2
        public boolean u() {
            return false;
        }

        @Override // ng.d2
        public void v(Throwable th) {
            this.f17097e.L(this.f17098f, this.f17099g, this.f17100h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements u1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f17101b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f17102c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f17103d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j2 f17104a;

        public c(j2 j2Var, boolean z10, Throwable th) {
            this.f17104a = j2Var;
            this._isCompleting$volatile = z10 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        public final void a(Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                o(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                n(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                n(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        @Override // ng.u1
        public j2 b() {
            return this.f17104a;
        }

        public final ArrayList c() {
            return new ArrayList(4);
        }

        public final Object d() {
            return f17103d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f17102c.get(this);
        }

        public final boolean i() {
            return e() != null;
        }

        @Override // ng.u1
        public boolean isActive() {
            return e() == null;
        }

        public final boolean j() {
            return f17101b.get(this) != 0;
        }

        public final boolean k() {
            return d() == f2.f17128e;
        }

        public final List l(Throwable th) {
            ArrayList arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th != null && !kotlin.jvm.internal.t.b(th, thE)) {
                arrayListC.add(th);
            }
            n(f2.f17128e);
            return arrayListC;
        }

        public final void m(boolean z10) {
            f17101b.set(this, z10 ? 1 : 0);
        }

        public final void n(Object obj) {
            f17103d.set(this, obj);
        }

        public final void o(Throwable th) {
            f17102c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class d extends d2 {
        public d(vg.e eVar) {
        }

        @Override // ng.d2
        public boolean u() {
            return false;
        }

        @Override // ng.d2
        public void v(Throwable th) {
            Object objZ = e2.this.Z();
            if (!(objZ instanceof c0)) {
                f2.h(objZ);
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e extends d2 {
        public e(vg.e eVar) {
        }

        @Override // ng.d2
        public boolean u() {
            return false;
        }

        @Override // ng.d2
        public void v(Throwable th) {
            cd.h0 h0Var = cd.h0.f3852a;
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends id.k implements pd.o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f17107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f17108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f17110e;

        public f(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(jg.j jVar, gd.e eVar) {
            return ((f) create(jVar, eVar)).invokeSuspend(cd.h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            f fVar = e2.this.new f(eVar);
            fVar.f17110e = obj;
            return fVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        
            if (r6.e(r1, r5) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r4.e(r6, r5) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = hd.c.f()
                int r1 = r5.f17109d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r5.f17108c
                sg.o r1 = (sg.o) r1
                java.lang.Object r3 = r5.f17107b
                sg.n r3 = (sg.n) r3
                java.lang.Object r4 = r5.f17110e
                jg.j r4 = (jg.j) r4
                cd.s.b(r6)
                goto L81
            L1e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L26:
                cd.s.b(r6)
                goto L86
            L2a:
                cd.s.b(r6)
                java.lang.Object r6 = r5.f17110e
                jg.j r6 = (jg.j) r6
                ng.e2 r1 = ng.e2.this
                java.lang.Object r1 = r1.Z()
                boolean r4 = r1 instanceof ng.v
                if (r4 == 0) goto L48
                ng.v r1 = (ng.v) r1
                ng.w r1 = r1.f17188e
                r5.f17109d = r3
                java.lang.Object r6 = r6.e(r1, r5)
                if (r6 != r0) goto L86
                goto L80
            L48:
                boolean r3 = r1 instanceof ng.u1
                if (r3 == 0) goto L86
                ng.u1 r1 = (ng.u1) r1
                ng.j2 r1 = r1.b()
                if (r1 == 0) goto L86
                java.lang.Object r3 = r1.j()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
                kotlin.jvm.internal.t.d(r3, r4)
                sg.o r3 = (sg.o) r3
                r4 = r3
                r3 = r1
                r1 = r4
                r4 = r6
            L63:
                boolean r6 = kotlin.jvm.internal.t.b(r1, r3)
                if (r6 != 0) goto L86
                boolean r6 = r1 instanceof ng.v
                if (r6 == 0) goto L81
                r6 = r1
                ng.v r6 = (ng.v) r6
                ng.w r6 = r6.f17188e
                r5.f17110e = r4
                r5.f17107b = r3
                r5.f17108c = r1
                r5.f17109d = r2
                java.lang.Object r6 = r4.e(r6, r5)
                if (r6 != r0) goto L81
            L80:
                return r0
            L81:
                sg.o r1 = r1.k()
                goto L63
            L86:
                cd.h0 r6 = cd.h0.f3852a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ng.e2.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class g extends kotlin.jvm.internal.q implements pd.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f17112a = new g();

        public g() {
            super(3, e2.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // pd.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj2);
            o((e2) obj, null, obj3);
            return cd.h0.f3852a;
        }

        public final void o(e2 e2Var, vg.e eVar, Object obj) {
            e2Var.r0(eVar, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class h extends kotlin.jvm.internal.q implements pd.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f17113a = new h();

        public h() {
            super(3, e2.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // pd.p
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Object invoke(e2 e2Var, Object obj, Object obj2) {
            return e2Var.q0(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class i extends kotlin.jvm.internal.q implements pd.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f17114a = new i();

        public i() {
            super(3, e2.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // pd.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj2);
            o((e2) obj, null, obj3);
            return cd.h0.f3852a;
        }

        public final void o(e2 e2Var, vg.e eVar, Object obj) {
            e2Var.x0(eVar, obj);
        }
    }

    public e2(boolean z10) {
        this._state$volatile = z10 ? f2.f17130g : f2.f17129f;
    }

    public static /* synthetic */ CancellationException D0(e2 e2Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return e2Var.C0(th, str);
    }

    public final boolean A(Throwable th) {
        return B(th);
    }

    public final int A0(Object obj) {
        if (obj instanceof h1) {
            if (((h1) obj).isActive()) {
                return 0;
            }
            if (!y.b.a(f17094a, this, obj, f2.f17130g)) {
                return -1;
            }
            u0();
            return 1;
        }
        if (!(obj instanceof t1)) {
            return 0;
        }
        if (!y.b.a(f17094a, this, obj, ((t1) obj).b())) {
            return -1;
        }
        u0();
        return 1;
    }

    public final boolean B(Object obj) throws Throwable {
        Object objJ0 = f2.f17124a;
        if (W() && (objJ0 = F(obj)) == f2.f17125b) {
            return true;
        }
        if (objJ0 == f2.f17124a) {
            objJ0 = j0(obj);
        }
        if (objJ0 == f2.f17124a || objJ0 == f2.f17125b) {
            return true;
        }
        if (objJ0 == f2.f17127d) {
            return false;
        }
        x(objJ0);
        return true;
    }

    public final String B0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof u1 ? ((u1) obj).isActive() ? "Active" : "New" : obj instanceof c0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.i() ? "Cancelling" : cVar.j() ? "Completing" : "Active";
    }

    @Override // ng.w
    public final void C(n2 n2Var) throws Throwable {
        B(n2Var);
    }

    public final CancellationException C0(Throwable th, String str) {
        CancellationException z1Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (z1Var == null) {
            if (str == null) {
                str = I();
            }
            z1Var = new z1(str, th, this);
        }
        return z1Var;
    }

    public void D(Throwable th) throws Throwable {
        B(th);
    }

    public final String E0() {
        return m0() + '{' + B0(Z()) + '}';
    }

    public final Object F(Object obj) {
        Object objH0;
        do {
            Object objZ = Z();
            if (!(objZ instanceof u1) || ((objZ instanceof c) && ((c) objZ).j())) {
                return f2.f17124a;
            }
            objH0 = H0(objZ, new c0(M(obj), false, 2, null));
        } while (objH0 == f2.f17126c);
        return objH0;
    }

    public final boolean F0(u1 u1Var, Object obj) throws Throwable {
        if (!y.b.a(f17094a, this, u1Var, f2.g(obj))) {
            return false;
        }
        s0(null);
        t0(obj);
        K(u1Var, obj);
        return true;
    }

    public final boolean G(Throwable th) {
        if (g0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        u uVarY = Y();
        return (uVarY == null || uVarY == l2.f17156a) ? z10 : uVarY.a(th) || z10;
    }

    public final boolean G0(u1 u1Var, Throwable th) throws Throwable {
        j2 j2VarX = X(u1Var);
        if (j2VarX == null) {
            return false;
        }
        if (!y.b.a(f17094a, this, u1Var, new c(j2VarX, false, th))) {
            return false;
        }
        o0(j2VarX, th);
        return true;
    }

    public final Object H0(Object obj, Object obj2) {
        return !(obj instanceof u1) ? f2.f17124a : ((!(obj instanceof h1) && !(obj instanceof d2)) || (obj instanceof v) || (obj2 instanceof c0)) ? I0((u1) obj, obj2) : F0((u1) obj, obj2) ? obj2 : f2.f17126c;
    }

    public String I() {
        return "Job was cancelled";
    }

    public final Object I0(u1 u1Var, Object obj) throws Throwable {
        j2 j2VarX = X(u1Var);
        if (j2VarX == null) {
            return f2.f17126c;
        }
        c cVar = u1Var instanceof c ? (c) u1Var : null;
        if (cVar == null) {
            cVar = new c(j2VarX, false, null);
        }
        kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
        synchronized (cVar) {
            if (cVar.j()) {
                return f2.f17124a;
            }
            cVar.m(true);
            if (cVar != u1Var && !y.b.a(f17094a, this, u1Var, cVar)) {
                return f2.f17126c;
            }
            boolean zI = cVar.i();
            c0 c0Var = obj instanceof c0 ? (c0) obj : null;
            if (c0Var != null) {
                cVar.a(c0Var.f17078a);
            }
            Throwable thE = zI ? null : cVar.e();
            m0Var.f14947a = thE;
            cd.h0 h0Var = cd.h0.f3852a;
            if (thE != null) {
                o0(j2VarX, thE);
            }
            v vVarN0 = n0(j2VarX);
            if (vVarN0 != null && J0(cVar, vVarN0, obj)) {
                return f2.f17125b;
            }
            j2VarX.f(2);
            v vVarN02 = n0(j2VarX);
            return (vVarN02 == null || !J0(cVar, vVarN02, obj)) ? P(cVar, obj) : f2.f17125b;
        }
    }

    public boolean J(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return B(th) && U();
    }

    public final boolean J0(c cVar, v vVar, Object obj) {
        while (b2.j(vVar.f17188e, false, new b(this, cVar, vVar, obj)) == l2.f17156a) {
            vVar = n0(vVar);
            if (vVar == null) {
                return false;
            }
        }
        return true;
    }

    public final void K(u1 u1Var, Object obj) throws Throwable {
        u uVarY = Y();
        if (uVarY != null) {
            uVarY.dispose();
            z0(l2.f17156a);
        }
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f17078a : null;
        if (!(u1Var instanceof d2)) {
            j2 j2VarB = u1Var.b();
            if (j2VarB != null) {
                p0(j2VarB, th);
                return;
            }
            return;
        }
        try {
            ((d2) u1Var).v(th);
        } catch (Throwable th2) {
            d0(new d0("Exception in completion handler " + u1Var + " for " + this, th2));
        }
    }

    public final void L(c cVar, v vVar, Object obj) {
        v vVarN0 = n0(vVar);
        if (vVarN0 == null || !J0(cVar, vVarN0, obj)) {
            cVar.b().f(2);
            v vVarN02 = n0(vVar);
            if (vVarN02 == null || !J0(cVar, vVarN02, obj)) {
                x(P(cVar, obj));
            }
        }
    }

    public final Throwable M(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new z1(I(), null, this) : th;
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((n2) obj).N();
    }

    @Override // ng.n2
    public CancellationException N() {
        Throwable thE;
        Object objZ = Z();
        if (objZ instanceof c) {
            thE = ((c) objZ).e();
        } else if (objZ instanceof c0) {
            thE = ((c0) objZ).f17078a;
        } else {
            if (objZ instanceof u1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objZ).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new z1("Parent job is " + B0(objZ), thE, this);
    }

    public final Object P(c cVar, Object obj) throws Throwable {
        boolean zI;
        Throwable thT;
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f17078a : null;
        synchronized (cVar) {
            zI = cVar.i();
            List listL = cVar.l(th);
            thT = T(cVar, listL);
            if (thT != null) {
                w(thT, listL);
            }
        }
        if (thT != null && thT != th) {
            obj = new c0(thT, false, 2, null);
        }
        if (thT != null && (G(thT) || c0(thT))) {
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((c0) obj).c();
        }
        if (!zI) {
            s0(thT);
        }
        t0(obj);
        y.b.a(f17094a, this, cVar, f2.g(obj));
        K(cVar, obj);
        return obj;
    }

    public final Object Q() throws Throwable {
        Object objZ = Z();
        if (objZ instanceof u1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objZ instanceof c0) {
            throw ((c0) objZ).f17078a;
        }
        return f2.h(objZ);
    }

    public final Throwable S(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f17078a;
        }
        return null;
    }

    public final Throwable T(c cVar, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.i()) {
                return new z1(I(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof w2) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof w2)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean U() {
        return true;
    }

    public final vg.c V() {
        g gVar = g.f17112a;
        kotlin.jvm.internal.t.d(gVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        pd.p pVar = (pd.p) kotlin.jvm.internal.t0.c(gVar, 3);
        h hVar = h.f17113a;
        kotlin.jvm.internal.t.d(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new vg.d(this, pVar, (pd.p) kotlin.jvm.internal.t0.c(hVar, 3), null, 8, null);
    }

    public boolean W() {
        return false;
    }

    public final j2 X(u1 u1Var) {
        j2 j2VarB = u1Var.b();
        if (j2VarB != null) {
            return j2VarB;
        }
        if (u1Var instanceof h1) {
            return new j2();
        }
        if (u1Var instanceof d2) {
            w0((d2) u1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + u1Var).toString());
    }

    public final u Y() {
        return (u) f17095b.get(this);
    }

    public final Object Z() {
        return f17094a.get(this);
    }

    @Override // ng.y1
    public final u attachChild(w wVar) {
        v vVar = new v(wVar);
        vVar.w(this);
        while (true) {
            Object objZ = Z();
            if (objZ instanceof h1) {
                h1 h1Var = (h1) objZ;
                if (!h1Var.isActive()) {
                    v0(h1Var);
                } else if (y.b.a(f17094a, this, objZ, vVar)) {
                    return vVar;
                }
            } else {
                if (!(objZ instanceof u1)) {
                    Object objZ2 = Z();
                    c0 c0Var = objZ2 instanceof c0 ? (c0) objZ2 : null;
                    vVar.v(c0Var != null ? c0Var.f17078a : null);
                    return l2.f17156a;
                }
                j2 j2VarB = ((u1) objZ).b();
                if (j2VarB != null) {
                    if (!j2VarB.c(vVar, 7)) {
                        boolean zC = j2VarB.c(vVar, 3);
                        Object objZ3 = Z();
                        if (objZ3 instanceof c) {
                            thE = ((c) objZ3).e();
                        } else {
                            c0 c0Var2 = objZ3 instanceof c0 ? (c0) objZ3 : null;
                            if (c0Var2 != null) {
                                thE = c0Var2.f17078a;
                            }
                        }
                        vVar.v(thE);
                        if (!zC) {
                            return l2.f17156a;
                        }
                    }
                    return vVar;
                }
                kotlin.jvm.internal.t.d(objZ, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                w0((d2) objZ);
            }
        }
    }

    public boolean c0(Throwable th) {
        return false;
    }

    @Override // ng.y1
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final void e0(y1 y1Var) {
        if (y1Var == null) {
            z0(l2.f17156a);
            return;
        }
        y1Var.start();
        u uVarAttachChild = y1Var.attachChild(this);
        z0(uVarAttachChild);
        if (isCompleted()) {
            uVarAttachChild.dispose();
            z0(l2.f17156a);
        }
    }

    public final e1 f0(boolean z10, d2 d2Var) {
        boolean z11;
        boolean zC;
        d2Var.w(this);
        while (true) {
            Object objZ = Z();
            z11 = true;
            if (!(objZ instanceof h1)) {
                if (!(objZ instanceof u1)) {
                    z11 = false;
                    break;
                }
                u1 u1Var = (u1) objZ;
                j2 j2VarB = u1Var.b();
                if (j2VarB == null) {
                    kotlin.jvm.internal.t.d(objZ, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    w0((d2) objZ);
                } else {
                    if (d2Var.u()) {
                        c cVar = u1Var instanceof c ? (c) u1Var : null;
                        Throwable thE = cVar != null ? cVar.e() : null;
                        if (thE != null) {
                            if (z10) {
                                d2Var.v(thE);
                            }
                            return l2.f17156a;
                        }
                        zC = j2VarB.c(d2Var, 5);
                    } else {
                        zC = j2VarB.c(d2Var, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                h1 h1Var = (h1) objZ;
                if (!h1Var.isActive()) {
                    v0(h1Var);
                } else if (y.b.a(f17094a, this, objZ, d2Var)) {
                    break;
                }
            }
        }
        if (z11) {
            return d2Var;
        }
        if (z10) {
            Object objZ2 = Z();
            c0 c0Var = objZ2 instanceof c0 ? (c0) objZ2 : null;
            d2Var.v(c0Var != null ? c0Var.f17078a : null);
        }
        return l2.f17156a;
    }

    @Override // gd.i.b, gd.i
    public Object fold(Object obj, pd.o oVar) {
        return y1.a.c(this, obj, oVar);
    }

    public boolean g0() {
        return false;
    }

    @Override // gd.i.b, gd.i
    public i.b get(i.c cVar) {
        return y1.a.d(this, cVar);
    }

    @Override // ng.y1
    public final CancellationException getCancellationException() {
        Object objZ = Z();
        if (!(objZ instanceof c)) {
            if (objZ instanceof u1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objZ instanceof c0) {
                return D0(this, ((c0) objZ).f17078a, null, 1, null);
            }
            return new z1(r0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objZ).e();
        if (thE != null) {
            CancellationException cancellationExceptionC0 = C0(thE, r0.a(this) + " is cancelling");
            if (cancellationExceptionC0 != null) {
                return cancellationExceptionC0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // ng.y1
    public final jg.h getChildren() {
        return jg.k.b(new f(null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object objZ = Z();
        if (objZ instanceof u1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return S(objZ);
    }

    @Override // gd.i.b
    public final i.c getKey() {
        return y1.N;
    }

    @Override // ng.y1
    public final vg.a getOnJoin() {
        i iVar = i.f17114a;
        kotlin.jvm.internal.t.d(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new vg.b(this, (pd.p) kotlin.jvm.internal.t0.c(iVar, 3), null, 4, null);
    }

    @Override // ng.y1
    public y1 getParent() {
        u uVarY = Y();
        if (uVarY != null) {
            return uVarY.getParent();
        }
        return null;
    }

    public final boolean h0() {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof u1)) {
                return false;
            }
        } while (A0(objZ) < 0);
        return true;
    }

    public final Object i0(gd.e eVar) {
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        r.a(pVar, c2.k(this, false, new p2(pVar), 1, null));
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : cd.h0.f3852a;
    }

    @Override // ng.y1
    public final e1 invokeOnCompletion(pd.k kVar) {
        return f0(true, new x1(kVar));
    }

    @Override // ng.y1
    public boolean isActive() {
        Object objZ = Z();
        return (objZ instanceof u1) && ((u1) objZ).isActive();
    }

    @Override // ng.y1
    public final boolean isCancelled() {
        Object objZ = Z();
        if (objZ instanceof c0) {
            return true;
        }
        return (objZ instanceof c) && ((c) objZ).i();
    }

    @Override // ng.y1
    public final boolean isCompleted() {
        return !(Z() instanceof u1);
    }

    public final Object j0(Object obj) throws Throwable {
        Throwable thM = null;
        while (true) {
            Object objZ = Z();
            if (objZ instanceof c) {
                synchronized (objZ) {
                    if (((c) objZ).k()) {
                        return f2.f17127d;
                    }
                    boolean zI = ((c) objZ).i();
                    if (obj != null || !zI) {
                        if (thM == null) {
                            thM = M(obj);
                        }
                        ((c) objZ).a(thM);
                    }
                    Throwable thE = zI ? null : ((c) objZ).e();
                    if (thE != null) {
                        o0(((c) objZ).b(), thE);
                    }
                    return f2.f17124a;
                }
            }
            if (!(objZ instanceof u1)) {
                return f2.f17127d;
            }
            if (thM == null) {
                thM = M(obj);
            }
            u1 u1Var = (u1) objZ;
            if (!u1Var.isActive()) {
                Object objH0 = H0(objZ, new c0(thM, false, 2, null));
                if (objH0 == f2.f17124a) {
                    throw new IllegalStateException(("Cannot happen in " + objZ).toString());
                }
                if (objH0 != f2.f17126c) {
                    return objH0;
                }
            } else if (G0(u1Var, thM)) {
                return f2.f17124a;
            }
        }
    }

    @Override // ng.y1
    public final Object join(gd.e eVar) {
        if (h0()) {
            Object objI0 = i0(eVar);
            return objI0 == hd.c.f() ? objI0 : cd.h0.f3852a;
        }
        b2.g(eVar.getContext());
        return cd.h0.f3852a;
    }

    public final boolean k0(Object obj) {
        Object objH0;
        do {
            objH0 = H0(Z(), obj);
            if (objH0 == f2.f17124a) {
                return false;
            }
            if (objH0 == f2.f17125b) {
                return true;
            }
        } while (objH0 == f2.f17126c);
        x(objH0);
        return true;
    }

    public final Object l0(Object obj) {
        Object objH0;
        do {
            objH0 = H0(Z(), obj);
            if (objH0 == f2.f17124a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, S(obj));
            }
        } while (objH0 == f2.f17126c);
        return objH0;
    }

    public String m0() {
        return r0.a(this);
    }

    @Override // gd.i.b, gd.i
    public gd.i minusKey(i.c cVar) {
        return y1.a.e(this, cVar);
    }

    public final v n0(sg.o oVar) {
        while (oVar.p()) {
            oVar = oVar.l();
        }
        while (true) {
            oVar = oVar.k();
            if (!oVar.p()) {
                if (oVar instanceof v) {
                    return (v) oVar;
                }
                if (oVar instanceof j2) {
                    return null;
                }
            }
        }
    }

    public final void o0(j2 j2Var, Throwable th) throws Throwable {
        s0(th);
        j2Var.f(4);
        Object objJ = j2Var.j();
        kotlin.jvm.internal.t.d(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        d0 d0Var = null;
        for (sg.o oVarK = (sg.o) objJ; !kotlin.jvm.internal.t.b(oVarK, j2Var); oVarK = oVarK.k()) {
            if ((oVarK instanceof d2) && ((d2) oVarK).u()) {
                try {
                    ((d2) oVarK).v(th);
                } catch (Throwable th2) {
                    if (d0Var != null) {
                        cd.e.a(d0Var, th2);
                    } else {
                        d0Var = new d0("Exception in completion handler " + oVarK + " for " + this, th2);
                        cd.h0 h0Var = cd.h0.f3852a;
                    }
                }
            }
        }
        if (d0Var != null) {
            d0(d0Var);
        }
        G(th);
    }

    public final void p0(j2 j2Var, Throwable th) throws Throwable {
        j2Var.f(1);
        Object objJ = j2Var.j();
        kotlin.jvm.internal.t.d(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        d0 d0Var = null;
        for (sg.o oVarK = (sg.o) objJ; !kotlin.jvm.internal.t.b(oVarK, j2Var); oVarK = oVarK.k()) {
            if (oVarK instanceof d2) {
                try {
                    ((d2) oVarK).v(th);
                } catch (Throwable th2) {
                    if (d0Var != null) {
                        cd.e.a(d0Var, th2);
                    } else {
                        d0Var = new d0("Exception in completion handler " + oVarK + " for " + this, th2);
                        cd.h0 h0Var = cd.h0.f3852a;
                    }
                }
            }
        }
        if (d0Var != null) {
            d0(d0Var);
        }
    }

    @Override // gd.i
    public gd.i plus(gd.i iVar) {
        return y1.a.f(this, iVar);
    }

    public final Object q0(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof c0) {
            throw ((c0) obj2).f17078a;
        }
        return obj2;
    }

    public final void r0(vg.e eVar, Object obj) {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof u1)) {
                if (!(objZ instanceof c0)) {
                    objZ = f2.h(objZ);
                }
                eVar.b(objZ);
                return;
            }
        } while (A0(objZ) < 0);
        eVar.a(c2.k(this, false, new d(eVar), 1, null));
    }

    @Override // ng.y1
    public final boolean start() {
        int iA0;
        do {
            iA0 = A0(Z());
            if (iA0 == 0) {
                return false;
            }
        } while (iA0 != 1);
        return true;
    }

    public String toString() {
        return E0() + '@' + r0.b(this);
    }

    public final void v0(h1 h1Var) {
        j2 j2Var = new j2();
        Object t1Var = j2Var;
        if (!h1Var.isActive()) {
            t1Var = new t1(j2Var);
        }
        y.b.a(f17094a, this, h1Var, t1Var);
    }

    public final void w(Throwable th, List list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                cd.e.a(th, th2);
            }
        }
    }

    public final void w0(d2 d2Var) {
        d2Var.e(new j2());
        y.b.a(f17094a, this, d2Var, d2Var.k());
    }

    public final void x0(vg.e eVar, Object obj) {
        if (h0()) {
            eVar.a(c2.k(this, false, new e(eVar), 1, null));
        } else {
            eVar.b(cd.h0.f3852a);
        }
    }

    public final Object y(gd.e eVar) throws Throwable {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof u1)) {
                if (objZ instanceof c0) {
                    throw ((c0) objZ).f17078a;
                }
                return f2.h(objZ);
            }
        } while (A0(objZ) < 0);
        return z(eVar);
    }

    public final void y0(d2 d2Var) {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof d2)) {
                if (!(objZ instanceof u1) || ((u1) objZ).b() == null) {
                    return;
                }
                d2Var.q();
                return;
            }
            if (objZ != d2Var) {
                return;
            }
        } while (!y.b.a(f17094a, this, objZ, f2.f17130g));
    }

    public final Object z(gd.e eVar) {
        a aVar = new a(hd.b.c(eVar), this);
        aVar.E();
        r.a(aVar, c2.k(this, false, new o2(aVar), 1, null));
        Object objY = aVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY;
    }

    public final void z0(u uVar) {
        f17095b.set(this, uVar);
    }

    @Override // ng.y1
    public /* synthetic */ boolean cancel(Throwable th) throws Throwable {
        Throwable z1Var;
        if (th == null || (z1Var = D0(this, th, null, 1, null)) == null) {
            z1Var = new z1(I(), null, this);
        }
        D(z1Var);
        return true;
    }

    @Override // ng.y1
    public y1 plus(y1 y1Var) {
        return y1.a.g(this, y1Var);
    }

    @Override // ng.y1
    public final e1 invokeOnCompletion(boolean z10, boolean z11, pd.k kVar) {
        d2 x1Var;
        if (z10) {
            x1Var = new w1(kVar);
        } else {
            x1Var = new x1(kVar);
        }
        return f0(z11, x1Var);
    }

    @Override // ng.y1
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new z1(I(), null, this);
        }
        D(cancellationException);
    }

    public void u0() {
    }

    public void d0(Throwable th) throws Throwable {
        throw th;
    }

    public void s0(Throwable th) {
    }

    public void t0(Object obj) {
    }

    public void x(Object obj) {
    }
}
