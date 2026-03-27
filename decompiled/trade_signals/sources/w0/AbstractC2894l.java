package w0;

import Y6.C1019n;
import Y6.L;
import Y6.M;
import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2750b;
import t5.AbstractC2751c;
import u5.AbstractC2781h;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: w0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2894l extends AbstractC2884b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasurementManager f23979b;

    /* JADX INFO: renamed from: w0.l$a */
    public static final class a extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f23981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC2894l f23982c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2895m abstractC2895m, AbstractC2894l abstractC2894l, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f23982c = abstractC2894l;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(null, this.f23982c, interfaceC2707e);
            aVar.f23981b = obj;
            return aVar;
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((a) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2751c.f();
            if (this.f23980a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
            throw null;
        }
    }

    public AbstractC2894l(MeasurementManager mMeasurementManager) {
        AbstractC2304t.f(mMeasurementManager, "mMeasurementManager");
        this.f23979b = mMeasurementManager;
    }

    public static /* synthetic */ Object h(AbstractC2894l abstractC2894l, AbstractC2883a abstractC2883a, InterfaceC2707e interfaceC2707e) {
        new C1019n(AbstractC2750b.c(interfaceC2707e), 1).E();
        abstractC2894l.i();
        throw null;
    }

    public static /* synthetic */ Object j(AbstractC2894l abstractC2894l, InterfaceC2707e interfaceC2707e) {
        C1019n c1019n = new C1019n(AbstractC2750b.c(interfaceC2707e), 1);
        c1019n.E();
        abstractC2894l.i().getMeasurementApiStatus(new ExecutorC2893k(), P.k.a(c1019n));
        Object objY = c1019n.y();
        if (objY == AbstractC2751c.f()) {
            AbstractC2781h.c(interfaceC2707e);
        }
        return objY;
    }

    public static /* synthetic */ Object k(AbstractC2894l abstractC2894l, Uri uri, InputEvent inputEvent, InterfaceC2707e interfaceC2707e) {
        C1019n c1019n = new C1019n(AbstractC2750b.c(interfaceC2707e), 1);
        c1019n.E();
        abstractC2894l.i().registerSource(uri, inputEvent, new ExecutorC2893k(), P.k.a(c1019n));
        Object objY = c1019n.y();
        if (objY == AbstractC2751c.f()) {
            AbstractC2781h.c(interfaceC2707e);
        }
        return objY == AbstractC2751c.f() ? objY : C2470H.f21956a;
    }

    public static /* synthetic */ Object l(AbstractC2894l abstractC2894l, AbstractC2895m abstractC2895m, InterfaceC2707e interfaceC2707e) {
        Object objC = M.c(new a(abstractC2895m, abstractC2894l, null), interfaceC2707e);
        return objC == AbstractC2751c.f() ? objC : C2470H.f21956a;
    }

    public static /* synthetic */ Object m(AbstractC2894l abstractC2894l, Uri uri, InterfaceC2707e interfaceC2707e) {
        C1019n c1019n = new C1019n(AbstractC2750b.c(interfaceC2707e), 1);
        c1019n.E();
        abstractC2894l.i().registerTrigger(uri, new ExecutorC2893k(), P.k.a(c1019n));
        Object objY = c1019n.y();
        if (objY == AbstractC2751c.f()) {
            AbstractC2781h.c(interfaceC2707e);
        }
        return objY == AbstractC2751c.f() ? objY : C2470H.f21956a;
    }

    public static /* synthetic */ Object n(AbstractC2894l abstractC2894l, AbstractC2896n abstractC2896n, InterfaceC2707e interfaceC2707e) {
        new C1019n(AbstractC2750b.c(interfaceC2707e), 1).E();
        abstractC2894l.i();
        throw null;
    }

    public static /* synthetic */ Object o(AbstractC2894l abstractC2894l, AbstractC2897o abstractC2897o, InterfaceC2707e interfaceC2707e) {
        new C1019n(AbstractC2750b.c(interfaceC2707e), 1).E();
        abstractC2894l.i();
        throw null;
    }

    @Override // w0.AbstractC2884b
    public Object a(AbstractC2883a abstractC2883a, InterfaceC2707e interfaceC2707e) {
        return h(this, abstractC2883a, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object b(InterfaceC2707e interfaceC2707e) {
        return j(this, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object c(Uri uri, InputEvent inputEvent, InterfaceC2707e interfaceC2707e) {
        return k(this, uri, inputEvent, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object d(AbstractC2895m abstractC2895m, InterfaceC2707e interfaceC2707e) {
        return l(this, abstractC2895m, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object e(Uri uri, InterfaceC2707e interfaceC2707e) {
        return m(this, uri, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object f(AbstractC2896n abstractC2896n, InterfaceC2707e interfaceC2707e) {
        return n(this, abstractC2896n, interfaceC2707e);
    }

    @Override // w0.AbstractC2884b
    public Object g(AbstractC2897o abstractC2897o, InterfaceC2707e interfaceC2707e) {
        return o(this, abstractC2897o, interfaceC2707e);
    }

    public final MeasurementManager i() {
        return this.f23979b;
    }
}
