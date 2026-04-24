package m0;

import G4.l;
import a5.C;
import a5.C0307n;
import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import kotlin.jvm.internal.j;
import z.C1448f;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MeasurementManager f8452a;

    public e(MeasurementManager mMeasurementManager) {
        j.e(mMeasurementManager, "mMeasurementManager");
        this.f8452a = mMeasurementManager;
    }

    public static Object b(e eVar, AbstractC0854a abstractC0854a, I4.d dVar) {
        new C0307n(1, F1.h.z(dVar)).r();
        MeasurementManager measurementManager = eVar.f8452a;
        throw null;
    }

    public static Object d(e eVar, I4.d dVar) {
        C0307n c0307n = new C0307n(1, F1.h.z(dVar));
        c0307n.r();
        eVar.f8452a.getMeasurementApiStatus(new ExecutorC0856c(), new C1448f(c0307n));
        Object objQ = c0307n.q();
        J4.a aVar = J4.a.f791a;
        return objQ;
    }

    public static Object g(e eVar, Uri uri, InputEvent inputEvent, I4.d dVar) {
        C0307n c0307n = new C0307n(1, F1.h.z(dVar));
        c0307n.r();
        eVar.f8452a.registerSource(uri, inputEvent, new ExecutorC0856c(), new C1448f(c0307n));
        Object objQ = c0307n.q();
        return objQ == J4.a.f791a ? objQ : l.f540a;
    }

    public static Object h(e eVar, f fVar, I4.d dVar) throws Throwable {
        Object objE = C.e(new C0857d(eVar, null), dVar);
        return objE == J4.a.f791a ? objE : l.f540a;
    }

    public static Object j(e eVar, Uri uri, I4.d dVar) {
        C0307n c0307n = new C0307n(1, F1.h.z(dVar));
        c0307n.r();
        eVar.f8452a.registerTrigger(uri, new ExecutorC0856c(), new C1448f(c0307n));
        Object objQ = c0307n.q();
        return objQ == J4.a.f791a ? objQ : l.f540a;
    }

    public static Object l(e eVar, g gVar, I4.d dVar) {
        new C0307n(1, F1.h.z(dVar)).r();
        MeasurementManager measurementManager = eVar.f8452a;
        throw null;
    }

    public static Object n(e eVar, h hVar, I4.d dVar) {
        new C0307n(1, F1.h.z(dVar)).r();
        MeasurementManager measurementManager = eVar.f8452a;
        throw null;
    }

    public Object a(AbstractC0854a abstractC0854a, I4.d dVar) {
        return b(this, abstractC0854a, dVar);
    }

    public Object c(I4.d dVar) {
        return d(this, dVar);
    }

    public Object e(Uri uri, InputEvent inputEvent, I4.d dVar) {
        return g(this, uri, inputEvent, dVar);
    }

    public Object f(f fVar, I4.d dVar) {
        return h(this, fVar, dVar);
    }

    public Object i(Uri uri, I4.d dVar) {
        return j(this, uri, dVar);
    }

    public Object k(g gVar, I4.d dVar) {
        return l(this, gVar, dVar);
    }

    public Object m(h hVar, I4.d dVar) {
        return n(this, hVar, dVar);
    }
}
