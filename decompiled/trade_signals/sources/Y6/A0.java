package Y6;

import Y6.InterfaceC1033u0;
import d7.C1654o;
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
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2477e;
import o5.C2470H;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2750b;
import t5.AbstractC2751c;
import u5.AbstractC2781h;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes2.dex */
public class A0 implements InterfaceC1033u0, InterfaceC1032u, I0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9603a = AtomicReferenceFieldUpdater.newUpdater(A0.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9604b = AtomicReferenceFieldUpdater.newUpdater(A0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public static final class a extends C1019n {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final A0 f9605i;

        public a(InterfaceC2707e interfaceC2707e, A0 a02) {
            super(interfaceC2707e, 1);
            this.f9605i = a02;
        }

        @Override // Y6.C1019n
        public String L() {
            return "AwaitContinuation";
        }

        @Override // Y6.C1019n
        public Throwable w(InterfaceC1033u0 interfaceC1033u0) {
            Throwable thF;
            Object objF0 = this.f9605i.f0();
            return (!(objF0 instanceof c) || (thF = ((c) objF0).f()) == null) ? objF0 instanceof A ? ((A) objF0).f9602a : interfaceC1033u0.B() : thF;
        }
    }

    public static final class b extends z0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final A0 f9606e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f9607f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final C1030t f9608g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f9609h;

        public b(A0 a02, c cVar, C1030t c1030t, Object obj) {
            this.f9606e = a02;
            this.f9607f = cVar;
            this.f9608g = c1030t;
            this.f9609h = obj;
        }

        @Override // Y6.z0
        public boolean v() {
            return false;
        }

        @Override // Y6.z0
        public void w(Throwable th) {
            this.f9606e.L(this.f9607f, this.f9608g, this.f9609h);
        }
    }

    public static final class c implements InterfaceC1026q0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f9610b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f9611c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f9612d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final F0 f9613a;

        public c(F0 f02, boolean z7, Throwable th) {
            this.f9613a = f02;
            this._isCompleting$volatile = z7 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        public final void a(Throwable th) {
            Throwable thF = f();
            if (thF == null) {
                p(th);
                return;
            }
            if (th == thF) {
                return;
            }
            Object objE = e();
            if (objE == null) {
                o(th);
                return;
            }
            if (objE instanceof Throwable) {
                if (th == objE) {
                    return;
                }
                ArrayList arrayListB = b();
                arrayListB.add(objE);
                arrayListB.add(th);
                o(arrayListB);
                return;
            }
            if (objE instanceof ArrayList) {
                ((ArrayList) objE).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objE).toString());
        }

        public final ArrayList b() {
            return new ArrayList(4);
        }

        @Override // Y6.InterfaceC1026q0
        public boolean c() {
            return f() == null;
        }

        @Override // Y6.InterfaceC1026q0
        public F0 d() {
            return this.f9613a;
        }

        public final Object e() {
            return f9612d.get(this);
        }

        public final Throwable f() {
            return (Throwable) f9611c.get(this);
        }

        public final boolean j() {
            return f() != null;
        }

        public final boolean k() {
            return f9610b.get(this) != 0;
        }

        public final boolean l() {
            return e() == B0.f9618e;
        }

        public final List m(Throwable th) {
            ArrayList arrayListB;
            Object objE = e();
            if (objE == null) {
                arrayListB = b();
            } else if (objE instanceof Throwable) {
                ArrayList arrayListB2 = b();
                arrayListB2.add(objE);
                arrayListB = arrayListB2;
            } else {
                if (!(objE instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objE).toString());
                }
                arrayListB = (ArrayList) objE;
            }
            Throwable thF = f();
            if (thF != null) {
                arrayListB.add(0, thF);
            }
            if (th != null && !AbstractC2304t.b(th, thF)) {
                arrayListB.add(th);
            }
            o(B0.f9618e);
            return arrayListB;
        }

        public final void n(boolean z7) {
            f9610b.set(this, z7 ? 1 : 0);
        }

        public final void o(Object obj) {
            f9612d.set(this, obj);
        }

        public final void p(Throwable th) {
            f9611c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + j() + ", completing=" + k() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    public A0(boolean z7) {
        this._state$volatile = z7 ? B0.f9620g : B0.f9619f;
    }

    public static /* synthetic */ CancellationException I0(A0 a02, Throwable th, String str, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i8 & 1) != 0) {
            str = null;
        }
        return a02.H0(th, str);
    }

    public final boolean A(Object obj) throws Throwable {
        Object objP0 = B0.f9614a;
        if (a0() && (objP0 = F(obj)) == B0.f9615b) {
            return true;
        }
        if (objP0 == B0.f9614a) {
            objP0 = p0(obj);
        }
        if (objP0 == B0.f9614a || objP0 == B0.f9615b) {
            return true;
        }
        if (objP0 == B0.f9617d) {
            return false;
        }
        w(objP0);
        return true;
    }

    @Override // Y6.InterfaceC1033u0
    public final CancellationException B() {
        Object objF0 = f0();
        if (!(objF0 instanceof c)) {
            if (objF0 instanceof InterfaceC1026q0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objF0 instanceof A) {
                return I0(this, ((A) objF0).f9602a, null, 1, null);
            }
            return new v0(P.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((c) objF0).f();
        if (thF != null) {
            CancellationException cancellationExceptionH0 = H0(thF, P.a(this) + " is cancelling");
            if (cancellationExceptionH0 != null) {
                return cancellationExceptionH0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void B0(C1000d0 c1000d0) {
        F0 f02 = new F0();
        Object c1024p0 = f02;
        if (!c1000d0.c()) {
            c1024p0 = new C1024p0(f02);
        }
        AbstractC2965b.a(f9603a, this, c1000d0, c1024p0);
    }

    public void C(Throwable th) throws Throwable {
        A(th);
    }

    public final void C0(z0 z0Var) {
        z0Var.f(new F0());
        AbstractC2965b.a(f9603a, this, z0Var, z0Var.l());
    }

    public final void D0(z0 z0Var) {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof z0)) {
                if (!(objF0 instanceof InterfaceC1026q0) || ((InterfaceC1026q0) objF0).d() == null) {
                    return;
                }
                z0Var.r();
                return;
            }
            if (objF0 != z0Var) {
                return;
            }
        } while (!AbstractC2965b.a(f9603a, this, objF0, B0.f9620g));
    }

    @Override // Y6.InterfaceC1033u0
    public final InterfaceC0996b0 E(B5.k kVar) {
        return n0(true, new C1031t0(kVar));
    }

    public final void E0(InterfaceC1028s interfaceC1028s) {
        f9604b.set(this, interfaceC1028s);
    }

    public final Object F(Object obj) {
        Object objM0;
        do {
            Object objF0 = f0();
            if (!(objF0 instanceof InterfaceC1026q0) || ((objF0 instanceof c) && ((c) objF0).k())) {
                return B0.f9614a;
            }
            objM0 = M0(objF0, new A(P(obj), false, 2, null));
        } while (objM0 == B0.f9616c);
        return objM0;
    }

    public final int F0(Object obj) {
        if (obj instanceof C1000d0) {
            if (((C1000d0) obj).c()) {
                return 0;
            }
            if (!AbstractC2965b.a(f9603a, this, obj, B0.f9620g)) {
                return -1;
            }
            A0();
            return 1;
        }
        if (!(obj instanceof C1024p0)) {
            return 0;
        }
        if (!AbstractC2965b.a(f9603a, this, obj, ((C1024p0) obj).d())) {
            return -1;
        }
        A0();
        return 1;
    }

    public final boolean G(Throwable th) {
        if (o0()) {
            return true;
        }
        boolean z7 = th instanceof CancellationException;
        InterfaceC1028s interfaceC1028sE0 = e0();
        return (interfaceC1028sE0 == null || interfaceC1028sE0 == G0.f9625a) ? z7 : interfaceC1028sE0.a(th) || z7;
    }

    public final String G0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof InterfaceC1026q0 ? ((InterfaceC1026q0) obj).c() ? "Active" : "New" : obj instanceof A ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.j() ? "Cancelling" : cVar.k() ? "Completing" : "Active";
    }

    public String H() {
        return "Job was cancelled";
    }

    public final CancellationException H0(Throwable th, String str) {
        CancellationException v0Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (v0Var == null) {
            if (str == null) {
                str = H();
            }
            v0Var = new v0(str, th, this);
        }
        return v0Var;
    }

    public boolean I(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return A(th) && Z();
    }

    public final void J(InterfaceC1026q0 interfaceC1026q0, Object obj) throws Throwable {
        InterfaceC1028s interfaceC1028sE0 = e0();
        if (interfaceC1028sE0 != null) {
            interfaceC1028sE0.dispose();
            E0(G0.f9625a);
        }
        A a8 = obj instanceof A ? (A) obj : null;
        Throwable th = a8 != null ? a8.f9602a : null;
        if (!(interfaceC1026q0 instanceof z0)) {
            F0 f0D = interfaceC1026q0.d();
            if (f0D != null) {
                x0(f0D, th);
                return;
            }
            return;
        }
        try {
            ((z0) interfaceC1026q0).w(th);
        } catch (Throwable th2) {
            k0(new B("Exception in completion handler " + interfaceC1026q0 + " for " + this, th2));
        }
    }

    public final String J0() {
        return u0() + '{' + G0(f0()) + '}';
    }

    @Override // s5.InterfaceC2711i
    public Object K(Object obj, B5.o oVar) {
        return InterfaceC1033u0.a.b(this, obj, oVar);
    }

    public final boolean K0(InterfaceC1026q0 interfaceC1026q0, Object obj) throws Throwable {
        if (!AbstractC2965b.a(f9603a, this, interfaceC1026q0, B0.g(obj))) {
            return false;
        }
        y0(null);
        z0(obj);
        J(interfaceC1026q0, obj);
        return true;
    }

    public final void L(c cVar, C1030t c1030t, Object obj) {
        C1030t c1030tV0 = v0(c1030t);
        if (c1030tV0 == null || !O0(cVar, c1030tV0, obj)) {
            cVar.d().g(2);
            C1030t c1030tV02 = v0(c1030t);
            if (c1030tV02 == null || !O0(cVar, c1030tV02, obj)) {
                w(S(cVar, obj));
            }
        }
    }

    public final boolean L0(InterfaceC1026q0 interfaceC1026q0, Throwable th) throws Throwable {
        F0 f0C0 = c0(interfaceC1026q0);
        if (f0C0 == null) {
            return false;
        }
        if (!AbstractC2965b.a(f9603a, this, interfaceC1026q0, new c(f0C0, false, th))) {
            return false;
        }
        w0(f0C0, th);
        return true;
    }

    public final Object M0(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC1026q0) ? B0.f9614a : ((!(obj instanceof C1000d0) && !(obj instanceof z0)) || (obj instanceof C1030t) || (obj2 instanceof A)) ? N0((InterfaceC1026q0) obj, obj2) : K0((InterfaceC1026q0) obj, obj2) ? obj2 : B0.f9616c;
    }

    @Override // Y6.InterfaceC1033u0
    public final InterfaceC1028s N(InterfaceC1032u interfaceC1032u) {
        C1030t c1030t = new C1030t(interfaceC1032u);
        c1030t.x(this);
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof C1000d0) {
                C1000d0 c1000d0 = (C1000d0) objF0;
                if (!c1000d0.c()) {
                    B0(c1000d0);
                } else if (AbstractC2965b.a(f9603a, this, objF0, c1030t)) {
                    break;
                }
            } else {
                if (!(objF0 instanceof InterfaceC1026q0)) {
                    Object objF02 = f0();
                    A a8 = objF02 instanceof A ? (A) objF02 : null;
                    c1030t.w(a8 != null ? a8.f9602a : null);
                    return G0.f9625a;
                }
                F0 f0D = ((InterfaceC1026q0) objF0).d();
                if (f0D == null) {
                    AbstractC2304t.d(objF0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    C0((z0) objF0);
                } else if (!f0D.b(c1030t, 7)) {
                    boolean zB = f0D.b(c1030t, 3);
                    Object objF03 = f0();
                    if (objF03 instanceof c) {
                        thF = ((c) objF03).f();
                    } else {
                        A a9 = objF03 instanceof A ? (A) objF03 : null;
                        if (a9 != null) {
                            thF = a9.f9602a;
                        }
                    }
                    c1030t.w(thF);
                    if (!zB) {
                        return G0.f9625a;
                    }
                }
            }
        }
        return c1030t;
    }

    public final Object N0(InterfaceC1026q0 interfaceC1026q0, Object obj) throws Throwable {
        F0 f0C0 = c0(interfaceC1026q0);
        if (f0C0 == null) {
            return B0.f9616c;
        }
        c cVar = interfaceC1026q0 instanceof c ? (c) interfaceC1026q0 : null;
        if (cVar == null) {
            cVar = new c(f0C0, false, null);
        }
        kotlin.jvm.internal.N n8 = new kotlin.jvm.internal.N();
        synchronized (cVar) {
            if (cVar.k()) {
                return B0.f9614a;
            }
            cVar.n(true);
            if (cVar != interfaceC1026q0 && !AbstractC2965b.a(f9603a, this, interfaceC1026q0, cVar)) {
                return B0.f9616c;
            }
            boolean zJ = cVar.j();
            A a8 = obj instanceof A ? (A) obj : null;
            if (a8 != null) {
                cVar.a(a8.f9602a);
            }
            Throwable thF = zJ ^ true ? cVar.f() : null;
            n8.f20469a = thF;
            C2470H c2470h = C2470H.f21956a;
            if (thF != null) {
                w0(f0C0, thF);
            }
            C1030t c1030tV0 = v0(f0C0);
            if (c1030tV0 != null && O0(cVar, c1030tV0, obj)) {
                return B0.f9615b;
            }
            f0C0.g(2);
            C1030t c1030tV02 = v0(f0C0);
            return (c1030tV02 == null || !O0(cVar, c1030tV02, obj)) ? S(cVar, obj) : B0.f9615b;
        }
    }

    public final boolean O0(c cVar, C1030t c1030t, Object obj) {
        while (x0.f(c1030t.f9692e, false, new b(this, cVar, c1030t, obj)) == G0.f9625a) {
            c1030t = v0(c1030t);
            if (c1030t == null) {
                return false;
            }
        }
        return true;
    }

    public final Throwable P(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new v0(H(), null, this) : th;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((I0) obj).b0();
    }

    @Override // Y6.InterfaceC1032u
    public final void Q(I0 i02) throws Throwable {
        A(i02);
    }

    public final Object S(c cVar, Object obj) throws Throwable {
        boolean zJ;
        Throwable thY;
        A a8 = obj instanceof A ? (A) obj : null;
        Throwable th = a8 != null ? a8.f9602a : null;
        synchronized (cVar) {
            zJ = cVar.j();
            List listM = cVar.m(th);
            thY = Y(cVar, listM);
            if (thY != null) {
                v(thY, listM);
            }
        }
        if (thY != null && thY != th) {
            obj = new A(thY, false, 2, null);
        }
        if (thY != null && (G(thY) || j0(thY))) {
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((A) obj).c();
        }
        if (!zJ) {
            y0(thY);
        }
        z0(obj);
        AbstractC2965b.a(f9603a, this, cVar, B0.g(obj));
        J(cVar, obj);
        return obj;
    }

    public final Object U() throws Throwable {
        Object objF0 = f0();
        if (!(!(objF0 instanceof InterfaceC1026q0))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objF0 instanceof A) {
            throw ((A) objF0).f9602a;
        }
        return B0.h(objF0);
    }

    public final Throwable V(Object obj) {
        A a8 = obj instanceof A ? (A) obj : null;
        if (a8 != null) {
            return a8.f9602a;
        }
        return null;
    }

    public final Throwable Y(c cVar, List list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.j()) {
                return new v0(H(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : (Throwable) list.get(0);
    }

    public boolean Z() {
        return true;
    }

    @Override // s5.InterfaceC2711i.b, s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c cVar) {
        return InterfaceC1033u0.a.c(this, cVar);
    }

    public boolean a0() {
        return false;
    }

    @Override // Y6.I0
    public CancellationException b0() {
        Throwable thF;
        Object objF0 = f0();
        if (objF0 instanceof c) {
            thF = ((c) objF0).f();
        } else if (objF0 instanceof A) {
            thF = ((A) objF0).f9602a;
        } else {
            if (objF0 instanceof InterfaceC1026q0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objF0).toString());
            }
            thF = null;
        }
        CancellationException cancellationException = thF instanceof CancellationException ? (CancellationException) thF : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new v0("Parent job is " + G0(objF0), thF, this);
    }

    @Override // Y6.InterfaceC1033u0
    public boolean c() {
        Object objF0 = f0();
        return (objF0 instanceof InterfaceC1026q0) && ((InterfaceC1026q0) objF0).c();
    }

    public final F0 c0(InterfaceC1026q0 interfaceC1026q0) {
        F0 f0D = interfaceC1026q0.d();
        if (f0D != null) {
            return f0D;
        }
        if (interfaceC1026q0 instanceof C1000d0) {
            return new F0();
        }
        if (interfaceC1026q0 instanceof z0) {
            C0((z0) interfaceC1026q0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC1026q0).toString());
    }

    public InterfaceC1033u0 d0() {
        InterfaceC1028s interfaceC1028sE0 = e0();
        if (interfaceC1028sE0 != null) {
            return interfaceC1028sE0.getParent();
        }
        return null;
    }

    @Override // Y6.InterfaceC1033u0
    public void e(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new v0(H(), null, this);
        }
        C(cancellationException);
    }

    public final InterfaceC1028s e0() {
        return (InterfaceC1028s) f9604b.get(this);
    }

    public final Object f0() {
        return f9603a.get(this);
    }

    @Override // s5.InterfaceC2711i.b
    public final InterfaceC2711i.c getKey() {
        return InterfaceC1033u0.f9694L;
    }

    @Override // Y6.InterfaceC1033u0
    public final boolean i0() {
        return !(f0() instanceof InterfaceC1026q0);
    }

    @Override // Y6.InterfaceC1033u0
    public final boolean isCancelled() {
        Object objF0 = f0();
        return (objF0 instanceof A) || ((objF0 instanceof c) && ((c) objF0).j());
    }

    public boolean j0(Throwable th) {
        return false;
    }

    public final void l0(InterfaceC1033u0 interfaceC1033u0) {
        if (interfaceC1033u0 == null) {
            E0(G0.f9625a);
            return;
        }
        interfaceC1033u0.start();
        InterfaceC1028s interfaceC1028sN = interfaceC1033u0.N(this);
        E0(interfaceC1028sN);
        if (i0()) {
            interfaceC1028sN.dispose();
            E0(G0.f9625a);
        }
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i m0(InterfaceC2711i interfaceC2711i) {
        return InterfaceC1033u0.a.e(this, interfaceC2711i);
    }

    public final InterfaceC0996b0 n0(boolean z7, z0 z0Var) {
        boolean z8;
        boolean zB;
        z0Var.x(this);
        while (true) {
            Object objF0 = f0();
            z8 = true;
            if (!(objF0 instanceof C1000d0)) {
                if (!(objF0 instanceof InterfaceC1026q0)) {
                    z8 = false;
                    break;
                }
                InterfaceC1026q0 interfaceC1026q0 = (InterfaceC1026q0) objF0;
                F0 f0D = interfaceC1026q0.d();
                if (f0D == null) {
                    AbstractC2304t.d(objF0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    C0((z0) objF0);
                } else {
                    if (z0Var.v()) {
                        c cVar = interfaceC1026q0 instanceof c ? (c) interfaceC1026q0 : null;
                        Throwable thF = cVar != null ? cVar.f() : null;
                        if (thF != null) {
                            if (z7) {
                                z0Var.w(thF);
                            }
                            return G0.f9625a;
                        }
                        zB = f0D.b(z0Var, 5);
                    } else {
                        zB = f0D.b(z0Var, 1);
                    }
                    if (zB) {
                        break;
                    }
                }
            } else {
                C1000d0 c1000d0 = (C1000d0) objF0;
                if (!c1000d0.c()) {
                    B0(c1000d0);
                } else if (AbstractC2965b.a(f9603a, this, objF0, z0Var)) {
                    break;
                }
            }
        }
        if (z8) {
            return z0Var;
        }
        if (z7) {
            Object objF02 = f0();
            A a8 = objF02 instanceof A ? (A) objF02 : null;
            z0Var.w(a8 != null ? a8.f9602a : null);
        }
        return G0.f9625a;
    }

    public boolean o0() {
        return false;
    }

    public final Object p0(Object obj) throws Throwable {
        Throwable thP = null;
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof c) {
                synchronized (objF0) {
                    if (((c) objF0).l()) {
                        return B0.f9617d;
                    }
                    boolean zJ = ((c) objF0).j();
                    if (obj != null || !zJ) {
                        if (thP == null) {
                            thP = P(obj);
                        }
                        ((c) objF0).a(thP);
                    }
                    Throwable thF = zJ ^ true ? ((c) objF0).f() : null;
                    if (thF != null) {
                        w0(((c) objF0).d(), thF);
                    }
                    return B0.f9614a;
                }
            }
            if (!(objF0 instanceof InterfaceC1026q0)) {
                return B0.f9617d;
            }
            if (thP == null) {
                thP = P(obj);
            }
            InterfaceC1026q0 interfaceC1026q0 = (InterfaceC1026q0) objF0;
            if (!interfaceC1026q0.c()) {
                Object objM0 = M0(objF0, new A(thP, false, 2, null));
                if (objM0 == B0.f9614a) {
                    throw new IllegalStateException(("Cannot happen in " + objF0).toString());
                }
                if (objM0 != B0.f9616c) {
                    return objM0;
                }
            } else if (L0(interfaceC1026q0, thP)) {
                return B0.f9614a;
            }
        }
    }

    public final boolean q0(Object obj) {
        Object objM0;
        do {
            objM0 = M0(f0(), obj);
            if (objM0 == B0.f9614a) {
                return false;
            }
            if (objM0 == B0.f9615b) {
                return true;
            }
        } while (objM0 == B0.f9616c);
        w(objM0);
        return true;
    }

    @Override // Y6.InterfaceC1033u0
    public final InterfaceC0996b0 r(boolean z7, boolean z8, B5.k kVar) {
        return n0(z8, z7 ? new C1029s0(kVar) : new C1031t0(kVar));
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c cVar) {
        return InterfaceC1033u0.a.d(this, cVar);
    }

    @Override // Y6.InterfaceC1033u0
    public final boolean start() {
        int iF0;
        do {
            iF0 = F0(f0());
            if (iF0 == 0) {
                return false;
            }
        } while (iF0 != 1);
        return true;
    }

    public final Object t0(Object obj) {
        Object objM0;
        do {
            objM0 = M0(f0(), obj);
            if (objM0 == B0.f9614a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, V(obj));
            }
        } while (objM0 == B0.f9616c);
        return objM0;
    }

    public String toString() {
        return J0() + '@' + P.b(this);
    }

    public String u0() {
        return P.a(this);
    }

    public final void v(Throwable th, List list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                AbstractC2477e.a(th, th2);
            }
        }
    }

    public final C1030t v0(C1654o c1654o) {
        while (c1654o.q()) {
            c1654o = c1654o.m();
        }
        while (true) {
            c1654o = c1654o.l();
            if (!c1654o.q()) {
                if (c1654o instanceof C1030t) {
                    return (C1030t) c1654o;
                }
                if (c1654o instanceof F0) {
                    return null;
                }
            }
        }
    }

    public final void w0(F0 f02, Throwable th) throws Throwable {
        y0(th);
        f02.g(4);
        Object objK = f02.k();
        AbstractC2304t.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        B b8 = null;
        for (C1654o c1654oL = (C1654o) objK; !AbstractC2304t.b(c1654oL, f02); c1654oL = c1654oL.l()) {
            if ((c1654oL instanceof z0) && ((z0) c1654oL).v()) {
                try {
                    ((z0) c1654oL).w(th);
                } catch (Throwable th2) {
                    if (b8 != null) {
                        AbstractC2477e.a(b8, th2);
                    } else {
                        b8 = new B("Exception in completion handler " + c1654oL + " for " + this, th2);
                        C2470H c2470h = C2470H.f21956a;
                    }
                }
            }
        }
        if (b8 != null) {
            k0(b8);
        }
        G(th);
    }

    public final Object x(InterfaceC2707e interfaceC2707e) throws Throwable {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof InterfaceC1026q0)) {
                if (objF0 instanceof A) {
                    throw ((A) objF0).f9602a;
                }
                return B0.h(objF0);
            }
        } while (F0(objF0) < 0);
        return y(interfaceC2707e);
    }

    public final void x0(F0 f02, Throwable th) throws Throwable {
        f02.g(1);
        Object objK = f02.k();
        AbstractC2304t.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        B b8 = null;
        for (C1654o c1654oL = (C1654o) objK; !AbstractC2304t.b(c1654oL, f02); c1654oL = c1654oL.l()) {
            if (c1654oL instanceof z0) {
                try {
                    ((z0) c1654oL).w(th);
                } catch (Throwable th2) {
                    if (b8 != null) {
                        AbstractC2477e.a(b8, th2);
                    } else {
                        b8 = new B("Exception in completion handler " + c1654oL + " for " + this, th2);
                        C2470H c2470h = C2470H.f21956a;
                    }
                }
            }
        }
        if (b8 != null) {
            k0(b8);
        }
    }

    public final Object y(InterfaceC2707e interfaceC2707e) {
        a aVar = new a(AbstractC2750b.c(interfaceC2707e), this);
        aVar.E();
        AbstractC1023p.a(aVar, y0.g(this, false, new J0(aVar), 1, null));
        Object objY = aVar.y();
        if (objY == AbstractC2751c.f()) {
            AbstractC2781h.c(interfaceC2707e);
        }
        return objY;
    }

    public final boolean z(Throwable th) {
        return A(th);
    }

    public void A0() {
    }

    public void k0(Throwable th) throws Throwable {
        throw th;
    }

    public void w(Object obj) {
    }

    public void y0(Throwable th) {
    }

    public void z0(Object obj) {
    }
}
