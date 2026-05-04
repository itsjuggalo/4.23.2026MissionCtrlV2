package h2;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import cd.h0;
import cd.s;
import id.m;
import kotlin.jvm.internal.t;
import ng.n0;
import ng.o0;
import ng.p;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasurementManager f10969b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f10972c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, h hVar, gd.e eVar) {
            super(2, eVar);
            this.f10972c = hVar;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(null, this.f10972c, eVar);
            aVar.f10971b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f10970a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            throw null;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public h(MeasurementManager mMeasurementManager) {
        t.f(mMeasurementManager, "mMeasurementManager");
        this.f10969b = mMeasurementManager;
    }

    public static /* synthetic */ Object h(h hVar, h2.a aVar, gd.e eVar) {
        new p(hd.b.c(eVar), 1).E();
        hVar.i();
        throw null;
    }

    public static /* synthetic */ Object j(h hVar, gd.e eVar) {
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        hVar.i().getMeasurementApiStatus(new g(), p0.j.a(pVar));
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY;
    }

    public static /* synthetic */ Object k(h hVar, Uri uri, InputEvent inputEvent, gd.e eVar) {
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        hVar.i().registerSource(uri, inputEvent, new g(), p0.j.a(pVar));
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : h0.f3852a;
    }

    public static /* synthetic */ Object l(h hVar, i iVar, gd.e eVar) {
        Object objC = o0.c(new a(iVar, hVar, null), eVar);
        return objC == hd.c.f() ? objC : h0.f3852a;
    }

    public static /* synthetic */ Object m(h hVar, Uri uri, gd.e eVar) {
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        hVar.i().registerTrigger(uri, new g(), p0.j.a(pVar));
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : h0.f3852a;
    }

    public static /* synthetic */ Object n(h hVar, j jVar, gd.e eVar) {
        new p(hd.b.c(eVar), 1).E();
        hVar.i();
        throw null;
    }

    public static /* synthetic */ Object o(h hVar, k kVar, gd.e eVar) {
        new p(hd.b.c(eVar), 1).E();
        hVar.i();
        throw null;
    }

    @Override // h2.b
    public Object a(h2.a aVar, gd.e eVar) {
        return h(this, aVar, eVar);
    }

    @Override // h2.b
    public Object b(gd.e eVar) {
        return j(this, eVar);
    }

    @Override // h2.b
    public Object c(Uri uri, InputEvent inputEvent, gd.e eVar) {
        return k(this, uri, inputEvent, eVar);
    }

    @Override // h2.b
    public Object d(i iVar, gd.e eVar) {
        return l(this, iVar, eVar);
    }

    @Override // h2.b
    public Object e(Uri uri, gd.e eVar) {
        return m(this, uri, eVar);
    }

    @Override // h2.b
    public Object f(j jVar, gd.e eVar) {
        return n(this, jVar, eVar);
    }

    @Override // h2.b
    public Object g(k kVar, gd.e eVar) {
        return o(this, kVar, eVar);
    }

    public final MeasurementManager i() {
        return this.f10969b;
    }
}
