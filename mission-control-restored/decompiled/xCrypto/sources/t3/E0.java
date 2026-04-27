package t3;

import W2.AbstractC0737e;
import Z2.i;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
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
import t3.InterfaceC1846w0;
import y3.q;

/* JADX INFO: loaded from: classes3.dex */
public class E0 implements InterfaceC1846w0, InterfaceC1845w, M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14911a = AtomicReferenceFieldUpdater.newUpdater(E0.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14912b = AtomicReferenceFieldUpdater.newUpdater(E0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a extends C1832p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final E0 f14913i;

        public a(Z2.e eVar, E0 e02) {
            super(eVar, 1);
            this.f14913i = e02;
        }

        @Override // t3.C1832p
        public String G() {
            return "AwaitContinuation";
        }

        @Override // t3.C1832p
        public Throwable v(InterfaceC1846w0 interfaceC1846w0) {
            Throwable thE;
            Object objB0 = this.f14913i.b0();
            return (!(objB0 instanceof c) || (thE = ((c) objB0).e()) == null) ? objB0 instanceof C ? ((C) objB0).f14907a : interfaceC1846w0.getCancellationException() : thE;
        }
    }

    public static final class b extends D0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final E0 f14914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f14915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final C1843v f14916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f14917h;

        public b(E0 e02, c cVar, C1843v c1843v, Object obj) {
            this.f14914e = e02;
            this.f14915f = cVar;
            this.f14916g = c1843v;
            this.f14917h = obj;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return W2.E.f5463a;
        }

        @Override // t3.E
        public void q(Throwable th) {
            this.f14914e.N(this.f14915f, this.f14916g, this.f14917h);
        }
    }

    public static final class c implements InterfaceC1836r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f14918b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f14919c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f14920d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final J0 f14921a;

        public c(J0 j02, boolean z4, Throwable th) {
            this.f14921a = j02;
            this._isCompleting = z4 ? 1 : 0;
            this._rootCause = th;
        }

        @Override // t3.InterfaceC1836r0
        public J0 a() {
            return this.f14921a;
        }

        public final void b(Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                k(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        public final ArrayList c() {
            return new ArrayList(4);
        }

        public final Object d() {
            return f14920d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f14919c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f14918b.get(this) != 0;
        }

        public final boolean h() {
            return d() == F0.f14938e;
        }

        public final List i(Throwable th) {
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
            if (th != null && !kotlin.jvm.internal.r.b(th, thE)) {
                arrayListC.add(th);
            }
            k(F0.f14938e);
            return arrayListC;
        }

        @Override // t3.InterfaceC1836r0
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z4) {
            f14918b.set(this, z4 ? 1 : 0);
        }

        public final void k(Object obj) {
            f14920d.set(this, obj);
        }

        public final void l(Throwable th) {
            f14919c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    public final class d extends D0 {
        public d(B3.e eVar) {
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return W2.E.f5463a;
        }

        @Override // t3.E
        public void q(Throwable th) {
            Object objB0 = E0.this.b0();
            if (!(objB0 instanceof C)) {
                F0.h(objB0);
            }
            throw null;
        }
    }

    public final class e extends D0 {
        public e(B3.e eVar) {
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return W2.E.f5463a;
        }

        @Override // t3.E
        public void q(Throwable th) {
            W2.E e4 = W2.E.f5463a;
            throw null;
        }
    }

    public static final class f extends q.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ E0 f14924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f14925e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(y3.q qVar, E0 e02, Object obj) {
            super(qVar);
            this.f14924d = e02;
            this.f14925e = obj;
        }

        @Override // y3.AbstractC1948b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(y3.q qVar) {
            if (this.f14924d.b0() == this.f14925e) {
                return null;
            }
            return y3.p.a();
        }
    }

    public static final class g extends b3.k implements i3.o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f14926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f14927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14928d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f14929e;

        public g(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(q3.g gVar, Z2.e eVar) {
            return ((g) create(gVar, eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            g gVar = E0.this.new g(eVar);
            gVar.f14929e = obj;
            return gVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        
            if (r6.b(r1, r5) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r4.b(r6, r5) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r5.f14928d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r5.f14927c
                y3.q r1 = (y3.q) r1
                java.lang.Object r3 = r5.f14926b
                y3.o r3 = (y3.AbstractC1961o) r3
                java.lang.Object r4 = r5.f14929e
                q3.g r4 = (q3.g) r4
                W2.q.b(r6)
                goto L81
            L1e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L26:
                W2.q.b(r6)
                goto L86
            L2a:
                W2.q.b(r6)
                java.lang.Object r6 = r5.f14929e
                q3.g r6 = (q3.g) r6
                t3.E0 r1 = t3.E0.this
                java.lang.Object r1 = r1.b0()
                boolean r4 = r1 instanceof t3.C1843v
                if (r4 == 0) goto L48
                t3.v r1 = (t3.C1843v) r1
                t3.w r1 = r1.f15037e
                r5.f14928d = r3
                java.lang.Object r6 = r6.b(r1, r5)
                if (r6 != r0) goto L86
                goto L80
            L48:
                boolean r3 = r1 instanceof t3.InterfaceC1836r0
                if (r3 == 0) goto L86
                t3.r0 r1 = (t3.InterfaceC1836r0) r1
                t3.J0 r1 = r1.a()
                if (r1 == 0) goto L86
                java.lang.Object r3 = r1.i()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                kotlin.jvm.internal.r.d(r3, r4)
                y3.q r3 = (y3.q) r3
                r4 = r3
                r3 = r1
                r1 = r4
                r4 = r6
            L63:
                boolean r6 = kotlin.jvm.internal.r.b(r1, r3)
                if (r6 != 0) goto L86
                boolean r6 = r1 instanceof t3.C1843v
                if (r6 == 0) goto L81
                r6 = r1
                t3.v r6 = (t3.C1843v) r6
                t3.w r6 = r6.f15037e
                r5.f14929e = r4
                r5.f14926b = r3
                r5.f14927c = r1
                r5.f14928d = r2
                java.lang.Object r6 = r4.b(r6, r5)
                if (r6 != r0) goto L81
            L80:
                return r0
            L81:
                y3.q r1 = r1.j()
                goto L63
            L86:
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: t3.E0.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ class h extends kotlin.jvm.internal.o implements i3.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f14931a = new h();

        public h() {
            super(3, E0.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void d(E0 e02, B3.e eVar, Object obj) {
            e02.r0(eVar, obj);
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj2);
            d((E0) obj, null, obj3);
            return W2.E.f5463a;
        }
    }

    public /* synthetic */ class i extends kotlin.jvm.internal.o implements i3.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f14932a = new i();

        public i() {
            super(3, E0.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // i3.p
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object invoke(E0 e02, Object obj, Object obj2) {
            return e02.q0(obj, obj2);
        }
    }

    public /* synthetic */ class j extends kotlin.jvm.internal.o implements i3.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f14933a = new j();

        public j() {
            super(3, E0.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void d(E0 e02, B3.e eVar, Object obj) {
            e02.x0(eVar, obj);
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj2);
            d((E0) obj, null, obj3);
            return W2.E.f5463a;
        }
    }

    public E0(boolean z4) {
        this._state = z4 ? F0.f14940g : F0.f14939f;
    }

    public static /* synthetic */ CancellationException D0(E0 e02, Throwable th, String str, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i4 & 1) != 0) {
            str = null;
        }
        return e02.C0(th, str);
    }

    public final int A0(Object obj) {
        if (obj instanceof C1813f0) {
            if (((C1813f0) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f14911a, this, obj, F0.f14940g)) {
                return -1;
            }
            u0();
            return 1;
        }
        if (!(obj instanceof C1835q0)) {
            return 0;
        }
        if (!androidx.concurrent.futures.b.a(f14911a, this, obj, ((C1835q0) obj).a())) {
            return -1;
        }
        u0();
        return 1;
    }

    public final Object B(Z2.e eVar) {
        a aVar = new a(AbstractC0786b.c(eVar), this);
        aVar.A();
        r.a(aVar, invokeOnCompletion(new N0(aVar)));
        Object objX = aVar.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX;
    }

    public final String B0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof InterfaceC1836r0 ? ((InterfaceC1836r0) obj).isActive() ? "Active" : "New" : obj instanceof C ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    public final boolean C(Throwable th) {
        return D(th);
    }

    public final CancellationException C0(Throwable th, String str) {
        CancellationException c1848x0 = th instanceof CancellationException ? (CancellationException) th : null;
        if (c1848x0 == null) {
            if (str == null) {
                str = I();
            }
            c1848x0 = new C1848x0(str, th, this);
        }
        return c1848x0;
    }

    public final boolean D(Object obj) throws Throwable {
        Object objI0 = F0.f14934a;
        if (Y() && (objI0 = F(obj)) == F0.f14935b) {
            return true;
        }
        if (objI0 == F0.f14934a) {
            objI0 = i0(obj);
        }
        if (objI0 == F0.f14934a || objI0 == F0.f14935b) {
            return true;
        }
        if (objI0 == F0.f14937d) {
            return false;
        }
        y(objI0);
        return true;
    }

    public void E(Throwable th) throws Throwable {
        D(th);
    }

    public final String E0() {
        return m0() + '{' + B0(b0()) + '}';
    }

    public final Object F(Object obj) {
        Object objH0;
        do {
            Object objB0 = b0();
            if (!(objB0 instanceof InterfaceC1836r0) || ((objB0 instanceof c) && ((c) objB0).g())) {
                return F0.f14934a;
            }
            objH0 = H0(objB0, new C(O(obj), false, 2, null));
        } while (objH0 == F0.f14936c);
        return objH0;
    }

    public final boolean F0(InterfaceC1836r0 interfaceC1836r0, Object obj) throws Throwable {
        if (!androidx.concurrent.futures.b.a(f14911a, this, interfaceC1836r0, F0.g(obj))) {
            return false;
        }
        s0(null);
        t0(obj);
        M(interfaceC1836r0, obj);
        return true;
    }

    public final boolean G0(InterfaceC1836r0 interfaceC1836r0, Throwable th) throws Throwable {
        J0 j0Z = Z(interfaceC1836r0);
        if (j0Z == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f14911a, this, interfaceC1836r0, new c(j0Z, false, th))) {
            return false;
        }
        o0(j0Z, th);
        return true;
    }

    public final boolean H(Throwable th) {
        if (f0()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        InterfaceC1841u interfaceC1841uA0 = a0();
        return (interfaceC1841uA0 == null || interfaceC1841uA0 == K0.f14951a) ? z4 : interfaceC1841uA0.c(th) || z4;
    }

    public final Object H0(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC1836r0) ? F0.f14934a : ((!(obj instanceof C1813f0) && !(obj instanceof D0)) || (obj instanceof C1843v) || (obj2 instanceof C)) ? I0((InterfaceC1836r0) obj, obj2) : F0((InterfaceC1836r0) obj, obj2) ? obj2 : F0.f14936c;
    }

    public String I() {
        return "Job was cancelled";
    }

    public final Object I0(InterfaceC1836r0 interfaceC1836r0, Object obj) throws Throwable {
        J0 j0Z = Z(interfaceC1836r0);
        if (j0Z == null) {
            return F0.f14936c;
        }
        c cVar = interfaceC1836r0 instanceof c ? (c) interfaceC1836r0 : null;
        if (cVar == null) {
            cVar = new c(j0Z, false, null);
        }
        kotlin.jvm.internal.F f4 = new kotlin.jvm.internal.F();
        synchronized (cVar) {
            if (cVar.g()) {
                return F0.f14934a;
            }
            cVar.j(true);
            if (cVar != interfaceC1836r0 && !androidx.concurrent.futures.b.a(f14911a, this, interfaceC1836r0, cVar)) {
                return F0.f14936c;
            }
            boolean zF = cVar.f();
            C c4 = obj instanceof C ? (C) obj : null;
            if (c4 != null) {
                cVar.b(c4.f14907a);
            }
            Throwable thE = zF ? null : cVar.e();
            f4.f13410a = thE;
            W2.E e4 = W2.E.f5463a;
            if (thE != null) {
                o0(j0Z, thE);
            }
            C1843v c1843vR = R(interfaceC1836r0);
            return (c1843vR == null || !J0(cVar, c1843vR, obj)) ? Q(cVar, obj) : F0.f14935b;
        }
    }

    public final boolean J0(c cVar, C1843v c1843v, Object obj) {
        while (InterfaceC1846w0.a.e(c1843v.f15037e, false, false, new b(this, cVar, c1843v, obj), 1, null) == K0.f14951a) {
            c1843v = n0(c1843v);
            if (c1843v == null) {
                return false;
            }
        }
        return true;
    }

    public boolean L(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return D(th) && W();
    }

    public final void M(InterfaceC1836r0 interfaceC1836r0, Object obj) throws Throwable {
        InterfaceC1841u interfaceC1841uA0 = a0();
        if (interfaceC1841uA0 != null) {
            interfaceC1841uA0.dispose();
            z0(K0.f14951a);
        }
        C c4 = obj instanceof C ? (C) obj : null;
        Throwable th = c4 != null ? c4.f14907a : null;
        if (!(interfaceC1836r0 instanceof D0)) {
            J0 j0A = interfaceC1836r0.a();
            if (j0A != null) {
                p0(j0A, th);
                return;
            }
            return;
        }
        try {
            ((D0) interfaceC1836r0).q(th);
        } catch (Throwable th2) {
            d0(new F("Exception in completion handler " + interfaceC1836r0 + " for " + this, th2));
        }
    }

    public final void N(c cVar, C1843v c1843v, Object obj) {
        C1843v c1843vN0 = n0(c1843v);
        if (c1843vN0 == null || !J0(cVar, c1843vN0, obj)) {
            y(Q(cVar, obj));
        }
    }

    public final Throwable O(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new C1848x0(I(), null, this) : th;
        }
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((M0) obj).P();
    }

    @Override // t3.M0
    public CancellationException P() {
        Throwable thE;
        Object objB0 = b0();
        if (objB0 instanceof c) {
            thE = ((c) objB0).e();
        } else if (objB0 instanceof C) {
            thE = ((C) objB0).f14907a;
        } else {
            if (objB0 instanceof InterfaceC1836r0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objB0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new C1848x0("Parent job is " + B0(objB0), thE, this);
    }

    public final Object Q(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thV;
        C c4 = obj instanceof C ? (C) obj : null;
        Throwable th = c4 != null ? c4.f14907a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List listI = cVar.i(th);
            thV = V(cVar, listI);
            if (thV != null) {
                w(thV, listI);
            }
        }
        if (thV != null && thV != th) {
            obj = new C(thV, false, 2, null);
        }
        if (thV != null && (H(thV) || c0(thV))) {
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C) obj).b();
        }
        if (!zF) {
            s0(thV);
        }
        t0(obj);
        androidx.concurrent.futures.b.a(f14911a, this, cVar, F0.g(obj));
        M(cVar, obj);
        return obj;
    }

    public final C1843v R(InterfaceC1836r0 interfaceC1836r0) {
        C1843v c1843v = interfaceC1836r0 instanceof C1843v ? (C1843v) interfaceC1836r0 : null;
        if (c1843v != null) {
            return c1843v;
        }
        J0 j0A = interfaceC1836r0.a();
        if (j0A != null) {
            return n0(j0A);
        }
        return null;
    }

    public final Object T() throws Throwable {
        Object objB0 = b0();
        if (objB0 instanceof InterfaceC1836r0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objB0 instanceof C) {
            throw ((C) objB0).f14907a;
        }
        return F0.h(objB0);
    }

    public final Throwable U(Object obj) {
        C c4 = obj instanceof C ? (C) obj : null;
        if (c4 != null) {
            return c4.f14907a;
        }
        return null;
    }

    public final Throwable V(c cVar, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new C1848x0(I(), null, this);
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
        if (th2 instanceof V0) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof V0)) {
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

    public boolean W() {
        return true;
    }

    public final B3.c X() {
        h hVar = h.f14931a;
        kotlin.jvm.internal.r.d(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        i3.p pVar = (i3.p) kotlin.jvm.internal.K.b(hVar, 3);
        i iVar = i.f14932a;
        kotlin.jvm.internal.r.d(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new B3.d(this, pVar, (i3.p) kotlin.jvm.internal.K.b(iVar, 3), null, 8, null);
    }

    public boolean Y() {
        return false;
    }

    public final J0 Z(InterfaceC1836r0 interfaceC1836r0) {
        J0 j0A = interfaceC1836r0.a();
        if (j0A != null) {
            return j0A;
        }
        if (interfaceC1836r0 instanceof C1813f0) {
            return new J0();
        }
        if (interfaceC1836r0 instanceof D0) {
            w0((D0) interfaceC1836r0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC1836r0).toString());
    }

    public final InterfaceC1841u a0() {
        return (InterfaceC1841u) f14912b.get(this);
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1841u attachChild(InterfaceC1845w interfaceC1845w) {
        InterfaceC1807c0 interfaceC1807c0E = InterfaceC1846w0.a.e(this, true, false, new C1843v(interfaceC1845w), 2, null);
        kotlin.jvm.internal.r.d(interfaceC1807c0E, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC1841u) interfaceC1807c0E;
    }

    public final Object b0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14911a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y3.y)) {
                return obj;
            }
            ((y3.y) obj).a(this);
        }
    }

    public boolean c0(Throwable th) {
        return false;
    }

    @Override // t3.InterfaceC1846w0
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final void e0(InterfaceC1846w0 interfaceC1846w0) {
        if (interfaceC1846w0 == null) {
            z0(K0.f14951a);
            return;
        }
        interfaceC1846w0.start();
        InterfaceC1841u interfaceC1841uAttachChild = interfaceC1846w0.attachChild(this);
        z0(interfaceC1841uAttachChild);
        if (isCompleted()) {
            interfaceC1841uAttachChild.dispose();
            z0(K0.f14951a);
        }
    }

    public boolean f0() {
        return false;
    }

    @Override // Z2.i.b, Z2.i
    public Object fold(Object obj, i3.o oVar) {
        return InterfaceC1846w0.a.c(this, obj, oVar);
    }

    public final boolean g0() {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof InterfaceC1836r0)) {
                return false;
            }
        } while (A0(objB0) < 0);
        return true;
    }

    @Override // Z2.i.b, Z2.i
    public i.b get(i.c cVar) {
        return InterfaceC1846w0.a.d(this, cVar);
    }

    @Override // t3.InterfaceC1846w0
    public final CancellationException getCancellationException() {
        Object objB0 = b0();
        if (!(objB0 instanceof c)) {
            if (objB0 instanceof InterfaceC1836r0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objB0 instanceof C) {
                return D0(this, ((C) objB0).f14907a, null, 1, null);
            }
            return new C1848x0(P.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objB0).e();
        if (thE != null) {
            CancellationException cancellationExceptionC0 = C0(thE, P.a(this) + " is cancelling");
            if (cancellationExceptionC0 != null) {
                return cancellationExceptionC0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // t3.InterfaceC1846w0
    public final q3.e getChildren() {
        return q3.h.b(new g(null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object objB0 = b0();
        if (objB0 instanceof InterfaceC1836r0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return U(objB0);
    }

    @Override // Z2.i.b
    public final i.c getKey() {
        return InterfaceC1846w0.f15039M;
    }

    @Override // t3.InterfaceC1846w0
    public final B3.a getOnJoin() {
        j jVar = j.f14933a;
        kotlin.jvm.internal.r.d(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new B3.b(this, (i3.p) kotlin.jvm.internal.K.b(jVar, 3), null, 4, null);
    }

    @Override // t3.InterfaceC1846w0
    public InterfaceC1846w0 getParent() {
        InterfaceC1841u interfaceC1841uA0 = a0();
        if (interfaceC1841uA0 != null) {
            return interfaceC1841uA0.getParent();
        }
        return null;
    }

    public final Object h0(Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        r.a(c1832p, invokeOnCompletion(new O0(c1832p)));
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : W2.E.f5463a;
    }

    public final Object i0(Object obj) throws Throwable {
        Throwable thO = null;
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof c) {
                synchronized (objB0) {
                    if (((c) objB0).h()) {
                        return F0.f14937d;
                    }
                    boolean zF = ((c) objB0).f();
                    if (obj != null || !zF) {
                        if (thO == null) {
                            thO = O(obj);
                        }
                        ((c) objB0).b(thO);
                    }
                    Throwable thE = zF ? null : ((c) objB0).e();
                    if (thE != null) {
                        o0(((c) objB0).a(), thE);
                    }
                    return F0.f14934a;
                }
            }
            if (!(objB0 instanceof InterfaceC1836r0)) {
                return F0.f14937d;
            }
            if (thO == null) {
                thO = O(obj);
            }
            InterfaceC1836r0 interfaceC1836r0 = (InterfaceC1836r0) objB0;
            if (!interfaceC1836r0.isActive()) {
                Object objH0 = H0(objB0, new C(thO, false, 2, null));
                if (objH0 == F0.f14934a) {
                    throw new IllegalStateException(("Cannot happen in " + objB0).toString());
                }
                if (objH0 != F0.f14936c) {
                    return objH0;
                }
            } else if (G0(interfaceC1836r0, thO)) {
                return F0.f14934a;
            }
        }
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1807c0 invokeOnCompletion(i3.k kVar) {
        return invokeOnCompletion(false, true, kVar);
    }

    @Override // t3.InterfaceC1846w0
    public boolean isActive() {
        Object objB0 = b0();
        return (objB0 instanceof InterfaceC1836r0) && ((InterfaceC1836r0) objB0).isActive();
    }

    @Override // t3.InterfaceC1846w0
    public final boolean isCancelled() {
        Object objB0 = b0();
        if (objB0 instanceof C) {
            return true;
        }
        return (objB0 instanceof c) && ((c) objB0).f();
    }

    @Override // t3.InterfaceC1846w0
    public final boolean isCompleted() {
        return !(b0() instanceof InterfaceC1836r0);
    }

    public final boolean j0(Object obj) {
        Object objH0;
        do {
            objH0 = H0(b0(), obj);
            if (objH0 == F0.f14934a) {
                return false;
            }
            if (objH0 == F0.f14935b) {
                return true;
            }
        } while (objH0 == F0.f14936c);
        y(objH0);
        return true;
    }

    @Override // t3.InterfaceC1846w0
    public final Object join(Z2.e eVar) {
        if (g0()) {
            Object objH0 = h0(eVar);
            return objH0 == AbstractC0787c.e() ? objH0 : W2.E.f5463a;
        }
        A0.h(eVar.getContext());
        return W2.E.f5463a;
    }

    public final Object k0(Object obj) {
        Object objH0;
        do {
            objH0 = H0(b0(), obj);
            if (objH0 == F0.f14934a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, U(obj));
            }
        } while (objH0 == F0.f14936c);
        return objH0;
    }

    public final D0 l0(i3.k kVar, boolean z4) {
        D0 c1844v0;
        if (z4) {
            c1844v0 = kVar instanceof AbstractC1850y0 ? (AbstractC1850y0) kVar : null;
            if (c1844v0 == null) {
                c1844v0 = new C1842u0(kVar);
            }
        } else {
            c1844v0 = kVar instanceof D0 ? (D0) kVar : null;
            if (c1844v0 == null) {
                c1844v0 = new C1844v0(kVar);
            }
        }
        c1844v0.s(this);
        return c1844v0;
    }

    public String m0() {
        return P.a(this);
    }

    @Override // Z2.i.b, Z2.i
    public Z2.i minusKey(i.c cVar) {
        return InterfaceC1846w0.a.f(this, cVar);
    }

    public final C1843v n0(y3.q qVar) {
        while (qVar.l()) {
            qVar = qVar.k();
        }
        while (true) {
            qVar = qVar.j();
            if (!qVar.l()) {
                if (qVar instanceof C1843v) {
                    return (C1843v) qVar;
                }
                if (qVar instanceof J0) {
                    return null;
                }
            }
        }
    }

    public final void o0(J0 j02, Throwable th) throws Throwable {
        s0(th);
        Object objI = j02.i();
        kotlin.jvm.internal.r.d(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        F f4 = null;
        for (y3.q qVarJ = (y3.q) objI; !kotlin.jvm.internal.r.b(qVarJ, j02); qVarJ = qVarJ.j()) {
            if (qVarJ instanceof AbstractC1850y0) {
                D0 d02 = (D0) qVarJ;
                try {
                    d02.q(th);
                } catch (Throwable th2) {
                    if (f4 != null) {
                        AbstractC0737e.a(f4, th2);
                    } else {
                        f4 = new F("Exception in completion handler " + d02 + " for " + this, th2);
                        W2.E e4 = W2.E.f5463a;
                    }
                }
            }
        }
        if (f4 != null) {
            d0(f4);
        }
        H(th);
    }

    public final void p0(J0 j02, Throwable th) throws Throwable {
        Object objI = j02.i();
        kotlin.jvm.internal.r.d(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        F f4 = null;
        for (y3.q qVarJ = (y3.q) objI; !kotlin.jvm.internal.r.b(qVarJ, j02); qVarJ = qVarJ.j()) {
            if (qVarJ instanceof D0) {
                D0 d02 = (D0) qVarJ;
                try {
                    d02.q(th);
                } catch (Throwable th2) {
                    if (f4 != null) {
                        AbstractC0737e.a(f4, th2);
                    } else {
                        f4 = new F("Exception in completion handler " + d02 + " for " + this, th2);
                        W2.E e4 = W2.E.f5463a;
                    }
                }
            }
        }
        if (f4 != null) {
            d0(f4);
        }
    }

    @Override // Z2.i
    public Z2.i plus(Z2.i iVar) {
        return InterfaceC1846w0.a.g(this, iVar);
    }

    public final Object q0(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof C) {
            throw ((C) obj2).f14907a;
        }
        return obj2;
    }

    public final void r0(B3.e eVar, Object obj) {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof InterfaceC1836r0)) {
                if (!(objB0 instanceof C)) {
                    objB0 = F0.h(objB0);
                }
                eVar.b(objB0);
                return;
            }
        } while (A0(objB0) < 0);
        eVar.a(invokeOnCompletion(new d(eVar)));
    }

    @Override // t3.InterfaceC1846w0
    public final boolean start() {
        int iA0;
        do {
            iA0 = A0(b0());
            if (iA0 == 0) {
                return false;
            }
        } while (iA0 != 1);
        return true;
    }

    public String toString() {
        return E0() + '@' + P.b(this);
    }

    public final boolean v(Object obj, J0 j02, D0 d02) {
        int iP;
        f fVar = new f(d02, this, obj);
        do {
            iP = j02.k().p(d02, j02, fVar);
            if (iP == 1) {
                return true;
            }
        } while (iP != 2);
        return false;
    }

    public final void v0(C1813f0 c1813f0) {
        J0 j02 = new J0();
        Object c1835q0 = j02;
        if (!c1813f0.isActive()) {
            c1835q0 = new C1835q0(j02);
        }
        androidx.concurrent.futures.b.a(f14911a, this, c1813f0, c1835q0);
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
                AbstractC0737e.a(th, th2);
            }
        }
    }

    public final void w0(D0 d02) {
        d02.e(new J0());
        androidx.concurrent.futures.b.a(f14911a, this, d02, d02.j());
    }

    @Override // t3.InterfaceC1845w
    public final void x(M0 m02) throws Throwable {
        D(m02);
    }

    public final void x0(B3.e eVar, Object obj) {
        if (g0()) {
            eVar.a(invokeOnCompletion(new e(eVar)));
        } else {
            eVar.b(W2.E.f5463a);
        }
    }

    public final void y0(D0 d02) {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof D0)) {
                if (!(objB0 instanceof InterfaceC1836r0) || ((InterfaceC1836r0) objB0).a() == null) {
                    return;
                }
                d02.m();
                return;
            }
            if (objB0 != d02) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f14911a, this, objB0, F0.f14940g));
    }

    public final Object z(Z2.e eVar) throws Throwable {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof InterfaceC1836r0)) {
                if (objB0 instanceof C) {
                    throw ((C) objB0).f14907a;
                }
                return F0.h(objB0);
            }
        } while (A0(objB0) < 0);
        return B(eVar);
    }

    public final void z0(InterfaceC1841u interfaceC1841u) {
        f14912b.set(this, interfaceC1841u);
    }

    @Override // t3.InterfaceC1846w0
    public /* synthetic */ boolean cancel(Throwable th) throws Throwable {
        Throwable c1848x0;
        if (th == null || (c1848x0 = D0(this, th, null, 1, null)) == null) {
            c1848x0 = new C1848x0(I(), null, this);
        }
        E(c1848x0);
        return true;
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1807c0 invokeOnCompletion(boolean z4, boolean z5, i3.k kVar) {
        D0 d0L0 = l0(kVar, z4);
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof C1813f0) {
                C1813f0 c1813f0 = (C1813f0) objB0;
                if (!c1813f0.isActive()) {
                    v0(c1813f0);
                } else if (androidx.concurrent.futures.b.a(f14911a, this, objB0, d0L0)) {
                    break;
                }
            } else {
                if (!(objB0 instanceof InterfaceC1836r0)) {
                    if (z5) {
                        C c4 = objB0 instanceof C ? (C) objB0 : null;
                        kVar.invoke(c4 != null ? c4.f14907a : null);
                    }
                    return K0.f14951a;
                }
                J0 j0A = ((InterfaceC1836r0) objB0).a();
                if (j0A == null) {
                    kotlin.jvm.internal.r.d(objB0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    w0((D0) objB0);
                } else {
                    InterfaceC1807c0 interfaceC1807c0 = K0.f14951a;
                    if (z4 && (objB0 instanceof c)) {
                        synchronized (objB0) {
                            try {
                                thE = ((c) objB0).e();
                                if (thE == null || ((kVar instanceof C1843v) && !((c) objB0).g())) {
                                    if (v(objB0, j0A, d0L0)) {
                                        if (thE == null) {
                                            return d0L0;
                                        }
                                        interfaceC1807c0 = d0L0;
                                    }
                                }
                                W2.E e4 = W2.E.f5463a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (thE != null) {
                        if (z5) {
                            kVar.invoke(thE);
                        }
                        return interfaceC1807c0;
                    }
                    if (v(objB0, j0A, d0L0)) {
                        break;
                    }
                }
            }
        }
        return d0L0;
    }

    @Override // t3.InterfaceC1846w0
    public InterfaceC1846w0 plus(InterfaceC1846w0 interfaceC1846w0) {
        return InterfaceC1846w0.a.h(this, interfaceC1846w0);
    }

    @Override // t3.InterfaceC1846w0
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new C1848x0(I(), null, this);
        }
        E(cancellationException);
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

    public void y(Object obj) {
    }
}
