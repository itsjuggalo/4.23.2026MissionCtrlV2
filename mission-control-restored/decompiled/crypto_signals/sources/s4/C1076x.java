package s4;

import android.util.Log;
import java.util.List;

/* JADX INFO: renamed from: s4.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1076x implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y3.d f9764b;

    public /* synthetic */ C1076x(Y3.d dVar, int i) {
        this.f9763a = i;
        this.f9764b = dVar;
    }

    @Override // R4.l
    public final Object invoke(Object obj) {
        List listC0;
        List listC02;
        G4.h hVar = (G4.h) obj;
        switch (this.f9763a) {
            case 0:
                Throwable thA = G4.h.a(hVar.f532a);
                Y3.d dVar = this.f9764b;
                if (thA != null) {
                    if (thA instanceof C1054a) {
                        C1054a c1054a = (C1054a) thA;
                        listC0 = H4.g.c0(new Object[]{c1054a.f9697a, c1054a.f9698b, c1054a.f9699c});
                    } else {
                        listC0 = H4.g.c0(new String[]{thA.getClass().getSimpleName(), thA.toString(), a3.d.m("Cause: ", thA.getCause(), ", Stacktrace: ", Log.getStackTraceString(thA))});
                    }
                    dVar.f(listC0);
                } else {
                    Object obj2 = hVar.f532a;
                    if (obj2 instanceof G4.g) {
                        obj2 = null;
                    }
                    dVar.f(y5.a.D((Boolean) obj2));
                }
                break;
            default:
                Throwable thA2 = G4.h.a(hVar.f532a);
                Y3.d dVar2 = this.f9764b;
                if (thA2 != null) {
                    if (thA2 instanceof C1054a) {
                        C1054a c1054a2 = (C1054a) thA2;
                        listC02 = H4.g.c0(new Object[]{c1054a2.f9697a, c1054a2.f9698b, c1054a2.f9699c});
                    } else {
                        listC02 = H4.g.c0(new String[]{thA2.getClass().getSimpleName(), thA2.toString(), a3.d.m("Cause: ", thA2.getCause(), ", Stacktrace: ", Log.getStackTraceString(thA2))});
                    }
                    dVar2.f(listC02);
                } else {
                    Object obj3 = hVar.f532a;
                    if (obj3 instanceof G4.g) {
                        obj3 = null;
                    }
                    dVar2.f(y5.a.D((String) obj3));
                }
                break;
        }
        return G4.l.f540a;
    }
}
