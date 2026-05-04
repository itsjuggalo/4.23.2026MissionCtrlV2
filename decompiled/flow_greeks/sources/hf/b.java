package hf;

import fe.l1;
import fe.n0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11313a = new a();

        @Override // hf.b
        public String a(fe.h classifier, n renderer) {
            kotlin.jvm.internal.t.f(classifier, "classifier");
            kotlin.jvm.internal.t.f(renderer, "renderer");
            if (classifier instanceof l1) {
                ef.f name = ((l1) classifier).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                return renderer.R(name, false);
            }
            ef.d dVarM = jf.i.m(classifier);
            kotlin.jvm.internal.t.e(dVarM, "getFqName(...)");
            return renderer.Q(dVarM);
        }
    }

    /* JADX INFO: renamed from: hf.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0209b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0209b f11314a = new C0209b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [fe.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [fe.j0, fe.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [fe.m] */
        @Override // hf.b
        public String a(fe.h classifier, n renderer) {
            kotlin.jvm.internal.t.f(classifier, "classifier");
            kotlin.jvm.internal.t.f(renderer, "renderer");
            if (classifier instanceof l1) {
                ef.f name = ((l1) classifier).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                return renderer.R(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.b();
            } while (classifier instanceof fe.e);
            return g0.c(dd.x.K(arrayList));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11315a = new c();

        @Override // hf.b
        public String a(fe.h classifier, n renderer) {
            kotlin.jvm.internal.t.f(classifier, "classifier");
            kotlin.jvm.internal.t.f(renderer, "renderer");
            return b(classifier);
        }

        public final String b(fe.h hVar) {
            ef.f name = hVar.getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            String strB = g0.b(name);
            if (hVar instanceof l1) {
                return strB;
            }
            fe.m mVarB = hVar.b();
            kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
            String strC = c(mVarB);
            if (strC == null || kotlin.jvm.internal.t.b(strC, "")) {
                return strB;
            }
            return strC + com.amazon.a.a.o.c.a.b.f4610a + strB;
        }

        public final String c(fe.m mVar) {
            if (mVar instanceof fe.e) {
                return b((fe.h) mVar);
            }
            if (mVar instanceof n0) {
                return g0.a(((n0) mVar).e().i());
            }
            return null;
        }
    }

    String a(fe.h hVar, n nVar);
}
