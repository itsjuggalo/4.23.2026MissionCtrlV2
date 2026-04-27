package l0;

import W2.E;
import W2.q;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import kotlin.jvm.internal.r;
import t3.C1832p;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasurementManager f13438b;

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f13441c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, l lVar, Z2.e eVar) {
            super(2, eVar);
            this.f13441c = lVar;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(null, this.f13441c, eVar);
            aVar.f13440b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0787c.e();
            if (this.f13439a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            throw null;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((a) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public l(MeasurementManager mMeasurementManager) {
        r.f(mMeasurementManager, "mMeasurementManager");
        this.f13438b = mMeasurementManager;
    }

    public static /* synthetic */ Object h(l lVar, AbstractC1588a abstractC1588a, Z2.e eVar) {
        new C1832p(AbstractC0786b.c(eVar), 1).A();
        lVar.i();
        throw null;
    }

    public static /* synthetic */ Object j(l lVar, Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        lVar.i().getMeasurementApiStatus(new k(), D.k.a(c1832p));
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX;
    }

    public static /* synthetic */ Object k(l lVar, Uri uri, InputEvent inputEvent, Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        lVar.i().registerSource(uri, inputEvent, new k(), D.k.a(c1832p));
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : E.f5463a;
    }

    public static /* synthetic */ Object l(l lVar, m mVar, Z2.e eVar) {
        Object objE = M.e(new a(mVar, lVar, null), eVar);
        return objE == AbstractC0787c.e() ? objE : E.f5463a;
    }

    public static /* synthetic */ Object m(l lVar, Uri uri, Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        lVar.i().registerTrigger(uri, new k(), D.k.a(c1832p));
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : E.f5463a;
    }

    public static /* synthetic */ Object n(l lVar, n nVar, Z2.e eVar) {
        new C1832p(AbstractC0786b.c(eVar), 1).A();
        lVar.i();
        throw null;
    }

    public static /* synthetic */ Object o(l lVar, o oVar, Z2.e eVar) {
        new C1832p(AbstractC0786b.c(eVar), 1).A();
        lVar.i();
        throw null;
    }

    @Override // l0.b
    public Object a(AbstractC1588a abstractC1588a, Z2.e eVar) {
        return h(this, abstractC1588a, eVar);
    }

    @Override // l0.b
    public Object b(Z2.e eVar) {
        return j(this, eVar);
    }

    @Override // l0.b
    public Object c(Uri uri, InputEvent inputEvent, Z2.e eVar) {
        return k(this, uri, inputEvent, eVar);
    }

    @Override // l0.b
    public Object d(m mVar, Z2.e eVar) {
        return l(this, mVar, eVar);
    }

    @Override // l0.b
    public Object e(Uri uri, Z2.e eVar) {
        return m(this, uri, eVar);
    }

    @Override // l0.b
    public Object f(n nVar, Z2.e eVar) {
        return n(this, nVar, eVar);
    }

    @Override // l0.b
    public Object g(o oVar, Z2.e eVar) {
        return o(this, oVar, eVar);
    }

    public final MeasurementManager i() {
        return this.f13438b;
    }
}
