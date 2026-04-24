package B0;

import E5.E;
import E5.q;
import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import b6.C1087p;
import b6.L;
import b6.M;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasurementManager f712b;

    public static final class a extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f715c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, l lVar, H5.d dVar) {
            super(2, dVar);
            this.f715c = lVar;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(null, this.f715c, dVar);
            aVar.f714b = obj;
            return aVar;
        }

        @Override // Q5.o
        public final Object invoke(L l7, H5.d dVar) {
            return ((a) create(l7, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            I5.c.e();
            if (this.f713a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            throw null;
        }
    }

    public l(MeasurementManager mMeasurementManager) {
        r.f(mMeasurementManager, "mMeasurementManager");
        this.f712b = mMeasurementManager;
    }

    public static /* synthetic */ Object h(l lVar, B0.a aVar, H5.d dVar) {
        new C1087p(I5.b.c(dVar), 1).A();
        lVar.i();
        throw null;
    }

    public static /* synthetic */ Object j(l lVar, H5.d dVar) {
        C1087p c1087p = new C1087p(I5.b.c(dVar), 1);
        c1087p.A();
        lVar.i().getMeasurementApiStatus(new k(), M.m.a(c1087p));
        Object objX = c1087p.x();
        if (objX == I5.c.e()) {
            J5.h.c(dVar);
        }
        return objX;
    }

    public static /* synthetic */ Object k(l lVar, m mVar, H5.d dVar) {
        Object objC = M.c(new a(mVar, lVar, null), dVar);
        return objC == I5.c.e() ? objC : E.f1657a;
    }

    public static /* synthetic */ Object l(l lVar, Uri uri, InputEvent inputEvent, H5.d dVar) {
        C1087p c1087p = new C1087p(I5.b.c(dVar), 1);
        c1087p.A();
        lVar.i().registerSource(uri, inputEvent, new k(), M.m.a(c1087p));
        Object objX = c1087p.x();
        if (objX == I5.c.e()) {
            J5.h.c(dVar);
        }
        return objX == I5.c.e() ? objX : E.f1657a;
    }

    public static /* synthetic */ Object m(l lVar, Uri uri, H5.d dVar) {
        C1087p c1087p = new C1087p(I5.b.c(dVar), 1);
        c1087p.A();
        lVar.i().registerTrigger(uri, new k(), M.m.a(c1087p));
        Object objX = c1087p.x();
        if (objX == I5.c.e()) {
            J5.h.c(dVar);
        }
        return objX == I5.c.e() ? objX : E.f1657a;
    }

    public static /* synthetic */ Object n(l lVar, n nVar, H5.d dVar) {
        new C1087p(I5.b.c(dVar), 1).A();
        lVar.i();
        throw null;
    }

    public static /* synthetic */ Object o(l lVar, o oVar, H5.d dVar) {
        new C1087p(I5.b.c(dVar), 1).A();
        lVar.i();
        throw null;
    }

    @Override // B0.b
    public Object a(B0.a aVar, H5.d dVar) {
        return h(this, aVar, dVar);
    }

    @Override // B0.b
    public Object b(H5.d dVar) {
        return j(this, dVar);
    }

    @Override // B0.b
    public Object c(m mVar, H5.d dVar) {
        return k(this, mVar, dVar);
    }

    @Override // B0.b
    public Object d(Uri uri, InputEvent inputEvent, H5.d dVar) {
        return l(this, uri, inputEvent, dVar);
    }

    @Override // B0.b
    public Object e(Uri uri, H5.d dVar) {
        return m(this, uri, dVar);
    }

    @Override // B0.b
    public Object f(n nVar, H5.d dVar) {
        return n(this, nVar, dVar);
    }

    @Override // B0.b
    public Object g(o oVar, H5.d dVar) {
        return o(this, oVar, dVar);
    }

    public final MeasurementManager i() {
        return this.f712b;
    }
}
